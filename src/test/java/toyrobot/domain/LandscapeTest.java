package toyrobot.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class LandscapeTest {

    @Test
    public void place() {
        Landscape landscape = new Landscape(0,0,1,1);
        GridRef pos00 = new GridRef(0,0);
        GridRef pos11 = new GridRef(1,1);
        GridRef pos22 = new GridRef(2,2);
        // should be new GridRef
        assertEquals(pos11,landscape.place(pos00,pos11));
        // should be original GridRef
        assertEquals(pos11,landscape.place(pos11,pos22));
    }

    @Test
    public void moveOneStepX() {
        Landscape landscape = new Landscape(0,0,1,1);
        GridRef pos00 = new GridRef(0,0);
        GridRef pos10 = new GridRef(1,0);
        // should be new GridRef
        assertEquals(pos10,landscape.moveOneStep(pos00,Direction.EAST));
        // should be original GridRef
        assertEquals(pos10,landscape.moveOneStep(pos10,Direction.EAST));
    }

    @Test
    public void moveOneStepY() {
        Landscape landscape = new Landscape(0,0,1,1);
        GridRef pos00 = new GridRef(0,0);
        GridRef pos01 = new GridRef(0,1);
        // should be new GridRef
        assertEquals(pos01,landscape.moveOneStep(pos00,Direction.NORTH));
        // should be original GridRef
        assertEquals(pos01,landscape.moveOneStep(pos01,Direction.NORTH));
    }
}