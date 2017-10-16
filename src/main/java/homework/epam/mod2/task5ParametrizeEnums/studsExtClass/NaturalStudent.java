package homework.epam.mod2.task5ParametrizeEnums.studsExtClass;

import homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass.MerceneryStudentSubscriber;
import homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass.MercenerySubjectPublisher;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NaturalStudent implements MerceneryStudentSubscriber {
    private String name;

    private ArrayList<MercenerySubjectPublisher> mySubject;

    public NaturalStudent() {

    }

    public NaturalStudent(String name, ArrayList<MercenerySubjectPublisher> mySubject) {
        this();
        this.name = name;
        this.mySubject = mySubject;
    }

    private ArrayList<MercenerySubjectPublisher> getMySubject() {
        return mySubject;
    }

    public void setMySubject(ArrayList<MercenerySubjectPublisher> mySubject) {
        this.mySubject = mySubject;
    }


    @Override
    public void subscribeOnObject() {

    }

    @Override
    public void unsubscribeFromObj() {

    }

    @Override
    public List<MercenerySubjectPublisher> getAllSubscribes() {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NaturalStudent)) return false;
        NaturalStudent that = (NaturalStudent) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getMySubject(), that.getMySubject());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getMySubject());
    }
}
