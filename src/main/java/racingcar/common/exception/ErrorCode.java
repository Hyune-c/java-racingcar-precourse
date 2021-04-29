package racingcar.common.exception;

public enum ErrorCode {

	NOT_VALID_CAR_NAME("유효하지 않은 자동차 이름"),
	NOT_VALID_DRIVE_INPUT("유효하지 않은 주행 값"),
	;

	private final String description;

	ErrorCode(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
