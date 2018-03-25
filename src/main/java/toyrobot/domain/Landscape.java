package toyrobot.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Defines a landscape within which an object can moveToNewGridRef.
 */
public class Landscape {

    private static final Logger LOG = LoggerFactory.getLogger(Landscape.class);

    private final GridRef minGridRef;
    private final GridRef maxGridRef;

    /**
     * Create a landscape of chosen dimensions.
     *
     * @param xMin defines bottom left corner x co-ordinate.
     * @param yMin defines bottom left corner y co-ordinate.
     * @param xMax defines top right corner x co-ordinate.
     * @param yMax defines top right corner y co-ordinate.
     */
    public Landscape(int xMin, int yMin, int xMax, int yMax) {
        this.minGridRef = new GridRef(xMin, yMin);
        this.maxGridRef = new GridRef(xMax, yMax);
    }

    @Override
    public String toString() {
        return "Landscape{" +
                "(" + minGridRef +
                "), (" + maxGridRef +
                "))";
    }

    public GridRef place(GridRef currentGridRef, GridRef newGridRef){
        if (newGridRef.lessThan(minGridRef) || newGridRef.moreThan(maxGridRef)) {
            LOG.debug("NOT Moved to : {}", newGridRef);
            return currentGridRef;
        } else {
            return newGridRef;
        }
    }

    public GridRef moveOneStep(GridRef currentGridRef, Direction direction) {

        GridRef newGridRef = new GridRef(
                currentGridRef.getX() + direction.getDeltaX(),
                currentGridRef.getY() + direction.getDeltaY());

        return place(currentGridRef, newGridRef);
    }

}
