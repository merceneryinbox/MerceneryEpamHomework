package homework.epam.mod2.task3inheritance.StationHerarchy.mainStats;

public abstract class DrawingTool implements Stationaries {
    private String name = "Drawing tool";
    private String typeDrawingTool = "Pencil";
    private String drawColor = "Blue";
    private boolean writeingWithInk = true;
    private boolean automatic = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DrawingTool() {
    }

    public DrawingTool(String typeDrawingTool, String drawColor, boolean writeingWithInk, boolean automatic) {
        this.typeDrawingTool = typeDrawingTool;
        this.drawColor = drawColor;
        this.writeingWithInk = writeingWithInk;
        this.automatic = automatic;
    }

    protected abstract String superProperties();

    protected abstract int getKernelsCount();

    protected abstract double getCost();

    public String getTypeDrawingTool() {
        return typeDrawingTool;
    }

    public void setTypeDrawingTool(String typeDrawingTool) {
        this.typeDrawingTool = typeDrawingTool;
    }

    public String getDrawColor() {
        return drawColor;
    }

    public void setDrawColor(String drawColor) {
        this.drawColor = drawColor;
    }

    public boolean isWriteingWithInk() {
        return writeingWithInk;
    }

    public void setWriteingWithInk(boolean writeingWithInk) {
        this.writeingWithInk = writeingWithInk;
    }

    public boolean isAutomatic() {
        return automatic;
    }

    public void setAutomatic(boolean automatic) {
        this.automatic = automatic;
    }
}
