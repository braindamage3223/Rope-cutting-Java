
/**
* The Test class is your main testing suite for the coursework

* You can add additional methods if you need to in this class 
* 
* @author  Rouaa Yassin-Kassab & John Colquhoun
* @since   30/10/2017
* extended by Halil Ibryam
*/

import java.util.*; //needed for usage of the List interface

public class Test {

	public static void main(String[] args) {
		/*
		 * System.out.println("*********** Correctness testing ************");
		 * printFF1(); printFF2(); printFF3(); printFF4(); printFF5();
		 * System.out.println("\n"); printNF1(); printNF2(); printNF3(); printNF4();
		 * printNF5();
		 */
		/*
		 * Here you will need to validate that your algorithms behave as expected on
		 * small data sets. You can use any additional method you created in this class
		 */

		System.out.println("************** Main testing **************");
		System.out.println("*********** Performance analysis **************");

		int noOfTests = 5; // total number of tests - you need to CHANGE this value
		int noOfRep = 1000; // number of times to run each test - you need to CHANGE this value
		int noOfOrders = 10000; // the number of customer orders needed for the first run - you need to CHANGE
		// this value
		int increment = 0; // the increment in the number of orders - you need to CHANGE this value

		performanceTesting(noOfTests, noOfRep, noOfOrders, increment);

	}

	/**
	 * performanceTesting (comparing the two algorithms in term of time and total
	 * number of coils used)
	 * 
	 * @param noOfTests
	 *            - the numbem r of tests
	 * @param noOfRep
	 *            - the number of repetitions for each test
	 * @param noOfOrders
	 *            - the number of orders in the first order sequence
	 * @param increment
	 *            - increment of the number of orders
	 *
	 */
	public static void performanceTesting(int noOfTests, int noOfRep, int noOfOrders, int increment) {
		Algorithms a = new Algorithms();
		Generator gen = new Generator();
		List<Integer> orders = new ArrayList<>();
		List<Rope> coils = new ArrayList<>();
		int avgFFcoils = 0, avgNFcoils = 0;
		long totalTimeFF = 0, totalTimeNF = 0;
		long startFF, startNF;
		long elapsedTimeFF, elapsedTimeNF;
		for (int i = 1; i <= noOfTests; i++) {
			noOfOrders = increment += 10000;
			System.out.println("Test: " + i);

			for (int j = 1; j < noOfRep; j++) {
				coils = gen.orderRopeFromManufacturer(noOfOrders);
				orders = gen.generateMultipleOrders(noOfOrders);
				List<Integer> ordersFF = copyOrders(orders);
				List<Rope> coilsFF = copyCoils(coils);
				List<Integer> ordersNF = copyOrders(orders);
				List<Rope> coilsNF = copyCoils(coils);

				startFF = System.nanoTime();
				avgFFcoils += a.firstFit(ordersFF, coilsFF);
				elapsedTimeFF = System.nanoTime() - startFF;
				totalTimeFF = totalTimeFF + elapsedTimeFF;

				startNF = System.nanoTime();
				avgNFcoils += a.nextFit(ordersNF, coilsNF);
				elapsedTimeNF = System.nanoTime() - startNF;
				totalTimeNF = totalTimeNF + elapsedTimeNF;

			}
			avgFFcoils = avgFFcoils / noOfRep;
			avgNFcoils = avgNFcoils / noOfRep;
			System.out.println("FF Number of repetitions " + increment + "\tCoilsUsed: " + avgFFcoils);
			System.out.println("NF Average Coils Used for " + increment + "\tCoilsUsed: " + avgNFcoils);
			System.out.println("Elapsed Time for FF " + increment + "\tTime: " + (totalTimeFF / noOfRep) / 1000000 + " ms");
			System.out.println("Elapsed Time for NF " + increment + "\tTime: " + (totalTimeNF / noOfRep) / 1000000 + " ms");

			// System.out.println("\n");
		}

	}

	// method to copy list of Rope objects
	public static List<Rope> copyCoils(List<Rope> coils) {
		List<Rope> copyCoils = new ArrayList<>();
		for (Rope r : coils) {
			copyCoils.add(new Rope(r.getLength()));
		}

		return copyCoils;
	}

	// method to copy list of integer orders
	public static List<Integer> copyOrders(List<Integer> orders) {
		List<Integer> copyOrders = new ArrayList<>();
		for (int i : orders) {
			copyOrders.add(i);
		}

		return copyOrders;

	}

