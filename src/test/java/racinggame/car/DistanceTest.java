package racinggame.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racinggame.type.DriveType;

/**
 * ParameterizedTest 와 Stream<Arguments> 을 사용하면 테스트 코드를 간소화할 수 있지만,
 * Stream 의 사용이 제한되어 수동으로 테스트 케이스를 만들었습니다.
 */
@DisplayName("주행 거리")
class DistanceTest {

	@DisplayName("총 주행 거리")
	@ParameterizedTest
	@CsvSource({
		"4,GO,GO,GO,GO",
		"3,GO,STOP,GO,GO",
		"3,GO,GO,GO,STOP",
		"1,STOP,STOP,GO,STOP",
		"0,STOP,STOP,STOP,STOP",
	})
	void totalDistance(final int expectedDistance, final DriveType drive1, final DriveType drive2,
		final DriveType drive3, final DriveType drive4) {
		// given
		final Distance distance = Distance.of();
		distance.add(drive1);
		distance.add(drive2);
		distance.add(drive3);
		distance.add(drive4);

		// when
		final Integer result = distance.sum();

		// then
		assertThat(result).isEqualTo(expectedDistance);
	}
}
