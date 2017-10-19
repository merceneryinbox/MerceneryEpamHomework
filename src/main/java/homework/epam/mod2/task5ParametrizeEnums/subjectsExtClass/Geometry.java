package homework.epam.mod2.task5ParametrizeEnums.subjectsExtClass;

import homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass.StudentSubscriber;
import homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass.SubjectPublisher;

import java.util.Map;

public class Geometry implements SubjectPublisher {
    Map<StudentSubscriber, Integer> studsMarksBase;
    private Integer mark;

    public void getStudsAllGeometryMarks(StudentSubscriber studentSubscriber) {
        for (Map.Entry en : studsMarksBase.entrySet()) {
            System.out.println("Student " + en.getKey() + " had mark = " + en.getValue());
        }
    }

    public void setMark(StudentSubscriber studentSubscriber, int mark) {
        studsMarksBase.put(studentSubscriber, mark);
        notifyStudent(studentSubscriber);
    }

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

    }

    @Override
    public void unRegister(StudentSubscriber student) {

    }

    @Override
    public void setMarkOnStudent(StudentSubscriber student, Double mark) {

    }

    @Override
    public void notifyStudent(StudentSubscriber studentSubscriber) {
        studentSubscriber.unSubscribeFromSubj(this);
    }

    @Override
    public void getSubscribedStudents() {
        System.out.println("Students subscribed for geometry : ");
        System.out.println();
        for (Map.Entry entry : studsMarksBase.entrySet()) {
            System.out.println("Srudent = " + entry.getKey());
        }
    }
}