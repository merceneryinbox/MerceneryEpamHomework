/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework.epam.mod2;

import java.util.Objects;

/**
 *
 * @author FedulovOV
 */
public class Pen {

    public Pen() {
    }

    public Pen(String type, String colorWrite) {
    }

    String penType = "Gelly";

    String color = "blue";

    @Override
    public String toString() {
        return "This is " + this.getPenType() + " pen and it's write with " + this.getColor() + " ink.";//To change body of generated methods, choose Tools | Templates.
    }

    public String getPenType() {
        return penType;
    }

    public void setPenType(String penType) {
        this.penType = penType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pen)) return false;
        Pen pen = (Pen) o;
        return Objects.equals(getPenType(), pen.getPenType()) && Objects.equals(getColor(), pen.getColor());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPenType(), getColor());
    }

    /**
     *
     * @param anotherPen - сравниваемая ручка.
     * @return результат посимвольного сравнения полей строковых типов this и
     * anotherPen
     */
    private boolean forEqualsSequanceCompare(Pen anotherPen) {
        boolean result = true;
        char[] mePenColorCharArray = this.getColor().toCharArray();
        char[] mePenTypeCharArray = this.getPenType().toCharArray();

        char[] anotherPenColorCharArray = anotherPen.getColor().toCharArray();
        char[] anotherPenTypeCharArray = anotherPen.getColor().toCharArray();

        for (int colorArIndex = 0; colorArIndex < this.getColor().length(); colorArIndex++) {
            if (mePenColorCharArray[colorArIndex] != anotherPenColorCharArray[colorArIndex]) {
                result = false;
                break;
            }
        }

        for (int typeArIndex = 0; typeArIndex < this.getPenType().length(); typeArIndex++) {
            if (mePenTypeCharArray[typeArIndex] != anotherPenTypeCharArray[typeArIndex]) {
                result = false;
                break;

            }
        }
        return result;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO (41, 4)  @Override hash, equals, toString !!!!
    }

}
