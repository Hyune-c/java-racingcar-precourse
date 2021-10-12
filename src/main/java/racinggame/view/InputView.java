package racinggame.view;

import java.util.Arrays;
import java.util.List;

import nextstep.utils.Console;
import racinggame.controller.RoundCount;

public class InputView {

	private static final String ENTER_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String ENTER_ROUND_COUNT = "라운드 회수는 양의 정수로 입력해주세요.";

	private static final String REGEX = ",";

	public static List<String> nextCarNames() {
		System.out.println(ENTER_CAR_NAME);
		return parse(Console.readLine(), REGEX);
	}

	public static RoundCount nextRoundCount() {
		System.out.println(ENTER_ROUND_COUNT);
		return RoundCount.of(Integer.parseInt(Console.readLine()));
	}

	private static List<String> parse(final String input, final String regex) {
		return Arrays.asList(input.split(regex));
	}
}
