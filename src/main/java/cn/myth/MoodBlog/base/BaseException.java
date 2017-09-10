package cn.myth.MoodBlog.base;

public class BaseException {

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	public MythError error;

	public MythError getError() {
		return error;
	}

	public void setError(MythError error) {
		this.error = error;
	}
}
