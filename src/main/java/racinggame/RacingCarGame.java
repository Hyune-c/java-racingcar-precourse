package racinggame;

import static racinggame.view.OutputView.*;

import racinggame.car.Cars;
import racinggame.car.WinningCars;
import racinggame.view.InputView;

public class RacingCarGame {

	private Cars cars;
	private Integer roundCount;

	public RacingCarGame() {
	}

	public RacingCarGame(final Cars cars, final Integer roundCount) {
		this.cars = cars;
		this.roundCount = roundCount;
	}

	public void reset() {
		resetCars();
		resetRoundCount();
	}

	private void resetRoundCount() {
		try {
			this.roundCount = InputView.nextRoundCount();
		} catch (final IllegalArgumentException ex) {
			printException(ex);
			resetRoundCount();
		}
	}

	private void resetCars() {
		try {
			this.cars = new Cars(InputView.nextCarNames());
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
