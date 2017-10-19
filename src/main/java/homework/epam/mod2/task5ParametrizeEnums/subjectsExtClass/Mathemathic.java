package homework.epam.mod2.task5ParametrizeEnums.subjectsExtClass;

import homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass.StudentSubscriber;
import homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass.SubjectPublisher;

import java.util.Map;
import java.util.Objects;

public class Mathemathic implements SubjectPublisher {

    private final String name = "Methemathic";
    private Map<StudentSubscriber, Integer> studentsAndMarksMap;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mathemathic)) return false;
        Mathemathic that = (Mathemathic) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void register(StudentSubscriber student) {
        studentsAndMarksMap.put(student, 5);
        notifyStudent(student);
    }

    @Override
    public void unRegister(StudentSubscriber student) {
        studentsAndMarksMap.remove(student);
        student.unSubscribeFromSubj(this);
    }

    @Override
    public void setMarkOnStudent(StudentSubscriber student, Double mark) {
    }

    @Override
    public void setMarkOnStudent(StudentSubscriber student, Integer mark) {
        studentsAndMarksMap.put(student, mark);
        notifyStudent(student);
    }

    @Override
    public void notifyStudent(StudentSubscriber studentSubscriber) {
        studentSubscriber.setMark(this, studentsAndMarksMap.get(studentSubscriber));
    }

    @Override
    public void getSubscribedStudents() {
        for (Map.Entry entry : studentsAndMarksMap.entrySet()) {
            System.out.println("Student = " + entry.getKey() + " with mark " + entry.getValue());
        }
    }
}
