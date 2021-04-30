package racingcar.input;

import java.util.List;
import java.util.Scanner;

import racingcar.common.type.Message;

public class InputService {

	private final Scanner scanner;

	public InputService() {
		scanner = new Scanner(System.in);
	}

	public List<String> nextCarNames() {
		System.out.println(Message.ENTER_CAR_NAME);
		return ParseUtil.parse(scanner.nextLine());
	}

	public Integer nextRoundCount() {
		System.out.println(Message.ENTER_ROUND_COUNT);
		return Integer.parseInt(scanner.nextLine());
	}
}
