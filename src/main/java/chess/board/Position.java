package chess.board;

import javafx.geometry.Pos;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Position {

    private static final Map<String, Position> CACHE = new HashMap<>();

    static {
        for (XPosition xposition : XPosition.values()) {
            putPositionWithY(xposition);
        }
    }

    private static void putPositionWithY(XPosition xposition) {
        for (YPosition yPosition : YPosition.values()) {
            String positionKey = String.format("%c%d", xposition.getXPosition(),
                yPosition.getYPosition());
            CACHE.put(positionKey, new Position(xposition, yPosition));
        }
    }

    private XPosition xPosition;
    private YPosition yPosition;

    private Position(XPosition xPosition, YPosition yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public static Position from(String positionKey) {
        Position position = CACHE.get(positionKey);
        return CACHE.get(positionKey);
    }

    public static Position of(char xRawPosition, int yRawPosition) {
        String positionKey = String.format("%c%d", xRawPosition,
            yRawPosition);
        return from(positionKey);
    }

    public XPosition getXPosition() {
        return this.xPosition;
    }

    public YPosition getYPosition() {
        return this.yPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return xPosition == position.xPosition && yPosition == position.yPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xPosition, yPosition);
    }
}
