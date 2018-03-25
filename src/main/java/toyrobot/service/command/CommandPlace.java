package toyrobot.service.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import toyrobot.domain.Direction;
import toyrobot.domain.Vehicle;
import toyrobot.service.Command;

import java.util.Arrays;
import java.util.List;

public class CommandPlace implements Command {

    private static final Logger LOG = LoggerFactory.getLogger(CommandPlace.class);

    private static final int INIT_VAL = -1;
    private int x = INIT_VAL;
    private int y = INIT_VAL;
    private Direction direction = null;

    /**
     * Constructor.
     *
     * @param paramString string containing any
     *                    parameters to this command.
     */
    protected CommandPlace(String paramString) {

        if (paramString != null) {
            List<String> items = Arrays.asList(paramString.split("\\s*,\\s*"));
            for (String item : items) {
                parseParam(item);
            }
        }
    }

    /**
     * Parse an item into a parameter.
     *
     * @param item to parse.
     */
    private void parseParam(String item) {
        if(item != null) {
            if (x == INIT_VAL) {
                try {
                    x = Integer.parseInt(item.trim());
                }catch(NullPointerException e){
                    LOG.error("Error with item: "+item+", err="+e.getMessage());
                }
            } else if (y == INIT_VAL) {
                try {
                    y = Integer.parseInt(item.trim());
                }catch(NullPointerException e){
                    LOG.error("Error with item: "+item+", err="+e.getMessage());
                }
            } else {
                String noun = item.trim().toUpperCase();
                if (noun.startsWith(Direction.EAST.toString())) {
                    direction = Direction.EAST;
                } else if (noun.startsWith(Direction.SOUTH.toString())) {
                    direction = Direction.SOUTH;
                } else if (noun.startsWith(Direction.WEST.toString())) {
                    direction = Direction.WEST;
                } else {
                    direction = Direction.NORTH;
                }
            }
        }
    }

    /**
     * Executes the command causing a state
     * change in the passed parameter.
     *
     * @param vehicle the instance to execute the command on.
     */
    @Override
    public void execute(Vehicle vehicle) {
        if (vehicle != null) {
            vehicle.place(x, y, direction);
            LOG.debug("PLACE " + x + "," + y + "," + direction);
        }
    }
}
