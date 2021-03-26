package chess.domain.piece.strategy;

import chess.domain.board.Position;
import chess.domain.exceptions.InvalidMoveException;
import chess.domain.piece.Piece;

public class RookMoveStrategy extends BasicMoveStrategy {

    @Override
    public void checkValidMove(final Position source, final Position target) {
        if (!source.isLineMove(target)) {
            throw new InvalidMoveException(Piece.UNABLE_MOVE_TYPE_MESSAGE);
        }
    }
}
