
/**
* The Generator class generates coils of rope and customer orders 

* Do NOT modify the names and signatures of the two generator methods
* 
* @author  Rouaa Yassin-Kassab & John Colquhoun
* @since   30/10/2017
* extended by Halil Ibryam
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {
	// This variable represents the longest and the shortest possible length of rope
	// that a customer
	// can order
	private final int MIN_ORDER_LENGTH = 1;
	private final int MAX_ORDER_LENGTH = 100;

	// These variables represent the longest and smallest possible coils of rope
	// that the manufacturers can supply
	private final int MIN_ROPE_LENGTH = 100;
	private final int MAX_ROPE_LENGTH = 200;


	/**
	 * This method will generate a list of orders of random lengths between the min
	 * and max order sizes (currently 1 and 100m)
	 * 
	 * @param numberOfOrders:
	 *            the number of customer orders to generate
	 * @return a list of customer orders
	 */
	public List<Integer> generateMultipleOrders(int numberOfOrders) {
		List<Integer> orderList = new ArrayList<Integer>();

		for (int i = 0; i < numberOfOrders; i++) {
			int randomOrderNumber = generateRandomInt(MIN_ORDER_LENGTH, MAX_ORDER_LENGTH);

			orderList.add(randomOrderNumber);
		}


		return orderList;
	}

	public int generateRandomInt(int min, int max) {

		// Usually this can be a field rather than a method variable
		Random rand = new Random();

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomInt = rand.nextInt((max - min) + 1) + min;
		if (randomInt < min || randomInt > max) {
			// Out of bounds!
			throw new IndexOutOfBoundsException("Random integer is out of bounds!");
		}
		return randomInt;
	}

	/**
	 * This method will generate a list of new coils of rope from the manufacturer
	 * of random lengths between the min and max order sizes (currently 100 and
	 * 200m)
	 * 
	 * @param numberOfCoils:
	 *            the number of ropes to generate
	 * @return a list of coils of rope supplied by the manufacturer
	 * 
	 */
		public List<Rope> orderRopeFromManufacturer(int numberOfCoils) {
		List<Rope> coils = new ArrayList<Rope>();
		for (int i = 0; i < numberOfCoils; i++) {
			int length = generateRandomInt(MIN_ROPE_LENGTH, MAX_ROPE_LENGTH);
			Rope rope = new Rope(length);
			coils.add(rope);
		}
		// You need to use the Rope class provided to represent a coil of rope

		/*
		 * THIS METHOD CURRENTLY RETURNS AN EMPTY LIST SO YOU WILL NEED TO ADD IN YOUR
		 * OWN CODE TO GENERATE A LIST OF COILS of ROPE
		 */

		return coils;
	}

}
