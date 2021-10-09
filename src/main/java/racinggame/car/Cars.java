package racinggame.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import racinggame.exception.CarAddException;

public abstract class Cars {

	protected final List<Car> cars;

	protected Cars() {
		this.cars = new ArrayList<>();
	}

	public void add(final Car newCar) {
		if (cars.contains(newCar)) {
			throw new CarAddException();
		}

		cars.add(Car.of(newCar));
	}

	public int size() {
		return cars.size();
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}
}