	// correctness tests for firstFit
	public static void printFF1() {
		Algorithms a = new Algorithms();
		List<Integer> orders = new ArrayList<>();
		List<Rope> coils = new ArrayList<>();

		Rope r = new Rope(100);
		Rope r1 = new Rope(100);
		Rope r2 = new Rope(100);
		Rope r3 = new Rope(100);
		Rope r4 = new Rope(100);
		Rope r5 = new Rope(100);
		Rope r6 = new Rope(100);
		Rope r7 = new Rope(100);

		orders.add(60);
		orders.add(70);
		orders.add(80);
		orders.add(40);
		orders.add(30);
		orders.add(90);
		orders.add(20);
		orders.add(100);
		orders.add(10);
		orders.add(10);

		coils.add(0, r);
		coils.add(1, r1);
		coils.add(2, r2);
		coils.add(3, r3);
		coils.add(4, r4);
		coils.add(5, r5);
		coils.add(6, r6);
		coils.add(7, r7);

		a.firstFit(orders, coils);
		System.out.println("First Fit\n" + a);

	}

	public static void printFF2() {
		Algorithms a = new Algorithms();
		List<Integer> orders = new ArrayList<>();
		List<Rope> coils = new ArrayList<>();

		Rope r = new Rope(100);
		Rope r1 = new Rope(100);
		Rope r2 = new Rope(100);
		Rope r3 = new Rope(100);

		orders.add(100);
		orders.add(100);
		orders.add(100);
		orders.add(100);

		coils.add(0, r);
		coils.add(1, r1);
		coils.add(2, r2);
		coils.add(3, r3);

		a.firstFit(orders, coils);
		System.out.println("First Fit 2\n" + a);

	}

	public static void printFF3() {
		Algorithms a = new Algorithms();
		List<Integer> orders = new ArrayList<>();
		List<Rope> coils = new ArrayList<>();

		Rope r = new Rope(120);
		Rope r1 = new Rope(150);
		Rope r2 = new Rope(100);
		Rope r3 = new Rope(130);
		Rope r4 = new Rope(120);
		Rope r5 = new Rope(178);
		Rope r6 = new Rope(190);
		Rope r7 = new Rope(156);

		orders.add(57);
		orders.add(21);
		orders.add(76);
		orders.add(98);
		orders.add(78);
		orders.add(65);
		orders.add(43);
		orders.add(26);
		orders.add(89);
		orders.add(11);

		coils.add(0, r);
		coils.add(1, r1);
		coils.add(2, r2);
		coils.add(3, r3);
		coils.add(4, r4);
		coils.add(5, r5);
		coils.add(6, r6);
		coils.add(7, r7);

		a.firstFit(orders, coils);
		System.out.println("First Fit 3\n" + a);

	}

	public static void printFF4() {
		Algorithms a = new Algorithms();
		List<Integer> orders = new ArrayList<>();
		List<Rope> coils = new ArrayList<>();

		Rope r = new Rope(190);
		Rope r1 = new Rope(170);
		Rope r2 = new Rope(150);
		Rope r3 = new Rope(140);
		Rope r4 = new Rope(130);
		Rope r5 = new Rope(120);
		Rope r6 = new Rope(110);
		Rope r7 = new Rope(140);

		orders.add(90);
		orders.add(100);
		orders.add(70);
		orders.add(100);
		orders.add(50);
		orders.add(100);
		orders.add(40);
		orders.add(100);
		orders.add(30);
		orders.add(100);
		orders.add(20);
		orders.add(100);
		orders.add(10);
		orders.add(100);

		coils.add(0, r);
		coils.add(1, r1);
		coils.add(2, r2);
		coils.add(3, r3);
		coils.add(4, r4);
		coils.add(5, r5);
		coils.add(6, r6);
		coils.add(7, r7);

		a.firstFit(orders, coils);
		System.out.println("First Fit 4\n" + a);

	}

	public static void printFF5() {
		Algorithms a = new Algorithms();
		List<Integer> orders = new ArrayList<>();
		List<Rope> coils = new ArrayList<>();

		Rope r = new Rope(190);
		Rope r1 = new Rope(170);
		Rope r2 = new Rope(150);
		Rope r3 = new Rope(140);
		Rope r4 = new Rope(130);
		Rope r5 = new Rope(120);
		Rope r6 = new Rope(110);
		Rope r7 = new Rope(140);

		orders.add(100);
		orders.add(90);
		orders.add(100);
		orders.add(70);
		orders.add(100);
		orders.add(50);
		orders.add(100);
		orders.add(40);
		orders.add(100);
		orders.add(30);
		orders.add(100);
		orders.add(20);
		orders.add(100);
		orders.add(10);

		coils.add(0, r);
		coils.add(1, r1);
		coils.add(2, r2);
		coils.add(3, r3);
		coils.add(4, r4);
		coils.add(5, r5);
		coils.add(6, r6);
		coils.add(7, r7);

		a.firstFit(orders, coils);
		System.out.println("First Fit 5\n" + a);

	}

