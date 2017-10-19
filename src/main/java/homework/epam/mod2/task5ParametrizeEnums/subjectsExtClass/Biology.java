package homework.epam.mod2.task5ParametrizeEnums.subjectsExtClass;

import homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass.StudentSubscriber;
import homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass.SubjectPublisher;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Biology implements SubjectPublisher {
    private Map<StudentSubscriber, Double> studentsAndMarks = new HashMap<>();

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
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     *
     */
    @Override
    public void notifyStudent() {

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
