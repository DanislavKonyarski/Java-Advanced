package softUni;

public class Student {
//    •	firstName: String
//•	lastName: String
//•	bestCourse: String
    private String firstName;
    private String lastName;
    private String bestCourse;

    public Student(String firstName, String lastcoName, String bastCourse) {
        this.firstName = firstName;
        this.lastName = lastcoName;
        this.bestCourse = bastCourse;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBestCourse() {
        return bestCourse;
    }

    public void setBestCourse(String bestCourse) {
        this.bestCourse = bestCourse;
    }

    @Override
    public String toString() {
        return String.format("Student: %s %s, Best Course = %s",firstName, lastName, bestCourse);
    }
}
