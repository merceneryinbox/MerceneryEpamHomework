package homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass;

public interface StudentSubscriber {
    void subscribeOnSubject(SubjectPublisher subjectPublisher);

    void unSubscribeFromSubj(SubjectPublisher subjectPublisher);

    void getAllSubjectsSubscribesAndMarksOnEach();

    void setMark(SubjectPublisher subjectPublisher, Double aDouble);

    void setMark(SubjectPublisher subjectPublisher, Integer aInteger);
}
