package homework.epam.mod2.task3inheritance.StationHerarchy.mainStats;

public abstract class AdditionalOfficeTools extends Stationaries {
    private String name = "Additional Tool";
    private double cost;
    private String firm;

    private int count = 1;

    public AdditionalOfficeTools() {
        setCost(15.55);
        setFirm("Crause");
    }

    public AdditionalOfficeTools(double cost, String firm, String name, int count) {
        setCount(count);
        cost = count * count;
        setCost(cost);
        setFirm(firm);
        setName(name);
    }

    public abstract String newProperty();

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
