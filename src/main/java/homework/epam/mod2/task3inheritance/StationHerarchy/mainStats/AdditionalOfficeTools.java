package homework.epam.mod2.task3inheritance.StationHerarchy.mainStats;

public abstract class AdditionalOfficeTools implements Stationaries {
    private double cost;
    private String firm;

    public AdditionalOfficeTools() {
        setCost(15.55);
        setFirm("Crause");
    }

    public AdditionalOfficeTools(double cost, String firm) {
        setCost(cost);
        setFirm(firm);
    }

    public abstract String whatForProperty();

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
}
