package toyrobot.service.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import toyrobot.domain.Vehicle;
import toyrobot.service.Command;

public class CommandMove implements Command {

    private static final Logger LOG = LoggerFactory.getLogger(CommandMove.class);

    /**
     * Constructor.
     *
     * @param paramString string containing any
     *                    parameters to this command.
     */
    protected CommandMove(String paramString){
        // do nothing with string passed
    }

    /**
     * Executes the command causing a state
     * change in the passed parameter.
     *
     * @param vehicle the instance to execute the command on.
     */
    @Override
    public void execute(Vehicle vehicle) {
        if(vehicle != null){
            vehicle.stepForward(1);
            LOG.debug("MOVE");
        }
    }
}
