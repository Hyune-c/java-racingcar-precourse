package racinggame.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import racinggame.exception.CarAddException;

public class Cars {

	private final List<Car> cars;

	public Cars() {
		this.cars = new ArrayList<>();
	}

	public Cars(final List<String> newCarNames) {
		this.cars = new ArrayList<>();
		for (final String newCarName : newCarNames) {
			add(new Car(newCarName));
		}
	}

	public Cars(final Cars newCars) {
		this.cars = new ArrayList<>();
		for (int i = 0; i < newCars.size(); i++) {
			add(new Car(newCars.get(i)));
		}
	}

	public void add(final Car newCar) {
		if (cars.contains(newCar)) {
			throw new CarAddException();
		}

		cars.add(new Car(newCar));
	}

	public Integer size() {
		return cars.size();
	}

	public Car get(final Integer index) {
		return cars.get(index);
	}

	public void sort() {
		Collections.sort(cars);
	}

	public void driveAll() {
		for (final Car car : cars) {
			car.drive();
		}
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}
}
