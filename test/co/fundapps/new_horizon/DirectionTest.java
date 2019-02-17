/**
 * DirectionTest.java
 */
package co.fundapps.new_horizon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test class for the Direction Enumeration.
 * @author Milen Georgiev
 *
 */
public class DirectionTest {

	/**
	 * Testing the retrieval of left and right direction.
	 */
	@Test
	public void testGetLeftDirectionRetrieval() {
		Direction direction = Direction.North;
		assertEquals(Direction.West, direction.getLeftDirection());
	}
	
	@Test
	public void testGetRightDirectionRetrieval() {
		Direction direction = Direction.North;
		assertEquals(Direction.East, direction.getRightDirection());
	}
	
	
	/**
	 * Testing the functions with null.
	 */
	@Test(expected = NullPointerException.class)
	public void testGetLeftDirectionRetrievalOfNull() {
		Direction direction = null;
		direction.getLeftDirection();
	}
	
	@Test(expected = NullPointerException.class)
	public void testGetRightDirectionRetrievalOfNull() {
		Direction direction = null;
		direction.getRightDirection();
	}
}
