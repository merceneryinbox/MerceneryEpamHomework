package homework.epam.mod2.task3inheritance.StationHerarchy.extStats;

import homework.epam.mod2.task3inheritance.StationHerarchy.mainStats.DrawingTool;

import java.util.Objects;

/**
 *
 */
public class PlainPencil extends DrawingTool {
	private double cost = 1.23;
	private String name = "Plain Pencil";
	private String firm;
	private String drawColor = "Plain";
	
	/**
	 * @param drawColor
	 * @param writeingWithInk
	 * @param automatic
	 */
	public PlainPencil(String drawColor, boolean writeingWithInk, boolean automatic) {
		this();
		setDrawColor(drawColor);
		setWriteingWithInk(writeingWithInk);
		setAutomatic(automatic);
	}
	
	/**
	 *
	 */
	public PlainPencil() {
		super("Pencil for Senior", "Plain Pencil", 1.23, "Plain", "Black", false, false);
	}
	
	/**
	 * @param cost
	 * @param firm
	 */
	public PlainPencil(double cost, String firm) {
		super(firm, "Plain Pencil", cost, "Plain", "Black", false, false);
		this.cost = cost;
		this.firm = firm;
	}
	
	/**
	 * @param o
	 * @return
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PlainPencil)) return false;
		PlainPencil that = (PlainPencil) o;
		return Double.compare(that.getCost(), getCost()) == 0 && Objects.equals(getName(), that.getName()) &&
		       Objects.equals(getFirm(), that.getFirm()) && Objects.equals(getDrawColor(), that.getDrawColor());
	}
	
	/**
	 * @return
	 */
	@Override
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
	public String getFirm() {
		return firm;
	}
	
	/**
	 * @param firm
	 */
	public void setFirm(String firm) {
		this.firm = firm;
	}
	
	/**
	 * @return
	 */
	@Override
	public int hashCode() {
		
		return Objects.hash(getCost(), getName(), getFirm(), getDrawColor());
	}
	
	/**
	 * @return
	 */
	protected String superProperties() {
		return null;
	}
	
	/**
	 * @return
	 */
	@Override
	protected int getKernelsCount() {
		return 1;
	}
}