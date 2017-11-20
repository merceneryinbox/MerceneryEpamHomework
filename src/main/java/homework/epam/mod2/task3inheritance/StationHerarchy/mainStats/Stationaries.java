package homework.epam.mod2.task3inheritance.StationHerarchy.mainStats;

/**
 *
 */
public abstract class Stationaries {
	String firm = "DefaultFirm";
	String name = "DefaultName";
	double cost = 0;
	
	/**
	 *
	 */
	public Stationaries() {
	}
	
	/**
	 * @param firm
	 * @param name
	 * @param cost
	 */
	public Stationaries(String firm, String name, double cost) {
		this.firm = firm;
		this.name = name;
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
	public double getCost() {
		return cost;
	}
	
	/**
	 * @param cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
}
