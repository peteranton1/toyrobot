package toyrobot.service;

import toyrobot.domain.Vehicle;

/**
 * Represents a vehicle command
 */
public interface Command {
    /**
     * Executes the command causing a state
     * change in the passed parameter.
     *
     * @param vehicle the instance to execute the command on.
     */
    public void execute(Vehicle vehicle);
}
