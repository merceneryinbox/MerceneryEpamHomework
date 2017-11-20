package homework.epam.mod2.task5ParametrizeEnums.subjectsExtClass;

import homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass.StudentSubscriber;
import homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass.SubjectPublisher;

import java.util.Map;
import java.util.Objects;

/**
 *
 */
public class Literature implements SubjectPublisher {
	private final String studName = "Literature";
	private Map<StudentSubscriber, Double> literatureSrudentsMarksMap;
	
	/**
	 * @return
	 */
	public String getStudName() {
		return studName;
	}
	
	/**
	 * @return
	 */
	public Map<StudentSubscriber, Double> getLiteratureSrudentsMarksMap() {
		return literatureSrudentsMarksMap;
	}
	
	/**
	 * @param literatureSrudentsMarksMap
	 */
	public void setLiteratureSrudentsMarksMap(Map<StudentSubscriber, Double> literatureSrudentsMarksMap) {
		this.literatureSrudentsMarksMap = literatureSrudentsMarksMap;
	}
	
	/**
	 * @param o
	 * @return
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Literature)) return false;
		Literature that = (Literature) o;
		return Objects.equals(studName, that.studName);
	}
	
	/**
	 * @return
	 */
	@Override
	public int hashCode() {
		
		return Objects.hash(studName);
	}
	
	/**
	 * @return
	 */
	@Override
	public String toString() {
		return studName;
	}
	
	/**
	 * @param student
	 */
	@Override
	public void register(StudentSubscriber student) {
		literatureSrudentsMarksMap.put(student, 5.00);
		notifyStudent(student);
	}
	
	/**
	 * @param studentSubscriber
	 */
	@Override
	public void notifyStudent(StudentSubscriber studentSubscriber) {
		studentSubscriber.setMark(this, literatureSrudentsMarksMap.get(studentSubscriber));
	}
	
	/**
	 * @param student
	 */
	@Override
	public void unRegister(StudentSubscriber student) {
		literatureSrudentsMarksMap.remove(student);
		notifyStudent(student);
		
	}
	
	/**
	 * @param student
	 * @param mark
	 */
	@Override
	public void setMarkOnStudent(StudentSubscriber student, Double mark) {
		literatureSrudentsMarksMap.put(student, mark);
		notifyStudent(student);
		
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
	
	}
}
