package racingcar.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import racinggame.car.Name;
import racinggame.exception.NameCreateException;

@DisplayName("이름")
class NameTest {

	public static String[] validNames() {
		return new String[] {"현이", "호눅스눅스", "hyune", "pobi", "crong", "honux"};
	}

	@DisplayName("[성공] 이름 생성")
	@ParameterizedTest
	@MethodSource("validNames")
	void success_create(final String name) {
		// given

		// when
		final Name carName = new Name(name);

		// then
		assertThat(carName.getName()).isEqualTo(name);
	}

	public static String[] notValidNames() {
		return new String[] {"포비포비포비", "hyune111", "", "hy ne", " hyne", "hyne ", "crongcrong", "hye-1", "hy!!"};
	}

	@DisplayName("[실패] 이름 생성")
	@ParameterizedTest
	@MethodSource("notValidNames")
	void failed_create(final String name) {
		// given

		// when
		assertThatExceptionOfType(NameCreateException.class)
			.isThrownBy(() -> new Name(name));

		// then

	}
}