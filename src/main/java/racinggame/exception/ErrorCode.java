package racinggame.exception;

public enum ErrorCode {

	NOT_VALID_CAR_NAME("유효하지 않은 자동차 이름"),
	NOT_VALID_DRIVE_INPUT("유효하지 않은 주행 값"),
	ALREADY_EXISTS_CAR("이미 존재하는 자동차"),
	;

	private final String description;

	ErrorCode(final String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
