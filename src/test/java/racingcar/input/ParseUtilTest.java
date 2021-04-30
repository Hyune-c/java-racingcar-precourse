package racingcar.input;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * ParameterizedTest 와 Stream<Arguments> 을 사용하면 테스트 코드를 간소화할 수 있지만,
 * Stream 의 사용이 제한되어 수동으로 테스트 케이스를 만들었습니다.
 */
@DisplayName("파싱 유틸")
class ParseUtilTest {

	@DisplayName("[성공] 파싱")
	@Test
	void success_parse() {
		// given
		String input = "pobi,honux,crong";
		int resultCount = input.split(",").length;

		// when
		List<String> results = ParseUtil.parse(input);

		// then
		assertThat(results.size()).isEqualTo(resultCount);
	}
}
