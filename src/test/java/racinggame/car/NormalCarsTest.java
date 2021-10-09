package racinggame.car;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.exception.CarAddException;

@DisplayName("자동차들")
class NormalCarsTest {

	private static final List<String> CAR_NAMES = Arrays.asList("hyune", "honux", "pobi");

	@DisplayName("생성")
	@Test
	void create() {
		// given
		final int expectedSize = CAR_NAMES.size();

		// when
		final NormalCars normalCars = NormalCars.of(CAR_NAMES);

		// then
		assertThat(normalCars.size()).isEqualTo(expectedSize);
		for (int i = 0; i < normalCars.size(); i++) {
			final Car car = normalCars.get(i);
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
			.isThrownBy(() -> NormalCars.of(carNames));

		// then

	}
}
