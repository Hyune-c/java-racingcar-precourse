package racinggame.car;

import racinggame.exception.ErrorCode;
import racinggame.exception.ValidationException;
import racinggame.type.DriveType;
import racinggame.config.Property;

public class Engine {

	private static final Integer MIN_NUMBER = Property.MIN_RANDOM_NUMBER;
	private static final Integer MAX_NUMBER = Property.MAX_RANDOM_NUMBER;
	private static final Integer STANDARD_NUMBER = Property.DRIVE_STANDARD_NUMBER;

	public DriveType drive(final Integer input) {
		if (!isValid(input)) {
			throw new ValidationException(ErrorCode.NOT_VALID_DRIVE_INPUT);
		}

		return (input >= STANDARD_NUMBER) ? DriveType.GO : DriveType.STOP;
	}

	private boolean isValid(final Integer input) {
		return input >= MIN_NUMBER && input <= MAX_NUMBER;
	}
}
