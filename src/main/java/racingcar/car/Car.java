package racingcar.car;

import java.util.Objects;
import java.util.Random;

import racingcar.config.Property;

public class Car implements Comparable<Car> {

	private final Name name;
	private final Engine engine;
	private final Distance distance;

	public Car(final String name) {
		this.name = new Name(name);
		this.engine = new Engine();
		this.distance = new Distance();
	}

	public Car(final Car newCar) {
		this.name = new Name(newCar.getName());
		this.engine = new Engine();
		this.distance = new Distance(newCar.distance);
	}

	public void drive() {
		final int randomInput = new Random().nextInt(Property.MAX_RANDOM_NUMBER + 1);
		distance.add(engine.drive(randomInput));
	}

	public void drive(final Integer input) {
		distance.add(engine.drive(input));
	}

	public String getName() {
		return name.getName();
	}

	public Integer getTotalDistance() {
		return distance.sum();
	}

	/**
	 * 이름이 같다면 같은 자동차로 간주됩니다.
	 * @param o
	 * @return
	 */
	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Car)) {
			return false;
		}
		final Car car = (Car)o;
		return getName().equals(car.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName());
	}

	/**
	 * 총 주행 거리를 비교합니다.
	 * @param compareCar
	 * @return
	 */
	@Override
	public int compareTo(final Car compareCar) {
		return compareCar.getTotalDistance().compareTo(this.getTotalDistance());
	}
}
