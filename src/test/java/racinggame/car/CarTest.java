package racinggame.car;

import static org.assertj.core.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("자동차")
class CarTest {

	private static final int DRIVE_GO_INPUT = 9;
	private static final int DRIVE_STOP_INPUT = 0;
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
		final Random random = new Random();

		// when
		final Car car = new Car(name);
		for (int i = 0; i < ROUND_COUNT; i++) {
			final Integer nextInt = random.nextInt(DRIVE_GO_INPUT);
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
		final Car car1 = new Car(name);
		car1.drive(DRIVE_GO_INPUT);
		final Car car2 = new Car(car1);

		assertThat(car1.getTotalDistance()).isEqualTo(car2.getTotalDistance());

		// when
		car2.drive(DRIVE_GO_INPUT);

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
		final Car car1 = new Car(name1);
		final Car car2 = new Car(name2);

		// then
		assertThat(car1.equals(car2)).isEqualTo(expected);
	}

	@DisplayName("대소 비교")
	@Test
	void compare() {
		// given
		final Car car1 = new Car("hyune");
		final Car car2 = new Car("honux");

		// when
		car1.drive(DRIVE_GO_INPUT);
		car2.drive(DRIVE_STOP_INPUT);

		// then
		assertThat(car2).isGreaterThan(car1);
	}
}
