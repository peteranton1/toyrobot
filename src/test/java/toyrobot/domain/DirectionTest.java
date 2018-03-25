package toyrobot.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class DirectionTest {

    @Test
    public void getDeltaX() {
        assertEquals(0,Direction.NORTH.getDeltaX());
        assertEquals(1,Direction.EAST.getDeltaX());
        assertEquals(0,Direction.SOUTH.getDeltaX());
        assertEquals(-1,Direction.WEST.getDeltaX());
    }

    @Test
    public void getDeltaY() {
        assertEquals(1,Direction.NORTH.getDeltaY());
        assertEquals(0,Direction.EAST.getDeltaY());
        assertEquals(-1,Direction.SOUTH.getDeltaY());
        assertEquals(0,Direction.WEST.getDeltaY());
    }

    @Test
    public void turnLeft() {
        assertEquals(Direction.NORTH,Direction.EAST.turnLeft());
        assertEquals(Direction.EAST,Direction.SOUTH.turnLeft());
        assertEquals(Direction.SOUTH,Direction.WEST.turnLeft());
        assertEquals(Direction.WEST,Direction.NORTH.turnLeft());
    }

    @Test
    public void turnRight() {
        assertEquals(Direction.NORTH,Direction.WEST.turnRight());
        assertEquals(Direction.WEST,Direction.SOUTH.turnRight());
        assertEquals(Direction.SOUTH,Direction.EAST.turnRight());
        assertEquals(Direction.EAST,Direction.NORTH.turnRight());
    }
}