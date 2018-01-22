package database;

/**
 * <p>
 * The Session implemented as a Singleton.
 * </p>
 * .
 * 
 * @author memue
 */
public final class Session {

	private static Object clipboard;

	private static Session session;

	private Session() {
		// Hier gibt es nichts zu sehen
	}

	/**
	 * If no session exists, a session will be created.
	 * 
	 * @return the instance of the session.
	 */
	public static Session getInstance() {
		if (session == null) {
			session = new Session();
		}
		return session;
	}

	/**
	 * Most likely will contain the Object that has to be edited.
	 * 
	 * @return the stored Object inside the Session.
	 */
	public Object getClipboard() {
		return clipboard;
	}

	/**
	 * Clears the clipboard. Used after editing a Object.
	 */
	public void removeClipboard() {
		clipboard = null;
	}

	/**
	 * 
	 * @param newClipboard
	 *            Object that shall be edited.
	 */
	public void setClipboard(Object newClipboard) {
		clipboard = newClipboard;
	}

}
