package homework.epam.mod2.task5ParametrizeEnums.studsExtClass;

import homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass.StudentSubscriber;
import homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass.SubjectPublisher;

import java.util.Map;
import java.util.Objects;

public class PoliTechnicBotan implements StudentSubscriber {
    private final String name;
    private Map<SubjectPublisher, Integer> mySubjMap;

    public PoliTechnicBotan(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PoliTechnicBotan)) return false;
        PoliTechnicBotan that = (PoliTechnicBotan) o;
        return Objects.equals(name, that.name) && Objects.equals(getMySubjMap(), that.getMySubjMap());
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, getMySubjMap());
    }

    public Map<SubjectPublisher, Integer> getMySubjMap() {
        return mySubjMap;
    }

    public void setMySubjMap(Map<SubjectPublisher, Integer> mySubjMap) {
        this.mySubjMap = mySubjMap;
    }

    @Override
    public void subscribeOnSubject(SubjectPublisher subjectPublisher) {
        mySubjMap.put(subjectPublisher, 5);
        subjectPublisher.register(this);
    }

    @Override
    public void unSubscribeFromSubj(SubjectPublisher subjectPublisher) {
        mySubjMap.remove(subjectPublisher);
        subjectPublisher.unRegister(this);
    }

    public void passThrouthTestAndGetMark(SubjectPublisher subjectPublisher, Integer testMark) {
        mySubjMap.put(subjectPublisher, testMark);
    }

    @Override
    public void getAllSubjectsSubscribesAndMarksOnEach() {
        for (Map.Entry<SubjectPublisher, Integer> entry : mySubjMap.entrySet()) {
            System.out.println("Subject " + entry.getKey() + " mark is :" + entry.getValue());
        }
    }

    @Override
    public void setMark(SubjectPublisher subjectPublisher, Double aDouble) {
    }

    @Override
    public void setMark(SubjectPublisher subjectPublisher, Integer mark) {
        mySubjMap.put(subjectPublisher, mark);

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
