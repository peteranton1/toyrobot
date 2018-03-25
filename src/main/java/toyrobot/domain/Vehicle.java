package toyrobot.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * Class to represent a vehicle, e.g. a toy robot.
 * <p>
 * A vehicle holds state about which landscape, gridref
 * and direction it has at any moment.
 */
public class Vehicle {

    private static final Logger LOG = LoggerFactory.getLogger(Vehicle.class);

    private GridRef gridRef;
    private Direction direction;
    private Landscape landscape;

    /**
     * Constructor.
     *
     * @param landscape over which this vehicle can roam.
     * @param x         starting x co-ordinate.
     * @param y         starting y co-ordinate.
     * @param direction starting direction.
     */
    public Vehicle(Landscape landscape, int x, int y, Direction direction) {
        this.landscape = landscape;
        this.gridRef = new GridRef(x, y);
        this.direction = direction;
    }

    /**
     * Put vehicle at absolute grid reference.
     *
     * @param x co-ordinate.
     * @param y co-ordinate.
     */
    public void place(int x, int y, Direction direction) {
        GridRef newGridRef = new GridRef(x, y);
        gridRef = landscape.place(gridRef, newGridRef);
        this.direction = direction;
        LOG.debug("Placed: " + this);
    }

    /**
     * Move forward by N steps.
     *
     * @param steps to move.
     */
    public void stepForward(int steps) {
        if (steps >= 0) {
            LOG.debug("step forward: " + steps);
            for (int i = 0; i < steps; i++) {
                gridRef = landscape
                        .moveOneStep(gridRef, direction);
            }
            LOG.debug("Moved to: " + this);
        }
    }

    /**
     * Sets the vehicle to the compass direction which is
     * 90 degrees anti-clockwise from current direction.
     */
    public void turnLeft() {
        direction = direction.turnLeft();
        LOG.debug("Turn Left: " + direction);
    }

    /**
     * Sets the vehicle to the compass direction which is
     * 90 degrees clockwise from current direction.
     */
    public void turnRight() {
        direction = direction.turnRight();
        LOG.debug("Turn Right: " + direction);
    }

    public GridRef getGridRef() {
        return gridRef;
    }

    public Direction getDirection() {
        return direction;
    }

    public Landscape getLandscape() {
        return landscape;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "" + gridRef +
                ", " + direction +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(gridRef, vehicle.gridRef) &&
                direction == vehicle.direction &&
                Objects.equals(landscape, vehicle.landscape);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gridRef, direction, landscape);
    }
}
