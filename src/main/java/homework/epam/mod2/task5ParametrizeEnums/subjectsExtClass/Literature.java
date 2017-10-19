package homework.epam.mod2.task5ParametrizeEnums.subjectsExtClass;

import homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass.StudentSubscriber;
import homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass.SubjectPublisher;

import java.util.Map;

public class Literature implements SubjectPublisher {
    private Map<StudentSubscriber, Double> literatureSrudentsMarksMap;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void register(StudentSubscriber student) {
        literatureSrudentsMarksMap.put(student, 5.00);
        notifyStudent(student);
    }

    @Override
    public void unRegister(StudentSubscriber student) {
        literatureSrudentsMarksMap.remove(student);
        notifyStudent(student);

    }

    @Override
    public void setMarkOnStudent(StudentSubscriber student, Double mark) {
        literatureSrudentsMarksMap.put(student,mark);
        notifyStudent(student);

    }

    @Override
    public void notifyStudent(StudentSubscriber studentSubscriber) {
        studentSubscriber.setMark(literatureSrudentsMarksMap.get(studentSubscriber));
    }

    @Override
    public void getSubscribedStudents() {

    }
}
