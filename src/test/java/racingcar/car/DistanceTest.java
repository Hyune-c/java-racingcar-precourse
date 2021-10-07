package racingcar.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racinggame.type.DriveType;
import racinggame.car.Distance;

/**
 * ParameterizedTest 와 Stream<Arguments> 을 사용하면 테스트 코드를 간소화할 수 있지만,
 * Stream 의 사용이 제한되어 수동으로 테스트 케이스를 만들었습니다.
 */
@DisplayName("주행 거리")
class DistanceTest {

	@DisplayName("[성공] 총 주행 거리")
	@ParameterizedTest
	@CsvSource({
		"4,GO,GO,GO,GO",
		"3,GO,STOP,GO,GO",
		"3,GO,GO,GO,STOP",
		"1,STOP,STOP,GO,STOP",
		"0,STOP,STOP,STOP,STOP",
	})
	public void success_getTotal(final Integer driveDistance, final DriveType driveType1, final DriveType driveType2,
		final DriveType driveType3,
		final DriveType driveType4) {
		// given
		final Distance distance = new Distance();
		distance.add(driveType1);
		distance.add(driveType2);
		distance.add(driveType3);
		distance.add(driveType4);

		// when
		final Integer result = distance.sum();

		// then
		assertThat(result).isEqualTo(driveDistance);
	}
}
