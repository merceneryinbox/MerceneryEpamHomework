package homework.epam.mod2.task3inheritance.StationHerarchy.extStats;

import homework.epam.mod2.task3inheritance.StationHerarchy.mainStats.StatsMainPaper;

import java.util.Objects;

/**
 *
 *
 */
public class AlbumForPainting extends StatsMainPaper {
	private String name = "Album";
	private double cost;
	/**
	 *
	 */
	private String mainProperty = "size A3";
	
	/**
	 *
	 */
	public AlbumForPainting() {
		setMainProperty(mainProperty);
		setName(name);
		setCost(350.00);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AlbumForPainting a = new AlbumForPainting();
		System.out.println("a = " + a.getMainProperty() + "  " + a.getName() + "  " + a.getCost());
	}
	
	/**
	 * @param o
	 * @return
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AlbumForPainting)) return false;
		AlbumForPainting that = (AlbumForPainting) o;
		return Double.compare(that.getCost(), getCost()) == 0 && Objects.equals(getName(), that.getName()) &&
		       Objects.equals(getMainProperty(), that.getMainProperty());
	}
	
	/**
	 * @return
	 */
	@Override
	public double getCost() {
		return cost;
	}
	
	/**
	 * @return
	 */
	@Override
	public String getName() {
		return name;
	}
	
	/**
	 * @return
	 */
	@Override
	public String getMainProperty() {
		return mainProperty;
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
	@Override
	public int hashCode() {
		
		return Objects.hash(getName(), getCost(), getMainProperty());
	}
	
	/**
	 * @return
	 */
	@Override
	protected String extras() {
		return mainProperty;
	}
}
