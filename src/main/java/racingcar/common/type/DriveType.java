package racingcar.common.type;

public enum DriveType {

	GO(1, "전진"),
	STOP(0, "정지"),
	;

	private final Integer moveDistance;
	private final String description;

	DriveType(final Integer moveDistance, final String description) {
		this.moveDistance = moveDistance;
		this.description = description;
	}

	public Integer getMoveDistance() {
		return moveDistance;
	}
}
