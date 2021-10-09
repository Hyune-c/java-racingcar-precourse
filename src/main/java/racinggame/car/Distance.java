package racinggame.car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import racinggame.type.DriveType;

public class Distance {

	private final List<DriveType> driveTypes;

	private Distance() {
		this.driveTypes = new ArrayList<>();
	}

	private Distance(final Distance newDistance) {
		this.driveTypes = new ArrayList<>();
		for (final DriveType driveType : newDistance.driveTypes) {
			add(driveType);
		}
	}

	public static Distance of() {
		return new Distance();
	}

	public static Distance of(final Distance newDistance) {
		return new Distance(newDistance);
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

	// totalDistance 로 같음을 판단합니다.
	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Distance))
			return false;
		final Distance distance = (Distance)o;
		return Objects.equals(sum(), distance.sum());
	}

	@Override
	public int hashCode() {
		return Objects.hash(sum());
	}
}
