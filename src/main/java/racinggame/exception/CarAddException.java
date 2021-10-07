package racinggame.exception;

public class CarAddException extends IllegalArgumentException {

	private static final String MESSAGE = "[ERROR] 이미 존재하는 자동차";

	public CarAddException() {
		super(MESSAGE);
	}
}
