package week1.bstmaintenance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSolve2500() throws FileNotFoundException {
		Scanner in = new Scanner(new File("BSTMaintenace-2500.in"));
		Solution.solve(in);
	}
	
	@Test
	public void testSolve25000() throws FileNotFoundException {
		Scanner in = new Scanner(new File("BSTMaintenace-25000.in"));
		Solution.solve(in);
	}
	
	@Test
	public void testSolve250000() throws FileNotFoundException {
		Scanner in = new Scanner(new File("BSTMaintenace-250000.in"));
		Solution.solve(in);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		PrintStream out = new PrintStream(new File("BSTMaintenace-2500.in"));
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 2500; i++) {
			list.add(i);
		}
		Collections.shuffle(list);
		out.println(2500);
		for (Integer number : list) {
			out.print(number + " ");
		}
		out.close();
	}
	
}
