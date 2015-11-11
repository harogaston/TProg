/*
 * Header Test
 */
package tprog.logica.interfaces;

/**
 *
 * @author marccio
 */
public interface Observer {

	//method to update the observer, used by subject
	public void update(String message);

	//attach with subject to observe
//	public void setSubject(Subject sub);
}
