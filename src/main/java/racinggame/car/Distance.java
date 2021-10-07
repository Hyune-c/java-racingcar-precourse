package racinggame.car;

import java.util.ArrayList;
import java.util.List;

import racinggame.type.DriveType;

public class Distance {

	private final List<DriveType> driveTypes;

	public Distance() {
		this.driveTypes = new ArrayList<>();
	}

	public Distance(final Distance newDistance) {
		this.driveTypes = new ArrayList<>();
		for (final DriveType driveType : newDistance.driveTypes) {
			add(driveType);
		}
	}

	public void add(final DriveType driveType) {
		driveTypes.add(driveType);
	}

	public Integer sum() {
		Integer result = 0;
		for (final DriveType driveType : driveTypes) {
			result += driveType.getMoveDistance();
		}

		return result;
	}
}
