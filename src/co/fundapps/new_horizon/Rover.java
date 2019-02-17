/**
 * Rover.java
 */
package co.fundapps.new_horizon;

/**
 * Class describing the actions and properties of a planet rover.
 * @author Milen Georgiev
 *
 */
public class Rover {
	/** Constants for the move function.*/
	private static final short FORWARD_CHANGE = 1;
	private static final short BACKWARD_CHANGE = -1;
	
	/** Size of X dimension of the grid.*/
	private int xGridSize = 0;
	/** Size of  dimension of the grid*/
	private int yGridSize = 0;
	
	/* X Coordinate of the rover. */
	private int xCoordinate = 0;
	/* Y Coordinate of the rover. */
	private int yCoordinate = 0;
	
	/** Direction of the rover. */
	private Direction currentDirection = null;
	
	/**
	 * Constructor. Initialises the fields.
	 * @param xGridSize
	 * @param yGridSize
	 * @param xCoordinate
	 * @param yCoordinate
	 * @param currentDirection
	 * @throws IllegalArgumentException
	 * @throws NullPointerException
	 */
	public Rover(int xGridSize, int yGridSize, int xCoordinate, int yCoordinate, Direction currentDirection) throws IllegalArgumentException, NullPointerException{
		if (xGridSize < 0) {
			throw new IllegalArgumentException("xCoordinate must not be negative!");
		}
		if (yGridSize < 0) {
			throw new IllegalArgumentException("yCoordinate must not be negative!");
		}
		if (xCoordinate < 0 || xCoordinate >= xGridSize) {
			throw new IllegalArgumentException("xCoordinate must not be negative or greater or equal to xGridSize!");
		}
		if (yCoordinate < 0 || yCoordinate >= yGridSize) {
			throw new IllegalArgumentException("yCoordinate must not be negative or greater or equal to yGridSize!");
		}
		if (currentDirection == null) {
			throw new NullPointerException("currentDirection must not be null!");
		}
		
		this.xGridSize = xGridSize;
		this.yGridSize = yGridSize;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.currentDirection = currentDirection;
	}
	
	/**
	 * Execution of a movement command.
	 * @param command
	 * @throws NullPointerException
	 */
	private void move(MovingCommand command) throws NullPointerException{
		if (command == null) {
			throw new NullPointerException("Command must not be null!");
		}
		
		// This will hold the direction of movement for the switch below.
		short change = 0;
		
		// Initialising the change.
		if (command == MovingCommand.Forward) {
			change = Rover.FORWARD_CHANGE;
		} else if (command == MovingCommand.Backward) {
			change = Rover.BACKWARD_CHANGE;
		}
		
		// Performing the movement.
		switch (this.currentDirection) {
		case North:
			this.yCoordinate += change;
			break;
		case South:
			this.yCoordinate -= change;
			break;
		case East:
			this.xCoordinate += change;
			break;
		case West:
			this.xCoordinate -= change;
			break;
		}
		
		// Adjusting the movement in case of leaving the grid.
		if(this.xCoordinate == -1) {
			this.xCoordinate = this.xGridSize - 1;
		} else if (this.xCoordinate == this.xGridSize) {
			this.xCoordinate = 0;
		}
		
		if(this.yCoordinate == -1) {
			this.yCoordinate = this.yGridSize - 1;
		} else if (this.yCoordinate == this.yGridSize) {
			this.yCoordinate = 0;
		}
	}
	
	/**
	 * Execution of turning command.
	 * @param command
	 * @throws NullPointerException
	 */
	private void turn(TurningCommand command) throws NullPointerException{
		if (command == null) {
			throw new NullPointerException("Command must not be null!");
		}
		
		if (command == TurningCommand.Left) {
			this.currentDirection = this.currentDirection.getLeftDirection();
		}
		
		if (command == TurningCommand.Right) {
			this.currentDirection = this.currentDirection.getRightDirection();
		}
	}
	
	/**
	 * Execution of a string of commands.
	 * @param commands
	 * @throws IllegalArgumentException
	 * @throws NullPointerException
	 */
	public void executeCommands(String commands) throws IllegalArgumentException, NullPointerException{
		if (commands == null) {
			throw new NullPointerException("Commands must not be null!");
		}
		if (commands.length() == 0) {
			throw new IllegalArgumentException("Commands must not be empty!");
		}
		
		// Looping through the commands and performing them.
		for (char command : commands.toCharArray()) {
			if (command == 'F' || command == 'f') {
				this.move(MovingCommand.Forward);
			} else if (command == 'B' || command == 'b') {
				this.move(MovingCommand.Backward);
			} else if (command == 'L' || command == 'l') {
				this.turn(TurningCommand.Left);
			} else if (command == 'R' || command == 'r') {
				this.turn(TurningCommand.Right);
			} else {
				throw new IllegalArgumentException("Invalid command!");
			}
		}
	}
	
	/**
	 * Overridden toString method, which returns information about the rover.
	 * @return String
	 */
	@Override
	public String toString() {
		StringBuffer stringifiedInformation = new StringBuffer();
		
		// Initialising the stringifiedInformation.
		stringifiedInformation.append("Current position:\n")
			.append("X Coordinate: ")
			.append(this.xCoordinate)
			.append("\n")
			.append("Y Coordinate: ")
			.append(this.yCoordinate)
			.append("\n")
			.append("Current direction: ")
			.append(this.currentDirection.name())
			.append("\n");
		
		return stringifiedInformation.toString();
	}
}
