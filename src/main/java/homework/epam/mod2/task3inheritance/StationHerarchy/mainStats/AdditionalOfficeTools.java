package homework.epam.mod2.task3inheritance.StationHerarchy.mainStats;

/**
 *
 */
public abstract class AdditionalOfficeTools extends Stationaries {
	private String name = "Additional Tool";
	private double cost = 2.00;
	private String firm;
	
	private int count = 1;
	
	/**
	 *
	 */
	public AdditionalOfficeTools() {
		setCost(15.55);
		setFirm("Crause");
	}
	
	/**
	 * @param cost
	 * @param firm
	 * @param name
	 * @param count
	 */
	public AdditionalOfficeTools(double cost, String firm, String name, int count) {
		setCount(count);
		cost = count * count;
		setCost(cost);
		setFirm(firm);
		setName(name);
	}
	
	/**
	 * @return
	 */
	public abstract String newProperty();
	
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
	public String getName() {
		return name;
	}
	
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * @param count
	 */
	public void setCount(int count) {
		this.count = count;
	}
}
