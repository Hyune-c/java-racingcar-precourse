package racingcar.car;

import racingcar.common.exception.ErrorCode;
import racingcar.common.exception.ValidationException;
import racingcar.common.type.DriveType;
import racingcar.config.Property;

public class Engine {

	private static final Integer MIN_NUMBER = Property.MIN_RANDOM_NUMBER;
	private static final Integer MAX_NUMBER = Property.MAX_RANDOM_NUMBER;
	private static final Integer STANDARD_NUMBER = Property.DRIVE_STANDARD_NUMBER;

	public DriveType drive(Integer input) {
		if (!isValid(input)) {
			throw new ValidationException(ErrorCode.NOT_VALID_DRIVE_INPUT);
		}

		return (input >= STANDARD_NUMBER) ? DriveType.GO : DriveType.STOP;
	}

	private boolean isValid(Integer input) {
		return input >= MIN_NUMBER && input <= MAX_NUMBER;
	}
}
