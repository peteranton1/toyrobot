package toyrobot.domain;

import java.util.Objects;

/**
 * Defines a position in the co-ordinates of the landscape.
 */
public class GridRef {

    private int x;
    private int y;

    public GridRef(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GridRef gridRef = (GridRef) o;
        return x == gridRef.x &&
                y == gridRef.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "GridRef(" + x + ", " + y + ") ";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean lessThan(GridRef that) {
        return this.x < that.x || this.y < that.y;
    }

    public boolean moreThan(GridRef that) {
        return this.x > that.x || this.y > that.y;
    }
}
