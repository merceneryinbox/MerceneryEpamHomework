package homework.epam.mod2.task2stationeryCost;


import java.util.Objects;

/**
 * Created by karapuz on 04.10.2017.
 */
public class Tools {
	private TypeOfTool typeOfTool;
	private double     price;
	
	/**
	 * @param typeOfTool
	 * @param price
	 */
	public Tools(TypeOfTool typeOfTool, double price) {
		this.typeOfTool = typeOfTool;
		setPrice(price);
	}
	
	/**
	 * @param o
	 * @return
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Tools)) return false;
		Tools tools = (Tools) o;
		return Double.compare(tools.getPrice(), getPrice()) == 0 && getTypeOfTool() == tools.getTypeOfTool();
	}
	
	/**
	 * @return
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * @return
	 */
	public TypeOfTool getTypeOfTool() {
		
		return typeOfTool;
	}
	
	/**
	 * @param typeOfTool
	 */
	public void setTypeOfTool(TypeOfTool typeOfTool) {
		this.typeOfTool = typeOfTool;
	}
	
	/**
	 * @return
	 */
	@Override
	public int hashCode() {
		
		return Objects.hash(getTypeOfTool(), getPrice());
	}
}
