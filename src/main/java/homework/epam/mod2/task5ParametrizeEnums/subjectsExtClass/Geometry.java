package homework.epam.mod2.task5ParametrizeEnums.subjectsExtClass;

import homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass.MerceneryStudentSubscriber;
import homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass.MercenerySubjectPublisher;

import java.util.List;

public class Geometry implements MerceneryStudentSubscriber {
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
}
