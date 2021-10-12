package racinggame.controller;

import static racinggame.view.OutputView.*;

import racinggame.car.Car;
import racinggame.car.NormalCars;
import racinggame.car.WinningCars;
import racinggame.view.InputView;

public class RacingGameController {

	private final NormalCars normalCars;
	private final RoundCount roundCount;

	private RacingGameController(final NormalCars normalCars, final RoundCount roundCount) {
		this.normalCars = normalCars;
		this.roundCount = roundCount;
	}

	public static RacingGameController of() {
		return new RacingGameController(inputCars(), inputRoundCount());
	}

	public static RacingGameController of(final NormalCars normalCars, final RoundCount roundCount) {
		return new RacingGameController(normalCars, roundCount);
	}

	private static NormalCars inputCars() {
		try {
			return NormalCars.of(InputView.nextCarNames());
		} catch (final IllegalArgumentException ex) {
			printException(ex);
			return inputCars();
		}
	}

	private static RoundCount inputRoundCount() {
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

		for (int i = 0; i < roundCount.getValue(); i++) {
			progressGame();
			println();
		}
	}

	private void progressGame() {
		normalCars.driveAll();

		for (final Car car : normalCars.getCars()) {
			printCarOutput(car);
		}
	}

	public void afterGame() {
		final WinningCars winningCars = WinningCars.of(normalCars);
		printCars(winningCars);
	}
}
