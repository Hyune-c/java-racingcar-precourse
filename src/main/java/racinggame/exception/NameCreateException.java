package racinggame.exception;

public class NameCreateException extends IllegalArgumentException {

	private static final String MESSAGE = "[ERROR] 유효하지 않은 자동차 이름";

	public NameCreateException() {
		super(MESSAGE);
	}
}
