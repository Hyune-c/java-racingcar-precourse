package racingcar.car;

import java.util.ArrayList;
import java.util.List;

import racingcar.common.type.DriveType;

public class Distance {

	private final List<DriveType> driveTypes;

	public Distance() {
		this.driveTypes = new ArrayList<>();
	}

	public Distance(Distance newDistance) {
		this.driveTypes = new ArrayList<>();
		for (DriveType driveType : newDistance.driveTypes) {
			add(driveType);
		}
	}

	public void add(DriveType driveType) {
		driveTypes.add(driveType);
	}

	public Integer sum() {
		Integer result = 0;
		for (DriveType driveType : driveTypes) {
			result += driveType.getMoveDistance();
		}

		return result;
	}
}
