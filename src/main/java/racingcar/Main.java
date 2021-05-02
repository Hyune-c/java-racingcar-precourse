package racingcar;

public class Main {

	public static void main(String[] args) {
		RacingCarGame racingCarGame = new RacingCarGame();
		racingCarGame.reset();
		racingCarGame.doGame();
		racingCarGame.afterGame();
	}
}
