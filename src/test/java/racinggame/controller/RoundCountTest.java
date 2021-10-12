package racinggame.controller;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racinggame.exception.RoundCountCreateException;

@DisplayName("라운드 수")
class RoundCountTest {

	@DisplayName("생성")
	@ParameterizedTest
	@ValueSource(ints = {
		1, 99, 500, 1_000
	})
	void create(final int input) {
		// given

		// when
		final RoundCount roundCount = RoundCount.of(input);

		// then
		assertThat(roundCount.getValue()).isEqualTo(input);
	}

	@DisplayName("생성 - 유효하지 않은 초기 값")
	@ParameterizedTest
	@ValueSource(ints = {
		-1, 0
	})
	void create_invalid(final int input) {
		// given

		// when
		assertThatExceptionOfType(RoundCountCreateException.class)
			.isThrownBy(() -> RoundCount.of(input));

		// then

	}
}
