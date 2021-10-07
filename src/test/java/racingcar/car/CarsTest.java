package racingcar.car;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.exception.ErrorCode;
import racinggame.exception.ValidationException;
import racinggame.car.Cars;

@DisplayName("자동차들")
class CarsTest {

	private static int driveGoInput;
	private static int targetIndex;

	@BeforeAll
	public static void beforeAll() {
		driveGoInput = 9;
		targetIndex = 0;
	}

	@DisplayName("[성공] 생성")
	@Test
	public void success_create() {
		// given
		final List<String> carNames = Arrays.asList("hyune", "honux", "pobi");
		final int expectedSize = carNames.size();

		// when
		final Cars cars = new Cars(carNames);

		// then
		assertThat(cars.size()).isEqualTo(expectedSize);
		for (int i = 0; i < cars.size(); i++) {
			assertThat(cars.getCar(i).getName()).isNotNull();
		}
	}

	@DisplayName("[실패] 생성 - 이미 존재하는 자동차")
	@Test
	public void failed_create() {
		// given
		final List<String> carNames = Arrays.asList("hyune", "honux", "hyune");

		// when
		final ValidationException exception = assertThrows(ValidationException.class, () -> new Cars(carNames));

		// then
		assertThat(exception.getErrorCode()).isEqualTo(ErrorCode.ALREADY_EXISTS_CAR);
	}

	@DisplayName("[성공] 정렬")
	@Test
	public void success_sort() {
		// given
		final List<String> carNames = Arrays.asList("hyune", "honux", "pobi");
		final Cars cars = new Cars(carNames);

		// totalDistance 조작. 0,1,2
		cars.getCar(1).drive(driveGoInput);
		cars.getCar(2).drive(driveGoInput);
		cars.getCar(2).drive(driveGoInput);

		final int beforeTotalDistance = cars.getCar(targetIndex).getTotalDistance();

		// when
		cars.sort();

		// then
		final int afterTotalDistance = cars.getCar(targetIndex).getTotalDistance();
		assertThat(beforeTotalDistance).isNotEqualTo(afterTotalDistance);

		System.out.println(
			"### beforeTotalDistance: " + beforeTotalDistance + ", afterTotalDistance: " + afterTotalDistance);
	}
}
