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
		final Cars cars = new Cars(CAR_NAMES);

		// 총 4 대의 자동차 중 2 대가 우승
		cars.get(1).drive(GO);
		cars.get(2).drive(GO);
		cars.get(2).drive(GO);
		cars.get(3).drive(GO);
		cars.get(3).drive(GO);

		// when
		final WinningCars winningCars = WinningCars.of(cars);

		// then
		assertThat(winningCars.size()).isEqualTo(2);
		assertThat(winningCars.getCars().get(0).getTotalDistance()).isEqualTo(2);
	}
}
