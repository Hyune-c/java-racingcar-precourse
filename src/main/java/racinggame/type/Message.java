package racinggame.type;

import java.util.StringJoiner;

import racinggame.car.Car;
import racinggame.car.WinningCars;

public enum Message {

	ENTER_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
	ENTER_ROUND_COUNT("시도할 회수는 몇회인가요?"),
	GAME_RESULT_TITLE("실행 결과"),
	RETRY_ROUND_COUNT("라운드 회수는 양의 정수로 입력해주세요."),
	WINNING_HEADER("최종 우승자는 "),
	WINNING_TAIL(" 입니다."),
	;

	private final String printString;

	Message(final String printString) {
		this.printString = printString;
	}

	public static String getWinning(final WinningCars winningCars) {
		final StringJoiner result = new StringJoiner(", ");
		for (final Car car : winningCars.getCars()) {
			result.add(car.getName());
		}

		return WINNING_HEADER + result.toString() + WINNING_TAIL;
	}

	public static String getCarOutput(final Car car) {
		final String distanceMark = "-";
		final String carDistanceOutput = new String(new char[car.getTotalDistance()]).replace("\0", distanceMark);

		return String.format("%1$-5s", car.getName()) + ": " + carDistanceOutput;
	}

	@Override
	public String toString() {
		return printString;
	}
}
