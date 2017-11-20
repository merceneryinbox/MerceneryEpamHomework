package homework.epam.mod1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public class EpamHomeWork_2_FunctionWithMargins {
	private int leftMargin  = 10;
	private int rightMargin = 68;
	
	public static void main(String[] args) {
		startFx();
	}
	
	/**
	 *
	 */
	public static void startFx() {
		int leftMargin  = getLeftMargin();
		int rightMargin = getRightMargin();
		int step        = getStep();
		fx(leftMargin, rightMargin, step);
	}
	
	/**
	 * @return
	 */
	
	public static int getLeftMargin() {
		String sl = null;
		System.out.println("Input left margin: \n");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			sl = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (sl == null) {
			System.out.println("Null left margin inputed, input Integer please.");
			throw new IllegalArgumentException("NULLINPUT");
		}
		
		if (sl.equalsIgnoreCase("quit")) {
			System.out.println("User need to exit from programm.");
			System.exit(0);
		}
		int testM = Integer.parseInt(sl);
		return new Integer(testM);
		
	}
	
	/**
	 * @return
	 */
	public static int getRightMargin() {
		String sr = null;
		System.out.println("Input right margin: \n");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			sr = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (sr == null) {
			System.out.println("Null right margin inputed,input Integer please.");
			throw new IllegalArgumentException("NULLINPUT");
		}
		
		if (sr.equalsIgnoreCase("quit")) {
			System.out.println("User need to exit from programm.");
			System.exit(0);
		}
		int testM = Integer.parseInt(sr);
		return new Integer(testM);
	}
	
	/**
	 * @return
	 */
	public static int getStep() {
		String step = null;
		System.out.println("Input step margin: \n");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			step = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (step == null) {
			System.out.println("Null step inputed,input Integer please.");
			throw new IllegalArgumentException("NULLINPUT");
		}
		
		if (step.equalsIgnoreCase("quit")) {
			System.out.println("User need to exit from programm.");
			System.exit(0);
		}
		int testM = Integer.parseInt(step);
		return new Integer(testM);
	}
	
	/**
	 * @param x
	 * @param y
	 * @param h
	 */
	public static void fx(int x, int y, int h) {
		while (x <= y) {
			int    fxresult         = (int) (Math.tan(2 * x) - 3);
			String testNumOfSimbols = "" + x;
			int    lenght           = testNumOfSimbols.length();
			switch (lenght) {
				case 1:
					System.out.println("________________");
					System.out.println("| " + x + "      | " + fxresult + "|");
					System.out.println("________________");
					
					break;
				case 2:
					System.out.println("| " + x + "     | " + fxresult + "|");
					System.out.println("_______________");
					
					break;
				case 3:
					System.out.println("| " + x + "    | " + fxresult + "|");
					System.out.println("______________");
					
					break;
				case 4:
					System.out.println("| " + x + "   | " + fxresult + "|");
					System.out.println("_____________");
					
					break;
				case 5:
					System.out.println("| " + x + " | " + fxresult + "|");
					System.out.println("____________");
					
					break;
				case 6:
					System.out.println("| " + x + "| " + fxresult + "|");
					System.out.println("___________");
					
					break;
				case 7:
					System.out.println("| " + x + " | " + fxresult + "|");
					System.out.println("__________");
					
					break;
			}
			x = x + h;
		}
	}
}

