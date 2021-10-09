package racinggame.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningCars extends Cars {

	private WinningCars(final List<Car> cars) {
		final ArrayList<Car> newCars = new ArrayList<>(cars);
		Collections.sort(newCars);
		final Car farthestCar = newCars.get(0);

		this.cars.add(farthestCar);
		for (int i = 1; i < newCars.size() && farthestCar.equalsDistance(newCars.get(i)); i++) {
			this.cars.add(newCars.get(i));
		}
	}

	public static WinningCars of(final Cars cars) {
		return new WinningCars(cars.getCars());
	}
}
