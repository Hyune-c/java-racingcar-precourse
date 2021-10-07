package racingcar.common.exception;

public class ValidationException extends RuntimeException {

	private final ErrorCode errorCode;

	public ValidationException(final ErrorCode errorCode) {
		super(errorCode.getDescription());
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}
}
