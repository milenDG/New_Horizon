/**
 * RoverTest.java
 */
package co.fundapps.new_horizon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test class for the Rover class.
 * @author Milen Georgiev
 *
 */
public class RoverTest {
	/**
	 * Normal creation with possible data.
	 */
	@Test
	public void testNormalCreation() {
		Rover rover = new Rover(5, 5, 0, 0, Direction.North);
		assertEquals("Current position:\nX Coordinate: 0\nY Coordinate: 0\nCurrent direction: North\n",
				rover.toString());
	}
	
	
	/**
	 * Wrong creations with wrong data.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNegativeXCoordinate() {
		Rover rover = new Rover(5, 5, -1, 0, Direction.North);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNegativeYCoordinate() {
		Rover rover = new Rover(5, 5, 0, -1, Direction.North);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNegativeXGridSize() {
		Rover rover = new Rover(-1, 5, 0, 0, Direction.North);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNegativeYGridSize() {
		Rover rover = new Rover(5, -1, 0, 0, Direction.North);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNegativeXCoordinateGreaterThanXGridSize() {
		Rover rover = new Rover(5, 5, 6, 0, Direction.North);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNegativeYCoordinateGreaterThanYGridSize() {
		Rover rover = new Rover(5, 5, 0, 6, Direction.North);
	}
	
	@Test(expected = NullPointerException.class)
	public void testNullDirection() {
		Rover rover = new Rover(5, 5, 0, 0, null);
	}
	
	
	/**
	 * Tests for commands execution.
	 */
	@Test
	public void testExecuteOfSimpleCommands() {
		Rover rover = new Rover(100, 100, 0, 0, Direction.North);
		rover.executeCommands("FFRFF");
		
		assertEquals("Current position:\nX Coordinate: 2\nY Coordinate: 2\nCurrent direction: East\n"
				, rover.toString());
	}
	
	@Test
	public void testExecuteOfComplexCommands() {
		Rover rover = new Rover(100, 100, 0, 0, Direction.North);
		rover.executeCommands("FLBRFRRBFLFFFBLRF");
		
		assertEquals("Current position:\nX Coordinate: 4\nY Coordinate: 2\nCurrent direction: East\n"
				, rover.toString());
	}
	
	@Test
	public void testExecuteOfCommandsLeavingTheGrid() {
		Rover rover1 = new Rover(100, 100, 0, 0, Direction.North);
		rover1.executeCommands("BBLFF");
		
		assertEquals("Current position:\nX Coordinate: 98\nY Coordinate: 98\nCurrent direction: West\n"
				, rover1.toString());
		
		Rover rover2 = new Rover(3, 3, 0, 0, Direction.North);
		rover2.executeCommands("FFFRFFFL");
		
		assertEquals("Current position:\nX Coordinate: 0\nY Coordinate: 0\nCurrent direction: North\n"
				, rover2.toString());
	}
	
	/**
	 * Test execution of lowercase commands.
	 */
	@Test
	public void testExecuteOfLowercaseCommands() {
		Rover rover = new Rover(100, 100, 0, 0, Direction.North);
		rover.executeCommands("ffrfF");
		
		assertEquals("Current position:\nX Coordinate: 2\nY Coordinate: 2\nCurrent direction: East\n"
				, rover.toString());
	}
	
	
	/**
	 * Test execution of false command.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExecuteOfFalseCommands() {
		Rover rover = new Rover(100, 100, 0, 0, Direction.North);
		rover.executeCommands("FFRAZ");
	}
}
