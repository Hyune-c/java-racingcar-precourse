package racingcar;

import racingcar.car.Cars;
import racingcar.common.exception.ValidationException;
import racingcar.common.type.Message;
import racingcar.input.InputService;

public class RacingCarGame {

	private final InputService inputService;

	private Cars cars;
	private Integer roundCount;

	public RacingCarGame() {
		this.inputService = new InputService();
	}

	public RacingCarGame(Cars cars, Integer roundCount) {
		this.inputService = new InputService();
		this.cars = cars;
		this.roundCount = roundCount;
	}

	public void reset() {
		resetCars();
		resetRoundCount();
	}

	private void resetRoundCount() {
		try {
			this.roundCount = inputService.nextRoundCount();
		} catch (ValidationException | NumberFormatException ex) {
			System.out.println(Message.RETRY_ROUND_COUNT);
			resetRoundCount();
		}
	}

	private void resetCars() {
		try {
			this.cars = new Cars(inputService.nextCarNames());
		} catch (ValidationException ex) {
			System.out.println(Message.RETRY_CAR_NAMES);
			resetCars();
		}
	}

	public void doGame() {
		System.out.println();
		System.out.println(Message.GAME_RESULT_TITLE);

		for (int i = 0; i < roundCount; i++) {
			progressGame();
			System.out.println();
		}
	}

	private void progressGame() {
		cars.driveAll();

		for (int j = 0; j < cars.size(); j++) {
			System.out.println(Message.getCarOutput(cars.getCar(j)));
		}
	}

	public void afterGame() {
		Cars winningCars = getFarthestCars(cars);
		System.out.println(Message.getWinning(winningCars));
	}

	private Cars getFarthestCars(Cars cars) {
		Cars baseCars = new Cars(cars);
		baseCars.sort();
		Cars farthestCars = new Cars();
		farthestCars.add(baseCars.getCar(0));

		for (int i = 1; i < baseCars.size()
			&& farthestCars.getCar(0).getTotalDistance().equals(baseCars.getCar(i).getTotalDistance()); i++) {
			farthestCars.add(baseCars.getCar(i));
		}

		return farthestCars;
	}
}
