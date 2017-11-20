package homework.epam.mod2.task3inheritance.StationHerarchy.mainStats;

/**
 *
 */
public abstract class DrawingTool extends Stationaries {
	private String  name            = "Drawing tool";
	private String  typeDrawingTool = "Pencil";
	private String  drawColor       = "Blue";
	private boolean writeingWithInk = true;
	private boolean automatic       = false;
	private double  cost            = 10.22;
	
	/**
	 *
	 */
	public DrawingTool() {
	}
	
	/**
	 * @param firm
	 * @param name
	 * @param cost
	 * @param typeDrawingTool
	 * @param drawColor
	 * @param writeingWithInk
	 * @param automatic
	 */
	public DrawingTool(String firm, String name, double cost, String typeDrawingTool, String drawColor,
	                   boolean writeingWithInk, boolean automatic) {
		super(firm, name, cost);
		this.typeDrawingTool = typeDrawingTool;
		this.drawColor = drawColor;
		this.writeingWithInk = writeingWithInk;
		this.automatic = automatic;
	}
	
	/**
	 * @return
	 */
	protected abstract int getKernelsCount();
	
	/**
	 * @return
	 */
	public String getTypeDrawingTool() {
		return typeDrawingTool;
	}
	
	/**
	 * @param typeDrawingTool
	 */
	public void setTypeDrawingTool(String typeDrawingTool) {
		this.typeDrawingTool = typeDrawingTool;
	}
	
	/**
	 * @return
	 */
	public String getDrawColor() {
		return drawColor;
	}
	
	/**
	 * @param drawColor
	 */
	public void setDrawColor(String drawColor) {
		this.drawColor = drawColor;
	}
	
	/**
	 * @return
	 */
	public boolean isWriteingWithInk() {
		return writeingWithInk;
	}
	
	/**
	 * @param writeingWithInk
	 */
	public void setWriteingWithInk(boolean writeingWithInk) {
		this.writeingWithInk = writeingWithInk;
	}
	
	/**
	 * @return
	 */
	public boolean isAutomatic() {
		return automatic;
	}
	
	/**
	 * @param automatic
	 */
	public void setAutomatic(boolean automatic) {
		this.automatic = automatic;
	}
	
	/**
	 * @return
	 */
	public double getCost() {
		return cost;
	}
	
	/**
	 * @param cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	/**
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
}
