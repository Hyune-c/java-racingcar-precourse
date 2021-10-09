package racinggame;

import static racinggame.view.OutputView.*;

import racinggame.car.Cars;
import racinggame.car.WinningCars;
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
		} catch (final IllegalArgumentException ex) {
			printException(ex);
			resetRoundCount();
		}
	}

	private void resetCars() {
		try {
			this.cars = new Cars(inputService.nextCarNames());
		} catch (final IllegalArgumentException ex) {
			printException(ex);
			resetCars();
		}
	}

	public void doGame() {
		println();
		printResultTitle();

		for (int i = 0; i < roundCount; i++) {
			progressGame();
			println();
		}
	}

	private void progressGame() {
		cars.driveAll();

		for (int j = 0; j < cars.size(); j++) {
			printCarOutput(cars.getCar(j));
		}
	}

	public void afterGame() {
		final WinningCars winningCars = WinningCars.of(cars);
		printWinningCars(winningCars);
	}
}
