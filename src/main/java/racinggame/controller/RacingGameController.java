package racinggame.controller;

import static racinggame.view.OutputView.*;

import racinggame.car.Car;
import racinggame.car.Cars;
import racinggame.car.WinningCars;
import racinggame.view.InputView;

public class RacingGameController {

	private final Cars cars;
	private final int roundCount;

	private RacingGameController(final Cars cars, final Integer roundCount) {
		this.cars = cars;
		this.roundCount = roundCount;
	}

	public static RacingGameController of() {
		return new RacingGameController(inputCars(), inputRoundCount());
	}

	public static RacingGameController of(final Cars cars, final Integer roundCount) {
		return new RacingGameController(cars, roundCount);
	}

	private static Cars inputCars() {
		try {
			return new Cars(InputView.nextCarNames());
		} catch (final IllegalArgumentException ex) {
			printException(ex);
			return inputCars();
		}
	}

	private static int inputRoundCount() {
		try {
			return InputView.nextRoundCount();
		} catch (final IllegalArgumentException ex) {
			printException(ex);
			return inputRoundCount();
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

		for (final Car car : cars.getCars()) {
			printCarOutput(car);
		}
	}

	public void afterGame() {
		final WinningCars winningCars = WinningCars.of(cars);
		printWinningCars(winningCars);
	}
}
