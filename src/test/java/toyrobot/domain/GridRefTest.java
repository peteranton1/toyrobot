package toyrobot.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class GridRefTest {

    @Test
    public void getX() {
        GridRef gridRef = new GridRef(3,4);
        assertEquals(3,gridRef.getX());
    }

    @Test
    public void getY() {
        GridRef gridRef = new GridRef(3,4);
        assertEquals(4,gridRef.getY());
    }

    @Test
    public void lessThan() {
        GridRef ref34 = new GridRef(3,4);
        GridRef ref44 = new GridRef(4,4);
        assertTrue(ref34.lessThan(ref44));
    }

    @Test
    public void moreThan() {
        GridRef ref34 = new GridRef(3,4);
        GridRef ref44 = new GridRef(4,4);
        assertTrue(ref44.moreThan(ref34));
    }
}