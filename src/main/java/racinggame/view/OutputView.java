package racinggame.view;

import java.util.StringJoiner;

import racinggame.car.Car;
import racinggame.car.Cars;

public class OutputView {

	private static final String GAME_RESULT_TITLE = "실행 결과";
	private static final String WINNING_CARS_HEADER = "최종 우승자는 ";
	private static final String WINNING_CARS_TAIL = " 입니다.";

	public OutputView() {
	}

	public static void printCars(final Cars cars) {
		final StringJoiner result = new StringJoiner(", ");
		for (final Car car : cars.getCars()) {
			result.add(car.getName());
		}

		System.out.println(WINNING_CARS_HEADER + result + WINNING_CARS_TAIL);
	}

	public static void printCarOutput(final Car car) {
		final String distanceMark = "-";
		final String carDistanceOutput = new String(new char[car.getTotalDistance()]).replace("\0", distanceMark);

		System.out.println(String.format("%1$-5s", car.getName()) + ": " + carDistanceOutput);
	}

	public static void printResultTitle() {
		System.out.println(GAME_RESULT_TITLE);
	}

	public static void println() {
		System.out.println();
	}

	public static void printException(final Exception exception) {
		System.out.println(exception.getMessage());
	}
}
