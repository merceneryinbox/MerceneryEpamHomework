package homework.epam.mod2.task3inheritance.StationHerarchy.mainStats;

public abstract class StatsMainPaper implements Stationaries {
    private String name = "Papers";
    private String mainProperty = "Paper";
    private double cost = 10.00;


    public StatsMainPaper() {
    }

    public StatsMainPaper(String mainProperty) {
        this.mainProperty = mainProperty;
    }

    public void setMainProperty(String mainProperty) {
        this.mainProperty = mainProperty;
    }

    protected abstract String extras();


    public String getMainProperty() {
        return mainProperty;
    }

    public String getName() {
        return name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setName(String name) {
        setName(name);
    }
}
