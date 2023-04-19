package step3.controller;

import step3.domain.Cars;
import step3.view.ResultView;

import java.util.stream.IntStream;

public class CarController {
    private final Cars cars;
    private final int moves;
    private final ResultView view;

    public CarController(String[] carNames, int numberOfMoves) {
        if (carNames.length == 0 || numberOfMoves <= 0) {
            throw new RuntimeException("입력값은 1 이상이어야 합니다.");
        }
        cars = new Cars(carNames);
        moves = numberOfMoves;
        view = new ResultView();
    }

    public void start() {
        IntStream.range(0, moves)
                .forEach(countOfMoves -> {
                    cars.move();
                    view.print(cars);
                });
        view.winner(cars);
    }
}
