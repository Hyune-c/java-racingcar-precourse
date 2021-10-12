package racinggame.exception;

public class RoundCountCreateException extends IllegalArgumentException {

	private static final String MESSAGE = "[ERROR] 라운드 수는 0보다 커야 합니다.";

	public RoundCountCreateException() {
		super(MESSAGE);
	}
}
