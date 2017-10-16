package homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass;

import java.util.ArrayList;
import java.util.List;

public interface MerceneryStudentSubscriber {
    ArrayList<MercenerySubjectPublisher> subjectsList = null;

    String name = "Plain student";
    int age = 0;

    void subscribeOnObject();

    void unsubscribeFromObj();

    List<MercenerySubjectPublisher> getAllSubscribes();
}
