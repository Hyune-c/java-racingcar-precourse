package racinggame.input;

import java.util.List;

import nextstep.utils.Console;
import racinggame.type.Message;

public class InputService {

	public List<String> nextCarNames() {
		System.out.println(Message.ENTER_CAR_NAME);
		return ParseUtil.parse(Console.readLine());
	}

	public Integer nextRoundCount() {
		System.out.println(Message.ENTER_ROUND_COUNT);
		return Integer.parseInt(Console.readLine());
	}
}
