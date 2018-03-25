package toyrobot.service.command;

import org.junit.Test;
import toyrobot.domain.Direction;
import toyrobot.domain.GridRef;
import toyrobot.domain.Landscape;
import toyrobot.domain.Vehicle;
import toyrobot.service.Command;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class CommandFactoryTest {

    private Vehicle getVehicle(){
        Landscape landscape = new Landscape(0,0,1,1);
        return new Vehicle(landscape,0,0, Direction.NORTH);
    }

    @Test
    public void getCommandLeft() {
        String line = "left";
        Optional<Command> commandOpt = CommandFactory.getOptionalCommand(line);
        assertThat(commandOpt.isPresent(),is(true));
        assertThat(commandOpt.get(),is(instanceOf(CommandLeft.class)));

        Vehicle vehicle = getVehicle();
        Command command = commandOpt.get();
        command.execute(vehicle);
        assertEquals(Direction.WEST,vehicle.getDirection());
    }

    @Test
    public void getCommandMove() {
        String line = "move";
        Optional<Command> commandOpt = CommandFactory.getOptionalCommand(line);
        assertThat(commandOpt.isPresent(),is(true));
        assertThat(commandOpt.get(),is(instanceOf(CommandMove.class)));

        Vehicle vehicle = getVehicle();
        Command command = commandOpt.get();
        command.execute(vehicle);
        assertEquals(new GridRef(0,1),vehicle.getGridRef());
    }

    @Test
    public void getCommandPlace() {
        String line = "Place 1,1,south";
        Optional<Command> commandOpt = CommandFactory.getOptionalCommand(line);
        assertThat(commandOpt.isPresent(),is(true));
        assertThat(commandOpt.get(),is(instanceOf(CommandPlace.class)));

        Vehicle vehicle = getVehicle();
        Command command = commandOpt.get();
        command.execute(vehicle);
        assertEquals(new GridRef(1,1),vehicle.getGridRef());
        assertEquals(Direction.SOUTH,vehicle.getDirection());
    }

    @Test
    public void getCommandReport() {
        String line = "report";
        Optional<Command> commandOpt = CommandFactory.getOptionalCommand(line);
        assertThat(commandOpt.isPresent(),is(true));
        assertThat(commandOpt.get(),is(instanceOf(CommandReport.class)));

        Vehicle vehicle = getVehicle();
        Command command = commandOpt.get();
        command.execute(vehicle);
        // check nothing has moved
        assertEquals(new GridRef(0,0),vehicle.getGridRef());
        assertEquals(Direction.NORTH,vehicle.getDirection());
    }

    @Test
    public void getCommandRight() {
        String line = "right";
        Optional<Command> commandOpt = CommandFactory.getOptionalCommand(line);
        assertThat(commandOpt.isPresent(),is(true));
        assertThat(commandOpt.get(),is(instanceOf(CommandRight.class)));

        Vehicle vehicle = getVehicle();
        Command command = commandOpt.get();
        command.execute(vehicle);
        assertEquals(Direction.EAST,vehicle.getDirection());
    }

    @Test
    public void getCommandEmpty() {
        String line = null;
        Optional<Command> command = CommandFactory.getOptionalCommand(line);
        assertThat(command.isPresent(),is(false));
    }
}