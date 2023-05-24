

package DefiningClassesExercises;

public class Employee {
    private String name;
    private Double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, Double salary, String position, String department){
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = "n/a";
        this.age = -1;
    }
    public Employee(String name, Double salary,String position, String department ,String email){
        this(name,salary,position,department);
        this.email = email;
        this.age = -1;
    }
    public Employee(String name, Double salary, String position, String department,int age){
        this(name,salary,position,department);
        this.age = age;
        this.email = "n/a";
    }
    public Employee(String name,Double salary,String position,String department, String email, int age){
        this(name,salary,position,department);
        this.email = email;
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public Double getSalary(){
        return salary;
    }
    public String getPosition(){
        return position;
    }
    public String getDepartment(){
        return department;
    }
    public String getEmail(){
        return email;
    }
    public int getAge (){
        return age;
    }
    public void setName(String name){
        this.name = name;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }
}








