package racinggame.car;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("우승한 자동차들")
class WinningCarsTest {

	private static final int GO = 9;
	private static final List<String> CAR_NAMES = Arrays.asList("hyune", "honux", "pobi", "toto");

	@DisplayName("생성")
	@Test
	void create() {
		// given
		final NormalCars normalCars = NormalCars.of(CAR_NAMES);

		// 총 4 대의 자동차 중 2 대가 우승
		normalCars.get(1).drive(GO);
		normalCars.get(2).drive(GO);
		normalCars.get(2).drive(GO);
		normalCars.get(3).drive(GO);
		normalCars.get(3).drive(GO);

		// when
		final WinningCars winningCars = WinningCars.of(normalCars);

		// then
		assertThat(winningCars.size()).isEqualTo(2);
		assertThat(winningCars.getCars().get(0).getTotalDistance()).isEqualTo(2);
	}
}
