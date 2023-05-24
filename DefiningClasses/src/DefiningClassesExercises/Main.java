package DefiningClassesExercises;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countEmployee = Integer.parseInt(scanner.nextLine());
        List<Employee> employeeList = new ArrayList<>();

        for (int i = 0; i < countEmployee; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            Double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            if (input.length==4){
                Employee employee = new Employee(name,salary,position,department);
                employeeList.add(employee);
            } else if (input.length==5) {
                if (input[4].contains("@")){
                    String email = input[4];
                    Employee employee = new Employee(name,salary,position,department,email);
                    employeeList.add(employee);
                }else {
                    int age = Integer.parseInt(input[4]);
                    Employee employee = new Employee(name,salary,position,department,age);
                    employeeList.add(employee);
                }
            }else {
                String email = input[4];
                int age = Integer.parseInt(input[5]);
                Employee employee = new Employee(name,salary,position,department,email,age);
                employeeList.add(employee);
            }
        }
        List<Department> departmentList = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            double currentSalary = employeeList.get(i).getSalary();
            String currentKey = employeeList.get(i).getDepartment();
            boolean isContains = false;
            for (int j = 0; j < departmentList.size(); j++) {
                if (departmentList.get(j).getDepartment().equals(currentKey)){
                    departmentList.get(j).setSalary(currentSalary);
                    isContains = true;
                }
            }
            if (!isContains){
                Department department = new Department(currentKey,currentSalary);
                departmentList.add(department);
            }
        }
        Optional<Department> maxDepartment = departmentList.stream().
                max((firstE, secondE) -> Double.compare(firstE.getAverageSalary(), secondE.getAverageSalary()));
        System.out.printf("Highest Average Salary: %s%n",maxDepartment.get().getDepartment());
        employeeList.stream().filter(e -> e.getDepartment().equals(maxDepartment.get().getDepartment()))
                .sorted((first,second)-> second.getSalary().compareTo(first.getSalary()))
                .forEach(e-> System.out.printf("%s %.2f %s %d%n",e.getName(),e.getSalary(),e.getEmail(),e.getAge()));
    }
}
