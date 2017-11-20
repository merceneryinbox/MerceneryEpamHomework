package homework.epam.mod2.task2stationeryCost;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by karapuz on 04.10.2017.
 */
public class Person {
	private Set<Tools> toolsSet = new HashSet<>();
	private int numOfTools;
	
	/**
	 * @param tools
	 * @param i
	 */
	public Person(Tools tools, int i) {
		this.appendTool(tools, i);
		
	}
	
	/**
	 * @param t
	 * @param count
	 * @return
	 */
	public Person appendTool(Tools t, int count) {
		toolsSet.add(t);
		return this;
	}
	
	/**
	 * @param o
	 * @return
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Person)) return false;
		Person person = (Person) o;
		return getNumOfTools() == person.getNumOfTools() && Objects.equals(toolsSet, person.toolsSet);
	}
	
	/**
	 * @return
	 */
	public int getNumOfTools() {
		numOfTools = toolsSet.size();
		return numOfTools;
	}
	
	/**
	 * @return
	 */
	@Override
	public int hashCode() {
		
		return Objects.hash(toolsSet, getNumOfTools());
	}
	
	/**
	 * @return
	 */
	
	public double getSumPrice() {
		double sum = 0;
		
		for (Tools t : toolsSet) {
			sum = sum + t.getPrice();
		}
		return sum;
	}

//    public static void main(String[] args) {
//        Person p1 = new Person();
//        p1.appendTool(new Tools(TypeOfTool.CIRCLE, 1000), 4)
//                .appendTool(new Tools(TypeOfTool.LASTIC, 500), 3)
//                .appendTool(new Tools(TypeOfTool.PAPER, 350), 10);
//
//    }
}
