package homework.epam.mod2.task3inheritance.StationHerarchy.extStats;

import homework.epam.mod2.task3inheritance.StationHerarchy.mainStats.DrawingTool;

/**
 *
 */
public class PilotDrawingPen extends DrawingTool {
	/**
	 *
	 */
	public PilotDrawingPen() {
		super("Pilot drawing Pen firm", "Pilot Pen", 560.00, "Multi types kernels", "Three colors pen", true, true);
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
	protected String superProperties() {
		return "Stylus included";
	}
	
	/**
	 * @return
	 */
	@Override
	protected int getKernelsCount() {
		return 4;
	}
	
	/**
	 * @return
	 */
	@Override
	public double getCost() {
		return 4000.00;
	}
}
