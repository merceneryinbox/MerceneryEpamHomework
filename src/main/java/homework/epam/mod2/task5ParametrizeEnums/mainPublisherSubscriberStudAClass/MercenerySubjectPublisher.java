package homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass;

import java.util.ArrayList;
import java.util.List;

public interface MercenerySubjectPublisher {
    ArrayList<MerceneryStudentSubscriber> listOfSubscribedStudents = null;

    void register();

    void unRegister();

    void setMarkOnStudent();

    void notifyObservers();
    List<MercenerySubjectPublisher> getSubscribedStudents();

}
