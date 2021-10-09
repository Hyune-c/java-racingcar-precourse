package racinggame.controller;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.car.Cars;

@DisplayName("레이싱 게임")
class RacingGameControllerTest {

	@DisplayName("에러 없이 정상 진행")
	@Test
	void success() {
		// given
		final List<String> carNames = Arrays.asList("hyune", "honux", "pobi", "crong", "java", "velog");
		final int roundCount = 20;

		// when
		final RacingGameController racingGameController = RacingGameController.of(new Cars(carNames), roundCount);
		racingGameController.doGame();
		racingGameController.afterGame();

		// then

	}
}
