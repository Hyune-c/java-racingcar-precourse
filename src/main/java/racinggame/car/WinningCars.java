package racinggame.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningCars {

	private final List<Car> cars;

	private WinningCars(final List<Car> cars) {
		this.cars = new ArrayList<>();
		for (final Car car : cars) {
			this.cars.add(new Car(car));
		}
	}

	public static WinningCars of(final Cars cars) {
		cars.sort();
		final Car farthestCar = cars.get(0);

		final List<Car> winningCars = new ArrayList<>();
		winningCars.add(farthestCar);
		for (int i = 1; i < cars.size() && farthestCar.equalsDistance(cars.get(i)); i++) {
			winningCars.add(cars.get(i));
		}

		return new WinningCars(winningCars);
	}

	public Integer size() {
		return cars.size();
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}
}
