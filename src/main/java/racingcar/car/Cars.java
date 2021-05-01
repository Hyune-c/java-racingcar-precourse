package racingcar.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import racingcar.common.exception.ErrorCode;
import racingcar.common.exception.ValidationException;

public class Cars {

	private final List<Car> cars;

	public Cars() {
		this.cars = new ArrayList<>();
	}

	public Cars(List<String> newCarNames) {
		this.cars = new ArrayList<>();
		for (String newCarName : newCarNames) {
			add(new Car(newCarName));
		}
	}

	public Cars(Cars newCars) {
		this.cars = new ArrayList<>();
		for (int i = 0; i < newCars.size(); i++) {
			add(new Car(newCars.getCar(i)));
		}
	}

	public void add(Car newCar) {
		if (cars.contains(newCar)) {
			throw new ValidationException(ErrorCode.ALREADY_EXISTS_CAR);
		}

		cars.add(new Car(newCar));
	}

	public Integer size() {
		return cars.size();
	}

	public Car getCar(Integer index) {
		return cars.get(index);
	}

	public void sort() {
		Collections.sort(cars);
	}

	public void driveAll() {
		for (Car car : cars) {
			car.drive();
		}
	}
}
