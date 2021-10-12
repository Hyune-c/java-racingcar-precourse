package racinggame.controller;

import racinggame.exception.RoundCountCreateException;

public class RoundCount {

	private static final int MIN = 1;

	private final int value;

	private RoundCount(final int value) {
		createValidation(value);
		this.value = value;
	}

	public static RoundCount of(final int value) {
		return new RoundCount(value);
	}

	private void createValidation(final int value) {
		if (value < MIN) {
			throw new RoundCountCreateException();
		}
	}

	public int getValue() {
		return value;
	}
}
