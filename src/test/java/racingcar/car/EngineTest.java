package racingcar.car;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.common.exception.ErrorCode;
import racingcar.common.exception.ValidationException;
import racingcar.common.type.DriveType;
import racingcar.config.Property;

@DisplayName("엔진")
class EngineTest {

	public static String[] stopInputs() {
		List<String> list = new ArrayList<>();
		for (int i = Property.MIN_RANDOM_NUMBER; i < Property.DRIVE_STANDARD_NUMBER - 1; i++) {
			list.add(String.valueOf(i));
		}
		return list.toArray(new String[0]);
	}

	@DisplayName("[성공] 주행 시도 - 정지")
	@ParameterizedTest
	@MethodSource("stopInputs")
	void success_drive_stop(Integer input) {
		// given
		Engine engine = new Engine();

		// when
		DriveType result = engine.drive(input);

		// then
		assertThat(result).isEqualTo(DriveType.STOP);
	}

	public static String[] goInputs() {
		List<String> list = new ArrayList<>();
		int bound = Property.MAX_RANDOM_NUMBER;
		for (int i = Property.DRIVE_STANDARD_NUMBER; i < bound; i++) {
			list.add(String.valueOf(i));
		}
		return list.toArray(new String[0]);
	}

	@DisplayName("[성공] 주행 시도 - 전진")
	@ParameterizedTest
	@MethodSource("goInputs")
	void success_drive_go(Integer input) {
		// given
		Engine engine = new Engine();

		// when
		DriveType result = engine.drive(input);

		// then
		assertThat(result).isEqualTo(DriveType.GO);
	}

	public static String[] failedInputs() {
		return new String[] {"-10", "-1", "10", "50"};
	}

	@DisplayName("[실패] 주행 시도")
	@ParameterizedTest
	@MethodSource("failedInputs")
	void failed_drive(Integer input) {
		// given
		Engine engine = new Engine();

		// when
		ValidationException exception = assertThrows(ValidationException.class, () -> engine.drive(input));

		// then
		assertThat(exception.getErrorCode()).isEqualTo(ErrorCode.NOT_VALID_DRIVE_INPUT);
	}
}
