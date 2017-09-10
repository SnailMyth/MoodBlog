package cn.myth.MoodBlog.base;

public enum MythError {
	ID_EXSIT("aaa"), ID_NO_EXSIT("aaa"), PASSWORD_ERROR("password error"),;
	private String message;

	MythError(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
