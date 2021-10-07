package racinggame.car;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.exception.CarAddException;

@DisplayName("자동차들")
class CarsTest {

	private static final int DRIVE_GO_INPUT = 9;
	private static final int TARGET_INDEX = 0;
	private static final List<String> CAR_NAMES = Arrays.asList("hyune", "honux", "pobi");

	@DisplayName("생성")
	@Test
	void create() {
		// given
		final int expectedSize = CAR_NAMES.size();

		// when
		final Cars cars = new Cars(CAR_NAMES);

		// then
		assertThat(cars.size()).isEqualTo(expectedSize);
		for (int i = 0; i < cars.size(); i++) {
			final Car car = cars.getCar(i);
			assertThat(car.getName()).isNotNull();
		}
	}

	@DisplayName("생성 - 이미 존재하는 자동차")
	@Test
	void create_existCar() {
		// given
		final List<String> carNames = Arrays.asList("hyune", "honux", "hyune");

		// when
		assertThatExceptionOfType(CarAddException.class)
			.isThrownBy(() -> new Cars(carNames));

		// then

	}

	@DisplayName("정렬")
	@Test
	void sort() {
		// given
		final Cars cars = new Cars(CAR_NAMES);

		// totalDistance 조작. 0,1,2
		cars.getCar(1).drive(DRIVE_GO_INPUT);
		cars.getCar(2).drive(DRIVE_GO_INPUT);
		cars.getCar(2).drive(DRIVE_GO_INPUT);

		final int beforeTotalDistance = cars.getCar(TARGET_INDEX).getTotalDistance();

		// when
		cars.sort();

		// then
		final int afterTotalDistance = cars.getCar(TARGET_INDEX).getTotalDistance();
		assertThat(beforeTotalDistance).isNotEqualTo(afterTotalDistance);

		System.out.println(
			"### beforeTotalDistance: " + beforeTotalDistance +
				", afterTotalDistance: " + afterTotalDistance);
	}
}
