package racinggame;

import racinggame.car.Cars;
import racinggame.car.WinningCars;
import racinggame.input.InputService;
import racinggame.type.Message;

public class RacingCarGame {

	private final InputService inputService;

	private Cars cars;
	private Integer roundCount;

	public RacingCarGame() {
		this.inputService = new InputService();
	}

	public RacingCarGame(final Cars cars, final Integer roundCount) {
		this.inputService = new InputService();
		this.cars = cars;
		this.roundCount = roundCount;
	}

	public void reset() {
		resetCars();
		resetRoundCount();
	}

	private void resetRoundCount() {
		try {
			this.roundCount = inputService.nextRoundCount();
		} catch (final IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
			resetRoundCount();
		}
	}

	private void resetCars() {
		try {
			this.cars = new Cars(inputService.nextCarNames());
		} catch (final IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
			resetCars();
		}
	}

	public void doGame() {
		System.out.println();
		System.out.println(Message.GAME_RESULT_TITLE);

		for (int i = 0; i < roundCount; i++) {
			progressGame();
			System.out.println();
		}
	}

	private void progressGame() {
		cars.driveAll();

		for (int j = 0; j < cars.size(); j++) {
			System.out.println(Message.getCarOutput(cars.getCar(j)));
		}
	}

	public void afterGame() {
		final WinningCars winningCars = WinningCars.of(cars);
		System.out.println(Message.getWinning(winningCars));
	}
}
