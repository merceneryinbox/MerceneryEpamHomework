package homework.epam.mod2.task2stationeryCost;


/**
 * Created by karapuz on 04.10.2017.
 */
public class Tools {
    private TypeOfTool typeOfTool;
    private double price;

    public double getPrice() {
        return price;
    }

    public Tools(TypeOfTool typeOfTool, double price) {
        this.typeOfTool = typeOfTool;
        setPrice(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TypeOfTool getTypeOfTool() {
        return typeOfTool;
    }

    public void setTypeOfTool(TypeOfTool typeOfTool) {
        this.typeOfTool = typeOfTool;
    }
    }
