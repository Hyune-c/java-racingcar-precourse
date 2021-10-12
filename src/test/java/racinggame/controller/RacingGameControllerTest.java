package racinggame.controller;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.car.NormalCars;

@DisplayName("레이싱 게임")
class RacingGameControllerTest {

	@DisplayName("에러 없이 정상 진행")
	@Test
	void success() {
		// given
		final List<String> carNames = Arrays.asList("hyune", "honux", "pobi", "crong", "java", "velog");
		final RoundCount roundCount = RoundCount.of(20);

		// when
		final RacingGameController racingGameController = RacingGameController.of(NormalCars.of(carNames), roundCount);
		racingGameController.doGame();
		racingGameController.afterGame();

		// then

	}
}
