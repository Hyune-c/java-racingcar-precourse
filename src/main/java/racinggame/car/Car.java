package racinggame.car;

import java.util.Objects;

import nextstep.utils.Randoms;
import racinggame.config.Property;

public class Car implements Comparable<Car> {

	private final Name name;
	private final Engine engine;
	private final Distance distance;

	public Car(final Name name, final Engine engine, final Distance distance) {
		this.name = name;
		this.engine = engine;
		this.distance = distance;
	}

	public static Car of(final String name) {
		return new Car(Name.of(name), Engine.of(), Distance.of());
	}

	public static Car of(final Car newCar) {
		return new Car(newCar.name, Engine.of(), Distance.of(newCar.distance));
	}

	public void drive() {
		final int randomInput = Randoms.pickNumberInRange(Property.MIN_RANDOM_NUMBER, Property.MAX_RANDOM_NUMBER);
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

	public boolean equalsDistance(final Car car) {
		return this.compareTo(car) == 0;
	}

	// 자동차 이름으로 같음을 판단합니다.
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

	// 총 주행 거리로 대소를 비교합니다.
	@Override
	public int compareTo(final Car compareCar) {
		return compareCar.getTotalDistance().compareTo(this.getTotalDistance());
	}
}
