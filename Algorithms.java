
/**
* The Algorithms class contains the two algorithms you have to implement for coursework 2

* Do NOT modify the names and signatures of the two algorithm methods
* 
* @author  Rouaa Yassin-Kassab & John Colquhoun
* @since   30/10/2017
* extended by Halil Ibryam 
*/

import java.util.*;

public class Algorithms {
	Generator gen = new Generator();
	private int coilsUsed = 0;
	// If the length is less than 5m it's removed from stock.
	private final int MIN_ROPE_STOCK_LENGTH = 5;

	public int getCoilsUsed() {
		return coilsUsed;
	}

	/**
	 * This method is used to implement the first fit algorithm
	 * 
	 * @param orders:
	 *            a list of integers representing customer orders
	 * @param coils
	 *            : a list of ropes representing available coils of ropes from the
	 *            manufacturer
	 * @return the number of coils used to fulfil all customer orders
	 */
	public int firstFit(final List<Integer> orders, final List<Rope> coils) {
		// Declaring variables
		boolean orderFinish = false;
		int index = 0;
		coilsUsed = 1;
		int scrapper = 0;
		// For loop to go through list of orders
		for (int i = 0; i < orders.size(); i++) {
			orderFinish = false; // boolean to check if order is finished
			index = 0;
			while (!orderFinish) { // loop until orderFinish is true
				// check whether to scrap a rope
				if (coils.get(index).getLength() < MIN_ROPE_STOCK_LENGTH && i != orders.size() - 1) {
					coils.remove(coils.get(index));
					scrapper++;
				} // Cut the current order from the current rope
				if (coils.get(index).cut(orders.get(i))) { //
					orderFinish = true;
				} else {
					index++;
				}
			}

			if (coilsUsed < index + 1) { // check if need a new coil
				coilsUsed++;
			}
		}
		coilsUsed += scrapper; // add the scrapped coil to coilsUsed
		return coilsUsed;

	}

	/*
	 * /** This method is used to implement the next fit algorithm
	 * 
	 * @param orders: a list of integers representing customer orders
	 * 
	 * @param coils : a list of ropes representing available coils of ropes from the
	 * manufacturer
	 * 
	 * @return the number of coils used to fulfil all customer orders
	 */

	public int nextFit(List<Integer> orders, List<Rope> coils) {
		int index = 0;
		int scrapper = 0;
		coilsUsed = 1;
		// for loop to go through list of orders
		for (int i : orders) {
			if (i > coils.get(index).getLength()) { //check if current order is bigger than current rope
				index++;			// if yes get next rope
				coilsUsed++;
			} 	
			// Check if current rope is bigger than  current order, if yes cut
			if (coils.get(index).getLength() >= i) {
				int cutLength = coils.get(index).getLength() - i;
				coils.get(index).setLength(cutLength);
			}		// check whether to scrapp coil after use
			if (coils.get(index).getLength() < MIN_ROPE_STOCK_LENGTH && i != orders.get(orders.size() - 1)) {
				coils.remove(index);
				scrapper++;
			}
		}	// adddScrapped coils to Used Coils
		coilsUsed += scrapper;
		return coilsUsed;
	}

	@Override	// to String to print coilsUsed
	public String toString() {
		return ("Coils Used: " + this.getCoilsUsed());
	}

}
