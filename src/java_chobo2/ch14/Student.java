package java_chobo2.ch14;

public class Student implements Comparable<Student> {

	private String name;
	private int ban;
	private int totalScore;

	public Student(String name, int ban, int totalScore) {
		super();
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param ban the ban to set
	 */
	public void setBan(int ban) {
		this.ban = ban;
	}

	/**
	 * @param totalScore the totalScore to set
	 */
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	@Override
	public String toString() {
		return String.format("Student [name=%s, ban=%s, totalScore=%s]", name, ban, totalScore);
	}

	@Override
	public int compareTo(Student o) {

		return this.totalScore - o.totalScore * -1;// 반대로 되는 코드
	}

}
