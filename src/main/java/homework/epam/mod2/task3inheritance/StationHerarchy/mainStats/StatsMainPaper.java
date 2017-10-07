package homework.epam.mod2.task3inheritance.StationHerarchy.mainStats;

public abstract class StatsMainPaper extends Stationaries {
    private String name = "Papers";
    private String mainProperty = "Paper";
    private double cost = 10.00;


    protected abstract String extras();

    public StatsMainPaper() {
    }

    public StatsMainPaper(String mainProperty) {
        this.mainProperty = mainProperty;
    }

    public void setMainProperty(String mainProperty) {
        this.mainProperty = mainProperty;
    }


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

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        StatsMainPaper s = new StatsMainPaper() {
            @Override
            protected String extras() {
                return "Extras";
            }
        };
        System.out.println(s.getName());
    }
}
