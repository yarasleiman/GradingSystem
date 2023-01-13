
public class Grade {
    String subject;
    String grade;
    int studNumber;

    public Grade(String sub, String grade, int studNum) {
        this.subject = sub;
        this.grade = grade;
        this.studNumber = studNum;
    }

    public void setSubject(String sub) {
        this.subject = sub;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setStudNumber(int studNum) {
        this.studNumber = studNum;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getGrade() {
        return this.grade;
    }

    public int getstudNumber() {
        return this.studNumber;
    }
}
