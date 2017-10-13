/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework.epam.mod2;

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

    /**
     *
     * @param obj
     * @return equality
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Pen)) {
            return false;
        }

        if (this.hashCode() != obj.hashCode()) {
            return false;
        }
        return forEqualsSequanceCompare((Pen) obj);
    }

    /**
     *
     * @return сумму символов в виде int
     */
    @Override
    public int hashCode() {
        int resultCharsSumFunction = 0;
        char[] colorAr = this.getColor().toCharArray();
        char[] typeAr = this.getPenType().toCharArray();

        if (this.getColor() != null) {
            for (int i = 0; i < this.getColor().length(); i++) {
                resultCharsSumFunction = resultCharsSumFunction + (byte) colorAr[i];
            }
        }
        if (this.getPenType() != null) {
            for (int j = 0; j < this.getPenType().length(); j++) {
                resultCharsSumFunction = resultCharsSumFunction + (byte) typeAr[j];
            }
        }
        return resultCharsSumFunction;
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
