package racingcar.car;

import static org.assertj.core.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

@DisplayName("자동차")
public class CarTest {

	private static int driveGoInput;
	private static int driveStopInput;
	private static int roundCount;

	@BeforeAll
	public static void beforeAll() {
		driveGoInput = 9;
		driveStopInput = 0;
		roundCount = 5;
	}

	/**
	 * 자동차를 구성하는 모든 객체는 각각 세부적인 단위 테스트가 구현되어 있습니다.
	 * 따라서 여기서는 코너 테스트가 아닌 전체 기능의 흐름만 테스트 합니다.
	 */
	@DisplayName("[성공] 기능 테스트")
	@RepeatedTest(100)
	public void success() {
		// given
		String name = "hyune";
		Random random = new Random();

		// when
		Car car = new Car(name);
		for (int i = 0; i < roundCount; i++) {
			car.drive(random.nextInt(driveGoInput));
		}

		// then
		assertThat(car.getTotalDistance()).isBetween(0, roundCount);
		System.out.println("### totalDistance: " + car.getTotalDistance());

		assertThat(car.getName()).isEqualTo(name);
	}

	@DisplayName("[성공] 깊은 복사")
	@Test
	public void success_deepCopy() {
		// given
		String name = "hyune";
		Car car1 = new Car(name);
		car1.drive(driveGoInput);
		Car car2 = new Car(car1);

		assertThat(car1.getTotalDistance()).isEqualTo(car2.getTotalDistance());

		// when
		car2.drive(driveGoInput);

		// then
		assertThat(car2.getTotalDistance()).isGreaterThan(car1.getTotalDistance());
	}

	@DisplayName("[성공] equal - true")
	@Test
	public void success_equal_true() {
		// given
		String name = "hyune";

		// when
		Car car1 = new Car(name);
		Car car2 = new Car(name);

		// then
		assertThat(car1).isEqualTo(car2);
	}

	@DisplayName("[성공] equal - false")
	@Test
	public void success_equal_false() {
		// given
		String name1 = "hyune";
		String name2 = "honux";

		// when
		Car car1 = new Car(name1);
		Car car2 = new Car(name2);

		// then
		assertThat(car1).isNotEqualTo(car2);
	}

	@DisplayName("[성공] compare")
	@Test
	public void success_compare() {
		// given
		String name1 = "hyune";
		String name2 = "honux";
		Car car1 = new Car(name1);
		Car car2 = new Car(name2);

		// when
		car1.drive(driveGoInput);
		car2.drive(driveStopInput);

		// then
		assertThat(car2).isGreaterThan(car1);
	}
}
