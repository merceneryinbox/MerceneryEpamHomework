package homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass;

import java.util.ArrayList;

public interface SubjectPublisher {

    void register(StudentSubscriber student);

    void unRegister(StudentSubscriber student);

    void setMarkOnStudent(StudentSubscriber student, Double mark);

    void setMarkOnStudent(StudentSubscriber student, Integer mark);

    void notifyStudent(StudentSubscriber studentSubscriber);

    void getSubscribedStudents();

}
