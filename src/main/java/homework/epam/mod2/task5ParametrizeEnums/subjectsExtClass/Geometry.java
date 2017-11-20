package homework.epam.mod2.task5ParametrizeEnums.subjectsExtClass;

import homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass.StudentSubscriber;
import homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass.SubjectPublisher;

import java.util.Map;
import java.util.Objects;

/**
 *
 */
public class Geometry implements SubjectPublisher {
	private final String subjName = "Geometry";
	private Map<StudentSubscriber, Integer> studsMarksBase;
	private Integer                         mark;
	
	/**
	 * @return
	 */
	public Map<StudentSubscriber, Integer> getStudsMarksBase() {
		return studsMarksBase;
	}
	
	/**
	 * @param studsMarksBase
	 */
	public void setStudsMarksBase(Map<StudentSubscriber, Integer> studsMarksBase) {
		this.studsMarksBase = studsMarksBase;
	}
	
	/**
	 * @return
	 */
	public Integer getMark() {
		return mark;
	}
	
	/**
	 * @param mark
	 */
	public void setMark(Integer mark) {
		this.mark = mark;
	}
	
	/**
	 * @param studentSubscriber
	 */
	public void getStudsAllGeometryMarks(StudentSubscriber studentSubscriber) {
		for (Map.Entry en : studsMarksBase.entrySet()) {
			System.out.println("Student " + en.getKey() + " had mark = " + en.getValue());
		}
	}
	
	/**
	 * @param studentSubscriber
	 * @param mark
	 */
	public void setMark(StudentSubscriber studentSubscriber, int mark) {
		studsMarksBase.put(studentSubscriber, mark);
		notifyStudent(studentSubscriber);
	}
	
	/**
	 * @param studentSubscriber
	 */
	@Override
	public void notifyStudent(StudentSubscriber studentSubscriber) {
		studentSubscriber.unSubscribeFromSubj(this);
	}
	
	/**
	 * @param o
	 * @return
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Geometry)) return false;
		Geometry geometry = (Geometry) o;
		return Objects.equals(getSubjName(), geometry.getSubjName());
	}
	
	/**
	 * @return
	 */
	public String getSubjName() {
		return subjName;
	}
	
	/**
	 * @return
	 */
	@Override
	public int hashCode() {
		
		return Objects.hash(getSubjName());
	}
	
	/**
	 * @return
	 */
	@Override
	public String toString() {
		return super.toString();
	}
	
	/**
	 * @param student
	 */
	@Override
	public void register(StudentSubscriber student) {
	
	}
	
	/**
	 * @param student
	 */
	@Override
	public void unRegister(StudentSubscriber student) {
	
	}
	
	/**
	 * @param student
	 * @param mark
	 */
	@Override
	public void setMarkOnStudent(StudentSubscriber student, Double mark) {
	
	}
	
	/**
	 * @param student
	 * @param mark
	 */
	@Override
	public void setMarkOnStudent(StudentSubscriber student, Integer mark) {
	
	}
	
	/**
	 *
	 */
	@Override
	public void getSubscribedStudents() {
		System.out.println("Students subscribed for geometry : ");
		System.out.println();
		for (Map.Entry entry : studsMarksBase.entrySet()) {
			System.out.println("Srudent = " + entry.getKey());
		}
	}
}