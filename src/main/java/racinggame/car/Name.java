package racinggame.car;

import racinggame.exception.NameCreateException;

public class Name {

	private static final Integer MIN_LENGTH = 1;
	private static final Integer MAX_LENGTH = 5;

	// 한글, 영문, 숫자로 이루어진 1 ~ 5 자리 유효성 정규 표현
	private static final String REGEX = "^[가-힣a-zA-Z0-9]{" + MIN_LENGTH + "," + MAX_LENGTH + "}$";

	private final String name;

	public Name(final String name) {
		if (!isValid(name)) {
			throw new NameCreateException();
		}

		this.name = name;
	}

	private boolean isValid(final String name) {
		return name.matches(REGEX);
	}

	public String getName() {
		return name;
	}
}
