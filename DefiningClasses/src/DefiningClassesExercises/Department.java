package DefiningClassesExercises;

public class Department {
    private String department;
    private double salary;
    private int count;

    public Department(String department, double salary){
        this.department = department;
        this.salary = salary;
        this.count = 1;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary += salary;
        count++;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
    public double getAverageSalary(){
        return salary/count;
    }
}
