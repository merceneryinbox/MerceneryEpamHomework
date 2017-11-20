package homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass;

/**
 *
 */
public interface StudentSubscriber {
	/**
	 * @param subjectPublisher
	 */
	void subscribeOnSubject(SubjectPublisher subjectPublisher);
	
	/**
	 * @param subjectPublisher
	 */
	void unSubscribeFromSubj(SubjectPublisher subjectPublisher);
	
	/**
	 *
	 */
	void getAllSubjectsSubscribesAndMarksOnEach();
	
	/**
	 * @param subjectPublisher
	 * @param aDouble
	 */
	void setMark(SubjectPublisher subjectPublisher, Double aDouble);
	
	/**
	 * @param subjectPublisher
	 * @param aInteger
	 */
	void setMark(SubjectPublisher subjectPublisher, Integer aInteger);
}
