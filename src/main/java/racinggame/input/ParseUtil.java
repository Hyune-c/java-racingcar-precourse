package racinggame.input;

import java.util.Arrays;
import java.util.List;

public class ParseUtil {

	private static final String REGEX = ",";

	public static List<String> parse(final String input) {
		return Arrays.asList(input.split(REGEX));
	}
}
