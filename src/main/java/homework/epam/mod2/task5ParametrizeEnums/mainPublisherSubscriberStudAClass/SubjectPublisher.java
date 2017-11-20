package homework.epam.mod2.task5ParametrizeEnums.mainPublisherSubscriberStudAClass;

/**
 *
 */
public interface SubjectPublisher {
	/**
	 * @param student
	 */
	void register(StudentSubscriber student);
	
	/**
	 * @param student
	 */
	void unRegister(StudentSubscriber student);
	
	/**
	 * @param student
	 * @param mark
	 */
	void setMarkOnStudent(StudentSubscriber student, Double mark);
	
	/**
	 * @param student
	 * @param mark
	 */
	void setMarkOnStudent(StudentSubscriber student, Integer mark);
	
	/**
	 * @param studentSubscriber
	 */
	void notifyStudent(StudentSubscriber studentSubscriber);
	
	/**
	 *
	 */
	void getSubscribedStudents();
	
}
