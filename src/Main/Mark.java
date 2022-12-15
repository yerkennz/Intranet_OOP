package Main;
import java.util.Objects;

public class Mark {
	
	private Course courseName;
	private double att1;
	private double att2;
	private double finalPoint;
	private double totalPoints;
	private double GPAforCourse;
	private double score;
	
	
	
	public Mark(Course courseName, double score, double totalPoints) {
		this.courseName = courseName;
		this.score = score;
		this.totalPoints = totalPoints;
	}
	
	public Mark(double score, String str) {
		this.score = score;
		if (str.equals("att1"))
			this.setAtt1(score);
		else if (str.equals("att2"))
			this.setAtt2(score);
		else
			this.setFinalPoint(score);
			
	}
//--------------------------------------------------------
	public Course getCourseName() {
		return courseName;
	}

	public void setCourseName(Course courseName) {
		this.courseName = courseName;
	}

	public double getAtt1() {
		return att1;
	}

	public void setAtt1(double att1) {
		this.att1 = att1;
		totalPoints += att1;
	}

	public double getAtt2() {
		return att2;
	}

	public void setAtt2(double att2) {
		this.att2 = att2;
		totalPoints += att2;
	}

	public double getFinalPoint() {
		return finalPoint;
	}

	public void setFinalPoint(double finalPoint) {
		this.finalPoint = finalPoint;
		totalPoints += finalPoint;
	}

	public double getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(double totalPoints) {
		this.totalPoints = totalPoints;
	}

	public double getGPAforCourse() {
		return GPAforCourse;
	}

	public void setGPAforCourse(double gPAforCourse) {
		GPAforCourse = gPAforCourse;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	//-----------------------------------------------
	
	public void updateMark(double score) {
		this.score += score;
	}

	@Override
	public int hashCode() {
		return Objects.hash(totalPoints);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mark other = (Mark) obj;
		return Double.doubleToLongBits(totalPoints) == Double.doubleToLongBits(other.totalPoints);
	}
	
}
