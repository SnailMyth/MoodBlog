package cn.myth.MoodBlog.base;

public enum Measurement {
	One(1), Ten(2), Hundred(3), Thousand(4), Million(5);

	private int number;

	private Measurement(int i) {
		this.number = i;
	}

	public int getNumber() {
		return number;
	}	
	
}
