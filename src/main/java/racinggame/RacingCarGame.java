package racinggame;

import racinggame.car.Cars;
import racinggame.exception.ValidationException;
import racinggame.type.Message;
import racinggame.input.InputService;

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
		} catch (final ValidationException | NumberFormatException ex) {
			System.out.println(Message.RETRY_ROUND_COUNT);
			resetRoundCount();
		}
	}

	private void resetCars() {
		try {
			this.cars = new Cars(inputService.nextCarNames());
		} catch (final ValidationException ex) {
			System.out.println(Message.RETRY_CAR_NAMES);
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
		final Cars winningCars = getFarthestCars(cars);
		System.out.println(Message.getWinning(winningCars));
	}

	private Cars getFarthestCars(final Cars cars) {
		final Cars baseCars = new Cars(cars);
		baseCars.sort();
		final Cars farthestCars = new Cars();
		farthestCars.add(baseCars.getCar(0));

		for (int i = 1; i < baseCars.size()
			&& farthestCars.getCar(0).getTotalDistance().equals(baseCars.getCar(i).getTotalDistance()); i++) {
			farthestCars.add(baseCars.getCar(i));
		}

		return farthestCars;
	}
}
