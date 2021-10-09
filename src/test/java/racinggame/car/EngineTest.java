package racinggame.car;

import static org.assertj.core.api.Assertions.*;
import static racinggame.config.Property.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import racinggame.exception.EngineDriveNotValidException;
import racinggame.type.DriveType;

@DisplayName("엔진")
class EngineTest {

	public static String[] drive_stop() {
		final List<String> list = new ArrayList<>();
		for (int i = MIN_RANDOM_NUMBER; i < DRIVE_STANDARD_NUMBER; i++) {
			list.add(String.valueOf(i));
		}
		return list.toArray(new String[0]);
	}

	@DisplayName("주행 - 정지")
	@ParameterizedTest
	@MethodSource
	void drive_stop(final int input) {
		// given
		final Engine engine = Engine.of();

		// when
		final DriveType result = engine.drive(input);

		// then
		assertThat(result).isEqualTo(DriveType.STOP);
	}

	public static String[] drive_go() {
		final List<String> list = new ArrayList<>();
		for (int i = DRIVE_STANDARD_NUMBER; i < MAX_RANDOM_NUMBER; i++) {
			list.add(String.valueOf(i));
		}
		return list.toArray(new String[0]);
	}

	@DisplayName("주행 - 전진")
	@ParameterizedTest
	@MethodSource
	void drive_go(final int input) {
		// given
		final Engine engine = Engine.of();

		// when
		final DriveType result = engine.drive(input);

		// then
		assertThat(result).isEqualTo(DriveType.GO);
	}

	public static String[] drive_invalid() {
		return new String[] {"-10", "-1", "10", "50"};
	}

	@DisplayName("주행 - 유효하지 않은 초기 값")
	@ParameterizedTest
	@MethodSource
	void drive_invalid(final int input) {
		// given
		final Engine engine = Engine.of();

		// when
		assertThatExceptionOfType(EngineDriveNotValidException.class)
			.isThrownBy(() -> engine.drive(input));

		// then

	}
}
