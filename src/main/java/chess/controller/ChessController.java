package chess.controller;

import chess.domain.Game;
import chess.view.InputView;
import chess.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class ChessController {

    public static final String NOT_START_MESSAGE = "게임이 시작되지 않았습니다.";
    public static final int SOURCE_INDEX = 1;
    public static final int TARGET_INDEX = 2;

    public void run() {
        OutputView.printInitMessage();
        Game game = new Game();
        while (!game.isEnd()) {
            selectMenu(game);
        }
    }

    private void selectMenu(final Game game) {
        try {
            String input = InputView.receiveInitialResponse();
            Commands.playCommand(game, input);
        } catch (RuntimeException runtimeException) {
            System.out.println(runtimeException.getMessage());
        }
    }

    public static void start(final Game game, final String command) {
        game.init();
        OutputView.printBoard(game);
    }

    public static void move(final Game game, final String command) {
        isStart(game);
        List<String> processedInput = Arrays.asList(command.split(" "));

        game.move(processedInput.get(SOURCE_INDEX), processedInput.get(TARGET_INDEX));
        OutputView.printBoard(game);

        isEnd(game, command);
    }

    private static void isStart(final Game game) {
        if (!game.isStart()) {
            throw new IllegalArgumentException(NOT_START_MESSAGE);
        }
    }

    private static void isEnd(final Game game, final String command) {
        if (game.isEnd()) {
            end(game, command);
            OutputView.printGameWinner(game);
        }
    }

    public static void end(final Game game, final String command) {
        game.end();
        status(game, command);
    }

    public static void status(final Game game, final String command) {
        OutputView.printScore(game);
    }
}
