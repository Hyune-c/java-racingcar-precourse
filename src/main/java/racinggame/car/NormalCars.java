package racinggame.car;

import java.util.List;

public class NormalCars extends Cars {

	public NormalCars(final List<String> names) {
		for (final String name : names) {
			add(new Car(name));
		}
	}

	public static NormalCars of(final List<String> names) {
		return new NormalCars(names);
	}

	public Car get(final Integer index) {
		return cars.get(index);
	}

	public void driveAll() {
		for (final Car car : cars) {
			car.drive();
		}
	}
}
