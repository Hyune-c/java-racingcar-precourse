package racinggame;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.car.Cars;
import racinggame.RacingCarGame;

@DisplayName("레이싱카 게임")
class RacingCarGameTest {

	@DisplayName("[성공] 에러 없이 정상 진행")
	@Test
	void success_doGame() {
		// given
		final List<String> carNames = Arrays.asList("hyune", "honux", "pobi", "crong", "java", "velog");
		final int roundCount = 20;

		// when
		final RacingCarGame racingCarGame = new RacingCarGame(new Cars(carNames), roundCount);
		racingCarGame.doGame();
		racingCarGame.afterGame();

		// then

	}
}
