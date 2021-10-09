package racinggame;

import racinggame.controller.RacingGameController;

public class Application {

	public static void main(final String[] args) {
		final RacingGameController racingGameController = RacingGameController.of();
		racingGameController.doGame();
		racingGameController.afterGame();
	}
}
