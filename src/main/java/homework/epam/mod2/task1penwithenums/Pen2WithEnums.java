/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework.epam.mod2.task1penwithenums;

/**
 * @author FedulovOV
 */
public class Pen2WithEnums {
	/**
	 *
	 */
	private inkColor color;
	private penTypes type;
	
	/**
	 *
	 */
	public Pen2WithEnums() {
		setColor(inkColor.BLUE);
		setType(penTypes.INK);
	}
	/**
	 * @param color
	 * @param type
	 */
	public Pen2WithEnums(inkColor color, penTypes type) {
		this.color = color;
		this.type = type;
		
	}
	
	/**
	 * @return
	 */
	@Override
	public String toString() {
		
		return "This is " + this.type.name() + " with " + this.color +
		       " color"; //To change body of generated methods, choose Tools | Templates.
	}
	
	/**
	 * @param obj
	 * @return
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Pen2WithEnums)) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		Pen2WithEnums anotherPen = (Pen2WithEnums) obj;
		return this.getType() == anotherPen.getType() ? this.getColor() == anotherPen.getColor() : false;
	}
	
	/**
	 * @return
	 */
	public penTypes getType() {
		return type;
	}
	
	/**
	 * @return
	 */
	public inkColor getColor() {
		return color;
	}
	
	/**
	 * @param color
	 */
	public void setColor(inkColor color) {
		this.color = color;
	}
	
	/**
	 * @param type
	 */
	public void setType(penTypes type) {
		this.type = type;
	}
	
	/**
	 * @return
	 */
	@Override
	public int hashCode() {
		return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
	}
	
}
