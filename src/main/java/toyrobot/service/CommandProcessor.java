package toyrobot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import toyrobot.domain.Vehicle;
import toyrobot.service.command.CommandFactory;
import toyrobot.service.command.CommandPlace;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * Accepts a file of commands and applies them to a Vehicle.
 */
public class CommandProcessor {

    private static final Logger LOG = LoggerFactory.getLogger(CommandProcessor.class);

    /**
     * Accepts a file of commands and applies them to a Vehicle.
     *
     * @param infile  a path to a file to process.
     * @param vehicle a Vehicle object to receive commands.
     */
    public void process(String infile, Vehicle vehicle) {

        LOG.debug("Processing: " + infile);
        List<Command> commands = load(infile);

        boolean havePlaced = false;

        for(Command command:commands){
            if(!havePlaced && command instanceof CommandPlace) {
                havePlaced = true;
            }
            if(havePlaced){
                command.execute(vehicle);
            }
        }
    }

    /**
     * Load a file of commands and transform ino a list of commands.
     *
     * @param infile full path to a file.
     * @return list of command objects.
     */
    public List<Command> load(String infile) {
        List<Command> commands = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(new File(infile)))) {

            commands = br.lines()
                    .map(CommandFactory::getOptionalCommand)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(toList());

        } catch (FileNotFoundException fnfe) {
            LOG.error("Unable to find command file: "
                    + infile + ", Err=" + fnfe.getMessage());
        } catch (IOException ioe) {
            LOG.error("Unexpected error reading file: "
                    + infile + ", Err=" + ioe.getMessage());
        }

        return commands;
    }
}
