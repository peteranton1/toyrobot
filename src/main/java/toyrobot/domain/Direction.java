package toyrobot.domain;

/**
 * Defines a compass direction definition.
 */
public enum Direction {
    NORTH(0, 1),
    EAST(1, 0),
    SOUTH(0, -1),
    WEST(-1, 0);

    private int deltaX;
    private int deltaY;

    public int getDeltaX() {
        return deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }

    /**
     * @return Returns the compass direction which is
     * 90 degrees anti-clockwise from current position.
     */
    public Direction turnLeft() {
        switch (this) {
            case NORTH:
                return WEST;
            case EAST:
                return NORTH;
            case SOUTH:
                return EAST;
            case WEST:
                return SOUTH;
        }
        return this;
    }

    /**
     * @return Returns the compass direction which is
     * 90 degrees clockwise from current position.
     */
    public Direction turnRight() {
        switch (this) {
            case NORTH:
                return EAST;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
        }
        return this;
    }

    /**
     * Private constructor.
     *
     * @param deltaX defines the difference in X when in this direction.
     * @param deltaY defines the difference in Y when in this direction.
     */
    Direction(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

}
