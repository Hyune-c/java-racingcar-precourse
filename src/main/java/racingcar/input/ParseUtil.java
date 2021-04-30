package racingcar.input;

import java.util.Arrays;
import java.util.List;

public class ParseUtil {

	private static final String REGEX = ",";

	public static List<String> parse(String input) {
		return Arrays.asList(input.split(REGEX));
	}
}
