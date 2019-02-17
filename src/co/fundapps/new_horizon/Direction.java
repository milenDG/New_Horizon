/**
 * Direction.java
 */
package co.fundapps.new_horizon;

/**
 * Enumeration containing the directions.
 * @author Milen Georgiev
 *
 */
public enum Direction {
	North,
	South,
	West,
	East;
	
	/**
	 * Getter for the left direction.
	 * @return The left direction of a specific direction.
	 * @throws NullPointerException
	 */
	public Direction getLeftDirection() throws NullPointerException{
		switch (this) {
		case North:
			return Direction.West;
		case South:
			return Direction.East;
		case West:
			return Direction.South;
		case East:
			return Direction.North;
		default:
			throw new NullPointerException("Direction must not be null!");
		}
	}
	
	/**
	 * Getter for the right direction.
	 * @return The right direction of a specific direction.
	 * @throws NullPointerException
	 */
	public Direction getRightDirection() throws NullPointerException{
		switch (this) {
		case North:
			return Direction.East;
		case South:
			return Direction.West;
		case West:
			return Direction.North;
		case East:
			return Direction.South;
		default:
			throw new NullPointerException("Direction must not be null!");
		}
	}
}
