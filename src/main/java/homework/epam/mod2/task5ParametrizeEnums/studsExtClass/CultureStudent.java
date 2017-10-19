package homework.epam.mod2.task5ParametrizeEnums.studsExtClass;

import homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass.StudentSubscriber;
import homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass.SubjectPublisher;
import homework.epam.mod2.task5ParametrizeEnums.subjectsExtClass.Biology;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CultureStudent implements StudentSubscriber {
    private String name;
    private Map<SubjectPublisher, Double> mySubjectMap = new HashMap<>();

    public CultureStudent(String name) {
        this.name = name;
        Biology biology = new Biology();
        mySubjectMap.put(biology, 5.0);
    }

    @Override
    public void subscribeOnSubject(SubjectPublisher subjectPublisher) {
        mySubjectMap.put(subjectPublisher, 5.0);
        subjectPublisher.register(this);
    }

    @Override
    public void unSubscribeFromSubj(SubjectPublisher subjectPublisher) {
        mySubjectMap.remove(subjectPublisher);
        subjectPublisher.unRegister(this);
    }

    public void passThrouthTestAndGetMark(SubjectPublisher subjectPublisher, Double testMark) {
        mySubjectMap.put(subjectPublisher, testMark);
    }

    @Override
    public void getAllSubjectsSubscribesAndMarksOnEach() {
        for (SubjectPublisher entry : mySubjectMap.keySet()) {
            System.out.println("Marks on subject " + entry.toString() + " of studennt  - " + getName() + " is :");
            for (Double marksOnSubj : mySubjectMap.values()) {
                System.out.println("    *) " + marksOnSubj);
            }
            System.out.println("Next one,\n");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CultureStudent)) return false;
        CultureStudent that = (CultureStudent) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getMySubjectMap(), that.getMySubjectMap());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getMySubjectMap());
    }

    public Map<SubjectPublisher, Double> getMySubjectMap() {
        return mySubjectMap;
    }

    @Override
    public void setMark(SubjectPublisher subjectPublisher, Double mark) {
        mySubjectMap.put(subjectPublisher, mark);
    }

    @Override
    public void setMark(SubjectPublisher subjectPublisher, Integer aInteger) {

    }

    public Object getName() {
        return name;
    }
}