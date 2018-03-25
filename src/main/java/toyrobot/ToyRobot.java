package toyrobot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import toyrobot.domain.Direction;
import toyrobot.domain.GridRef;
import toyrobot.domain.Landscape;
import toyrobot.domain.Vehicle;
import toyrobot.service.CommandProcessor;

/**
 * Main class for toy robot.
 */
public class ToyRobot {

    private static final Logger LOG = LoggerFactory.getLogger(ToyRobot.class);

    /**
     * Main method for toy robot.
     *
     * @param args
     */
    public static void main(String[] args) {

        Landscape landscape = new Landscape(0, 0,5, 5);
        Vehicle vehicle = new Vehicle(landscape,3,3, Direction.NORTH);

        if(args.length == 0){
            exampleVehicleMoves(vehicle);
        }else{
            // Process input
            CommandProcessor processor = new CommandProcessor();
            processor.process(args[0],vehicle);
        }
    }

    public static void exampleVehicleMoves(Vehicle vehicle){

        vehicle.place(3, 3, Direction.EAST);
        vehicle.stepForward(4);
        vehicle.turnRight();
        vehicle.stepForward(2);
        vehicle.turnLeft();
        vehicle.stepForward(2);
        vehicle.turnLeft();
        vehicle.stepForward(6);

        LOG.debug("Finished: current state: {}", vehicle);

    }
}
