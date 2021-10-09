package racinggame.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import racinggame.exception.NameCreateException;

@DisplayName("이름")
class NameTest {

	@DisplayName("생성")
	@ParameterizedTest
	@CsvSource({
		"현이", "호눅스눅스", "hyune", "pobi", "crong", "honux"
	})
	void create(final String name) {
		// given

		// when
		final Name carName = Name.of(name);

		// then
		assertThat(carName.getName()).isEqualTo(name);
	}

	public static String[] create_invalid() {
		return new String[] {"포비포비포비", "hyune111", "", "hy ne", " hyne", "hyne ", "crongcrong", "hye-1", "hy!!"};
	}

	@DisplayName("생성 - 유효하지 않은 초기 값")
	@ParameterizedTest
	@MethodSource
	void create_invalid(final String name) {
		// given

		// when
		assertThatExceptionOfType(NameCreateException.class)
			.isThrownBy(() -> Name.of(name));

		// then

	}
}
