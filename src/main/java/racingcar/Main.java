package racingcar;

public class Main {

	public static void main(final String[] args) {
		final RacingCarGame racingCarGame = new RacingCarGame();
		racingCarGame.reset();
		racingCarGame.doGame();
		racingCarGame.afterGame();
	}
}
