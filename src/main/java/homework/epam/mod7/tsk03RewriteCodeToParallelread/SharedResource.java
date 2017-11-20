package homework.epam.mod7.tsk03RewriteCodeToParallelread;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class SharedResource {
	private List<Integer> list;
	
	/**
	 *
	 */
	public SharedResource() {
		list = new ArrayList<Integer>();
	}
	
	/**
	 *
	 * @param element
	 */
	public void setElement(Integer element) {
		list.add(element);
	}
	
	/**
	 *
	 * @return
	 */
	public Integer getELement() {
		if (list.size() > 0) {
			return list.remove(0);
		}
		return null;
	}
}
