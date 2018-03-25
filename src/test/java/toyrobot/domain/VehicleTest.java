package toyrobot.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest {

    private static final Landscape landscape = new Landscape(0,0,1,1);
    private static final Vehicle bot11 = new Vehicle(landscape,1,1,Direction.NORTH);

    @Test
    public void shouldPlaceNewPos() {
        Vehicle botA = new Vehicle(landscape,0,0,Direction.SOUTH);
        // should be new bot
        botA.place(1,1,Direction.NORTH);
        assertEquals(bot11,botA);
    }

    @Test
    public void shouldPlaceOrigPos() {
        Vehicle botA = new Vehicle(landscape,1,1,Direction.SOUTH);
        // should be new bot
        botA.place(1,2,Direction.NORTH);
        assertEquals(bot11,botA);
    }

    @Test
    public void shouldStepForward() {
        Vehicle botA = new Vehicle(landscape,1,0,Direction.NORTH);
        // should be new pos
        botA.stepForward(1);
        assertEquals(bot11,botA);
    }

    @Test
    public void shouldNotStepForward() {
        Vehicle botA = new Vehicle(landscape,1,1,Direction.NORTH);
        // should not be new pos
        botA.stepForward(1);
        assertEquals(bot11,botA);
    }

    @Test
    public void turnLeft() {
        Vehicle botA = new Vehicle(landscape,1,1,Direction.EAST);
        // should be new direction
        botA.turnLeft();
        assertEquals(bot11,botA);
    }

    @Test
    public void turnRight() {
        Vehicle botA = new Vehicle(landscape,1,1,Direction.WEST);
        // should be new direction
        botA.turnRight();
        assertEquals(bot11,botA);
    }
}