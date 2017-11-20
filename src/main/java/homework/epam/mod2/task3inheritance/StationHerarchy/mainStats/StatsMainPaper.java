package homework.epam.mod2.task3inheritance.StationHerarchy.mainStats;

/**
 *
 */
public abstract class StatsMainPaper extends Stationaries {
	private String name         = "Papers";
	private String mainProperty = "Paper";
	private double cost         = 10.00;
	
	/**
	 *
	 */
	public StatsMainPaper() {
	}
	
	/**
	 * @param mainProperty
	 */
	public StatsMainPaper(String mainProperty) {
		this.mainProperty = mainProperty;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StatsMainPaper s = new StatsMainPaper() {
			@Override
			protected String extras() {
				return "Extras";
			}
		};
		System.out.println(s.getName());
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
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return
	 */
	protected abstract String extras();
	
	/**
	 * @return
	 */
	
	public String getMainProperty() {
		return mainProperty;
	}
	
	/**
	 * @param mainProperty
	 */
	public void setMainProperty(String mainProperty) {
		this.mainProperty = mainProperty;
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
