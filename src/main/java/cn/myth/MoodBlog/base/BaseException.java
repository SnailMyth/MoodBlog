package cn.myth.MoodBlog.base;

public class BaseException extends RuntimeException{

	/**
	 * 
	 */
	public BaseException(String message) {
		super(message);
	}
	private static final long serialVersionUID = 1L;
	
	public MythError error;

	public MythError getError() {
		return error;
	}

	public Exception setError(MythError error) {
		this.error = error;
		return this;
	}
	
}
