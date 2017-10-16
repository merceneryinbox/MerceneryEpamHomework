package homework.epam.mod2.task5ParametrizeEnums.studsExtClass;

import homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass.MerceneryStudentSubscriber;
import homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass.MercenerySubjectPublisher;

import java.util.List;

public class TechnicStudent implements MerceneryStudentSubscriber {

    @Override
    public void subscribeOnObject() {

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
    public void unsubscribeFromObj() {

    }

    @Override
    public List<MercenerySubjectPublisher> getAllSubscribes() {
        return null;
    }
}
