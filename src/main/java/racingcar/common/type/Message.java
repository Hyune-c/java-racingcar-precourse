package racingcar.common.type;

public enum Message {

	ENTER_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
	ENTER_ROUND_COUNT("시도할 회수는 몇회인가요?"),
	GAME_RESULT_TITLE("실행 결과"),
	RETRY_INPUT("다시 입력해주세요."),
	;

	private final String printString;

	Message(String printString) {
		this.printString = printString;
	}

	@Override
	public String toString() {
		return printString;
	}
}
