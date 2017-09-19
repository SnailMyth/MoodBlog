package cn.myth.MoodBlog.base;

public class BaseException extends RuntimeException{

	/**
	 * 
	 */
	public BaseException(String message) {
		super(message);
	}
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
