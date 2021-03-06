package homework.epam.mod2.task5ParametrizeEnums.subjectsExtClass;

import homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass.StudentSubscriber;
import homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass.SubjectPublisher;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 */
public class Biology implements SubjectPublisher {
	private final String                         subjectName      = "Biology";
	private       Map<StudentSubscriber, Double> studentsAndMarks = new HashMap<>();
	
	/**
	 * @param student
	 */
	@Override
	public void register(StudentSubscriber student) {
		studentsAndMarks.put(student, 5.00);
	}
	
	/**
	 * @param student
	 */
	@Override
	public void unRegister(StudentSubscriber student) {
		studentsAndMarks.remove(student);
	}
	
	/**
	 * @param student
	 * @param mark
	 */
	@Override
	public void setMarkOnStudent(StudentSubscriber student, Double mark) {
		studentsAndMarks.put(student, mark);
		notifyStudent(student);
	}
	
	/**
	 * @param studentSubscriber
	 */
	@Override
	public void notifyStudent(StudentSubscriber studentSubscriber) {
		studentSubscriber.setMark(this, studentsAndMarks.get(studentSubscriber)
				.doubleValue());
	}
	
	/**
	 * @param student
	 * @param mark
	 */
	@Override
	public void setMarkOnStudent(StudentSubscriber student, Integer mark) {
	
	}
	
	/**
	 * @param o
	 * @return
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Biology)) return false;
		Biology biology = (Biology) o;
		return Objects.equals(subjectName, biology.subjectName);
	}
	
	/**
	 * @return
	 */
	@Override
	public int hashCode() {
		
		return Objects.hash(subjectName);
	}
	
	/**
	 * @return
	 */
	@Override
	public String toString() {
		return subjectName;
	}
	
	/**
	 *
	 */
	@Override
	public void getSubscribedStudents() {
		for (Map.Entry entry : studentsAndMarks.entrySet()) {
			System.out.println(entry.getKey() + " with mark " + entry.getValue());
		}
	}
}
