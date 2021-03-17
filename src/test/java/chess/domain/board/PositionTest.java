package chess.domain.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {

    Position position;

    @BeforeEach
    void setUp() {
        position = Position.of('a', 1);
    }

    @DisplayName("좌표 조회")
    @Test
    void getPosition_StringInt() {
        XPosition xPositionResult = position.getXPosition();
        YPosition yPositionResult = position.getYPosition();

        assertThat(xPositionResult).isEqualTo(XPosition.A);
        assertThat(yPositionResult).isEqualTo(YPosition.One);
    }

    @DisplayName("좌표 동일성 비교")
    @Test
    void isEqualPosition_boolean() {
        Position anotherPosition = Position.of('a', 1);

        assertEquals(position, anotherPosition);
    }

    @DisplayName("대칭 위치 계산")
    @Test
    void computeSymmetricPosition() {
        Position targetPosition = Position.of('a', 8);

        Position computedPosition = position.computeSymmetricPosition();

        assertEquals(computedPosition, targetPosition);
    }

    @DisplayName("두 위치 사이의 가로 거리 비교")
    @Test
    void computeHorizontalPosition() {
        Position anotherPosition = Position.of('d', 7);
        int predictedHorizontalDistance = 3;

        int distance = position.computeHorizontalDistance(anotherPosition);

        assertEquals(distance, predictedHorizontalDistance);
    }

    @DisplayName("두 위치 사이의 세로 거리 비교")
    @Test
    void name() {
        Position anotherPosition = Position.of('d', 7);
        int predictedVerticalDistance = 6;

        int distance = position.computeVerticalDistance(anotherPosition);

        assertEquals(distance, predictedVerticalDistance);
    }
}