package homework.epam.mod2.task3inheritance.StationHerarchy.extStats;

import homework.epam.mod2.task3inheritance.StationHerarchy.mainStats.StatsMainPaper;

import java.util.Objects;

/**
 *
 */
public class NoteBook extends StatsMainPaper {
	private String covertype  = "Soft cove";
	private String name       = "SimpleNoteBook";
	private int    countPages = 36;
	private String pagesType  = "Lines";
	
	/**
	 *
	 */
	public NoteBook() {
	
	}
	
	/**
	 * @param name
	 * @param countPages
	 * @param pagesType
	 * @param covertype
	 */
	public NoteBook(String name, int countPages, String pagesType, String covertype) {
		this.name = name;
		this.setCountPages(countPages);
		this.setPagesType(pagesType);
		this.setCovertype(covertype);
	}
	
	/**
	 * @param o
	 * @return
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof NoteBook)) return false;
		NoteBook noteBook = (NoteBook) o;
		return getCountPages() == noteBook.getCountPages() && Objects.equals(getCovertype(), noteBook.getCovertype()) &&
		       Objects.equals(getName(), noteBook.getName()) && Objects.equals(getPagesType(), noteBook.getPagesType());
	}
	
	/**
	 * @return
	 */
	public int getCountPages() {
		return countPages;
	}
	
	/**
	 * @param countPages
	 */
	public void setCountPages(int countPages) {
		this.countPages = countPages;
	}
	
	/**
	 * @return
	 */
	public String getCovertype() {
		return covertype;
	}
	
	/**
	 * @param covertype
	 */
	public void setCovertype(String covertype) {
		this.covertype = covertype;
	}
	
	/**
	 * @return
	 */
	@Override
	public String getName() {
		return name;
	}
	
	/**
	 * @return
	 */
	public String getPagesType() {
		return pagesType;
	}
	
	/**
	 * @param pagesType
	 */
	public void setPagesType(String pagesType) {
		this.pagesType = pagesType;
	}
	
	/**
	 * @return
	 */
	@Override
	public int hashCode() {
		
		return Objects.hash(getCovertype(), getName(), getCountPages(), getPagesType());
	}
	
	/**
	 * @return
	 */
	@Override
	protected String extras() {
		return "Gloss supercover";
	}
	
	/**
	 * @return
	 */
	@Override
	public double getCost() {
		return 500.00;
	}
}