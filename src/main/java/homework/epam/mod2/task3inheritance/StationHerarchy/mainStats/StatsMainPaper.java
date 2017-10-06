package homework.epam.mod2.task3inheritance.StationHerarchy.mainStats;

public abstract class StatsMainPaper implements Stationaries {
    private String name = "Paper product for work";
    private String mainProperty = "Paper";


    public void setName(String name) {
        this.name = name;
    }

    public void setMainProperty(String mainProperty) {
        this.mainProperty = mainProperty;
    }

    public StatsMainPaper() {
    }

    public StatsMainPaper(String mainProperty) {
        this.mainProperty = mainProperty;
    }

    public String getMainProperty() {
        return mainProperty;
    }

    protected abstract String getName();

    protected abstract String extras();

    protected abstract double getCost();
}
