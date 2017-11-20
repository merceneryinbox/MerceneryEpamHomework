package homework.epam.mod2.task3inheritance.StationHerarchy.extStats;

import homework.epam.mod2.task3inheritance.StationHerarchy.mainStats.DrawingTool;

/**
 *
 */
public class AutomathicPencil extends DrawingTool {
	/**
	 *
	 */
	public AutomathicPencil() {
		super("Automathic Pencil type", "AutoPencil", 100.00, "AutoPencil", "Black", false, true);
	}
	
	/**
	 * .
	 *
	 * @return
	 */
	protected String superProperties() {
		return "Plain black graphite";
	}
	
	/**
	 * @return
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	/**
	 * @param obj
	 * @return
	 */
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	/**
	 * @return
	 */
	@Override
	public String toString() {
		return super.toString();
	}
	
	/**
	 * @return
	 */
	@Override
	protected int getKernelsCount() {
		return 1;
	}
	
	/**
	 * @return
	 */
	@Override
	public double getCost() {
		return 100.00;
	}
}
