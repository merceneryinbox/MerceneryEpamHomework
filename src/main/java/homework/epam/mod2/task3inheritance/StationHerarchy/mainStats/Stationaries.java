package homework.epam.mod2.task3inheritance.StationHerarchy.mainStats;

public abstract class Stationaries {
    String firm = "DefaultFirm";
    String name = "DefaultName";
    double cost = 0;

    public Stationaries() {
    }

    public Stationaries(String firm, String name, double cost) {
        this.firm = firm;
        this.name = name;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
// TODO: 12.10.2017  @Override hash, equals, toString !!!!