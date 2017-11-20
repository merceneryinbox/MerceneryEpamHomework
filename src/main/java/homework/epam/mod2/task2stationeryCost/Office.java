package homework.epam.mod2.task2stationeryCost;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by on 04.10.2017.
 */
public class Office {
	private static List<Person> personsInOffice = new ArrayList<>();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p1 = new Person(new Tools(TypeOfTool.PAPER, 350), 10);
		p1.appendTool(new Tools(TypeOfTool.PAPER, 350), 10);
		Person p2 = new Person(new Tools(TypeOfTool.PAPER, 350), 8);
		Person p3 = new Person(new Tools(TypeOfTool.LASTIC, 50), 15);
		Person p4 = new Person(new Tools(TypeOfTool.CIRCLE, 150), 190);
		Person p5 = new Person(new Tools(TypeOfTool.RULER, 30), 110);
		
		getPersonsInOffice().add(p1);
		getPersonsInOffice().add(p2);
		getPersonsInOffice().add(p3);
		getPersonsInOffice().add(p4);
		getPersonsInOffice().add(p5);
		
		System.out.println("personsInOffice = " + getMeOfficeCost());
		
	}
	
	/**
	 * @return
	 */
	public static List<Person> getPersonsInOffice() {
		return personsInOffice;
	}
	
	/**
	 * @return
	 */
	public static double getMeOfficeCost() {
		double resultOfficeSum = 0;
		for (Person p : personsInOffice) {
			resultOfficeSum = resultOfficeSum + p.getSumPrice();
			
		}
		return resultOfficeSum;
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
}
