package racinggame.car;

import static racinggame.config.Property.*;

import racinggame.exception.EngineDriveNotValidException;
import racinggame.type.DriveType;

public class Engine {

	private static final int MIN_NUMBER = MIN_RANDOM_NUMBER;
	private static final int MAX_NUMBER = MAX_RANDOM_NUMBER;
	private static final int STANDARD_NUMBER = DRIVE_STANDARD_NUMBER;

	public static Engine of() {
		return new Engine();
	}

	public DriveType drive(final Integer input) {
		validation(input);

		if (input >= STANDARD_NUMBER) {
			return DriveType.GO;
		}

		return DriveType.STOP;
	}

	private void validation(final Integer input) {
		if (input < MIN_NUMBER || input > MAX_NUMBER) {
			throw new EngineDriveNotValidException();
		}
	}
}
