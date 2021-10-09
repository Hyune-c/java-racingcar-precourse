package racinggame.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import nextstep.utils.Randoms;

@DisplayName("자동차")
class CarTest {

	private static final int GO = 9;
	private static final int STOP = 0;
	private static final int ROUND_COUNT = 5;

	/**
	 * 자동차를 구성하는 모든 객체는 각각 세부적인 단위 테스트가 구현되어 있습니다.
	 * 따라서 여기서는 코너 테스트가 아닌 전체 기능의 흐름만 테스트 합니다.
	 */
	@DisplayName("기능 테스트")
	@RepeatedTest(100)
	void success() {
		// given
		final String name = "hyune";

		// when
		final Car car = Car.of(name);
		for (int i = 0; i < ROUND_COUNT; i++) {
			final Integer nextInt = Randoms.pickNumberInRange(1, GO);
			car.drive(nextInt);
		}

		// then
		assertThat(car.getTotalDistance()).isBetween(0, ROUND_COUNT);
		System.out.println("### totalDistance: " + car.getTotalDistance());

		assertThat(car.getName()).isEqualTo(name);
	}

	@DisplayName("깊은 복사")
	@Test
	void deepCopy() {
		// given
		final String name = "hyune";
		final Car car1 = Car.of(name);
		car1.drive(GO);
		final Car car2 = Car.of(car1);

		assertThat(car1.getTotalDistance()).isEqualTo(car2.getTotalDistance());

		// when
		car2.drive(GO);

		// then
		assertThat(car2.getTotalDistance()).isGreaterThan(car1.getTotalDistance());
	}

	@DisplayName("동등성 비교")
	@ParameterizedTest
	@CsvSource({
		"hyune,hyune,true",
		"hyune,honux,false",
	})
	void equal(final String name1, final String name2, final boolean expected) {
		// given

		// when
		final Car car1 = Car.of(name1);
		final Car car2 = Car.of(name2);

		// then
		assertThat(car1.equals(car2)).isEqualTo(expected);
	}

	@DisplayName("대소 비교")
	@Test
	void compare() {
		// given
		final Car car1 = Car.of("hyune");
		final Car car2 = Car.of("honux");

		// when
		car1.drive(GO);
		car2.drive(STOP);

		// then
		assertThat(car2).isGreaterThan(car1);
	}
}
