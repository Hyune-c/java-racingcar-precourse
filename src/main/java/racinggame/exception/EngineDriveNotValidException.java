package racinggame.exception;

public class EngineDriveNotValidException extends IllegalArgumentException {

	private static final String MESSAGE = "[ERROR] 유효하지 않은 주행 값";

	public EngineDriveNotValidException() {
		super(MESSAGE);
	}
}