	// correctness tests for nextFit
	public static void printNF1() {
		Algorithms a = new Algorithms();

		List<Integer> orders = new ArrayList<>();
		List<Rope> coils = new ArrayList<>();

		Rope r = new Rope(100);
		Rope r1 = new Rope(100);
		Rope r2 = new Rope(100);
		Rope r3 = new Rope(100);
		Rope r4 = new Rope(100);

		orders.add(100);
		orders.add(100);
		orders.add(100);
		orders.add(100);
		orders.add(100);

		coils.add(0, r);
		coils.add(1, r1);
		coils.add(2, r2);
		coils.add(3, r3);
		coils.add(4, r4);

		a.nextFit(orders, coils);
		System.out.println("Next Fit\n" + a);

	}

	public static void printNF2() {
		Algorithms a = new Algorithms();
		List<Integer> orders = new ArrayList<>();
		List<Rope> coils = new ArrayList<>();

		Rope r = new Rope(120);
		Rope r1 = new Rope(150);
		Rope r2 = new Rope(100);
		Rope r3 = new Rope(130);
		Rope r4 = new Rope(120);
		Rope r5 = new Rope(178);
		Rope r6 = new Rope(150);
		Rope r7 = new Rope(156);
		Rope r8 = new Rope(130);
		Rope r9 = new Rope(156);

		orders.add(90);
		orders.add(80);
		orders.add(90);
		orders.add(70);
		orders.add(80);
		orders.add(99);
		orders.add(70);
		orders.add(60);
		orders.add(80);
		orders.add(40);

		coils.add(0, r);
		coils.add(1, r1);
		coils.add(2, r2);
		coils.add(3, r3);
		coils.add(4, r4);
		coils.add(5, r5);
		coils.add(6, r6);
		coils.add(7, r7);
		coils.add(8, r8);
		coils.add(9, r9);

		a.nextFit(orders, coils);
		System.out.println("Next Fit 2\n" + a);

	}

	public static void printNF3() {
		Algorithms a = new Algorithms();
		List<Integer> orders = new ArrayList<>();
		List<Rope> coils = new ArrayList<>();

		Rope r = new Rope(120);
		Rope r1 = new Rope(150);
		Rope r2 = new Rope(100);
		Rope r3 = new Rope(130);
		Rope r4 = new Rope(120);
		Rope r5 = new Rope(178);
		Rope r6 = new Rope(190);
		Rope r7 = new Rope(156);

		orders.add(57);
		orders.add(21);
		orders.add(76);
		orders.add(98);
		orders.add(78);
		orders.add(65);
		orders.add(43);
		orders.add(26);
		orders.add(89);
		orders.add(11);

		coils.add(0, r);
		coils.add(1, r1);
		coils.add(2, r2);
		coils.add(3, r3);
		coils.add(4, r4);
		coils.add(5, r5);
		coils.add(6, r6);
		coils.add(7, r7);

		a.nextFit(orders, coils);
		System.out.println("Next Fit 3\n" + a);

	}

	public static void printNF4() {
		Algorithms a = new Algorithms();
		List<Integer> orders = new ArrayList<>();
		List<Rope> coils = new ArrayList<>();

		Rope r = new Rope(190);
		Rope r1 = new Rope(170);
		Rope r2 = new Rope(150);
		Rope r3 = new Rope(140);
		Rope r4 = new Rope(130);
		Rope r5 = new Rope(120);
		Rope r6 = new Rope(110);
		Rope r7 = new Rope(140);

		orders.add(90);
		orders.add(100);
		orders.add(70);
		orders.add(100);
		orders.add(50);
		orders.add(100);
		orders.add(40);
		orders.add(100);
		orders.add(30);
		orders.add(100);
		orders.add(20);
		orders.add(100);
		orders.add(10);
		orders.add(100);

		coils.add(0, r);
		coils.add(1, r1);
		coils.add(2, r2);
		coils.add(3, r3);
		coils.add(4, r4);
		coils.add(5, r5);
		coils.add(6, r6);
		coils.add(7, r7);

		a.nextFit(orders, coils);
		System.out.println("Next Fit 4\n" + a);

	}

	public static void printNF5() {
		Algorithms a = new Algorithms();
		List<Integer> orders = new ArrayList<>();
		List<Rope> coils = new ArrayList<>();

		Rope r = new Rope(190);
		Rope r1 = new Rope(170);
		Rope r2 = new Rope(150);
		Rope r3 = new Rope(140);
		Rope r4 = new Rope(130);
		Rope r5 = new Rope(120);
		Rope r6 = new Rope(110);
		Rope r7 = new Rope(140);

		orders.add(100);
		orders.add(90);
		orders.add(100);
		orders.add(70);
		orders.add(100);
		orders.add(50);
		orders.add(100);
		orders.add(40);
		orders.add(100);
		orders.add(30);
		orders.add(100);
		orders.add(20);
		orders.add(100);
		orders.add(10);

		coils.add(0, r);
		coils.add(1, r1);
		coils.add(2, r2);
		coils.add(3, r3);
		coils.add(4, r4);
		coils.add(5, r5);
		coils.add(6, r6);
		coils.add(7, r7);

		a.nextFit(orders, coils);
		System.out.println("Next Fit 5\n" + a);

	}

}
