package homework.epam.mod2.task3inheritance.StationHerarchy.extStats;

import homework.epam.mod2.task3inheritance.StationHerarchy.mainStats.StatsMainPaper;

public class NoteBook extends StatsMainPaper {
    private String name = "SimpleNoteBook";
    private int countPages = 36;
    private String pagesType = "Lines";

    public NoteBook() {

    }

    public NoteBook(String name, int countPages, String pagesType, String covertype) {
        this.setName(name);
        this.setCountPages(countPages);
        this.setPagesType(pagesType);
        this.setCovertype(covertype);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountPages() {
        return countPages;
    }

    public void setCountPages(int countPages) {
        this.countPages = countPages;
    }

    public String getPagesType() {
        return pagesType;
    }

    public void setPagesType(String pagesType) {
        this.pagesType = pagesType;
    }

    public String getCovertype() {
        return covertype;
    }

    public void setCovertype(String covertype) {
        this.covertype = covertype;
    }

    private String covertype = "Soft cove";

    @Override
    public String getName() {
        return name;
    }

    @Override
    protected String extras() {
        return "Gloss supercover";
    }

    @Override
    protected double getCost() {
        return 500.00;
    }

}