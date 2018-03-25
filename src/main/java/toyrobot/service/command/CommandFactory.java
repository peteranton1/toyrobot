package toyrobot.service.command;

import toyrobot.service.Command;

import java.util.Optional;

/**
 * Creates a command from a String
 */
public class CommandFactory {

    public static enum VERB {
        LEFT, MOVE, PLACE, REPORT, RIGHT
    }

    /**
     * Method to create a command object from a String.
     *
     * @param line String containing command.
     * @return Command object.
     */
    public static Optional<Command> getOptionalCommand(String line) {
        Command command = null;

        if (line == null) {
            return Optional.empty();
        }

        String lineUcase = line.trim().toUpperCase();
        if (lineUcase.startsWith(VERB.LEFT.toString())) {
            command = new CommandLeft(
                    lineUcase.substring(
                            VERB.LEFT.toString().length()));

        } else if (lineUcase.startsWith(VERB.MOVE.toString())) {
            command = new CommandMove(
                    lineUcase.substring(
                            VERB.MOVE.toString().length()));

        } else if (lineUcase.startsWith(VERB.PLACE.toString())) {
            command = new CommandPlace(
                    lineUcase.substring(
                            VERB.PLACE.toString().length()));

        } else if (lineUcase.startsWith(VERB.REPORT.toString())) {
            command = new CommandReport(
                    lineUcase.substring(
                            VERB.REPORT.toString().length()));

        } else if (lineUcase.startsWith(VERB.RIGHT.toString())) {
            command = new CommandRight(
                    lineUcase.substring(
                            VERB.RIGHT.toString().length()));
        }

        return (command == null ?
                Optional.empty() :
                Optional.of(command));
    }

}
