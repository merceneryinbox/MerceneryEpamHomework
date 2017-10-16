package homework.epam.mod2.task5ParametrizeEnums.subjectsExtClass;

import homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass.MerceneryStudentSubscriber;
import homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass.MercenerySubjectPublisher;

import java.util.List;

public class Geometry implements MercenerySubjectPublisher {


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
    public void register() {

    }

    @Override
    public void unRegister() {

    }

    @Override
    public void setMarkOnStudent() {

    }

    @Override
    public void notifyObservers() {

    }

    @Override
    public List<MercenerySubjectPublisher> getSubscribedStudents() {
        return null;
    }
}
