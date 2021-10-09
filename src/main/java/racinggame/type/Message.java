package racinggame.type;

public enum Message {

	ENTER_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
	ENTER_ROUND_COUNT("시도할 회수는 몇회인가요?"),
	RETRY_ROUND_COUNT("라운드 회수는 양의 정수로 입력해주세요."),
	;

	private final String printString;

	Message(final String printString) {
		this.printString = printString;
	}

	@Override
	public String toString() {
		return printString;
	}
}
