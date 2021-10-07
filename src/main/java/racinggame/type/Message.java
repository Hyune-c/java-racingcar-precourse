package racinggame.type;

import java.util.StringJoiner;

import racinggame.car.Car;
import racinggame.car.Cars;

public enum Message {

	ENTER_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
	ENTER_ROUND_COUNT("시도할 회수는 몇회인가요?"),
	GAME_RESULT_TITLE("실행 결과"),
	RETRY_CAR_NAMES("자동차 이름은 ',' 로 구분되며 공백이 허용되지 않는 5자리의 한글, 영문, 숫자입니다."),
	RETRY_ROUND_COUNT("라운드 회수는 양의 정수로 입력해주세요."),
	WINNING("가 최종 우승했습니다."),
	;

	private final String printString;

	Message(final String printString) {
		this.printString = printString;
	}

	public static String getWinning(final Cars winningCars) {
		final StringJoiner result = new StringJoiner(", ");
		for (int i = 0; i < winningCars.size(); i++) {
			result.add(winningCars.getCar(i).getName());
		}
		return result.toString() + Message.WINNING;
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
