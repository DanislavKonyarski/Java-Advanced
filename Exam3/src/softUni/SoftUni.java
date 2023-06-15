package softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return data.size();
    }

    public String insert(Student student) {
        if (data.contains(student)) {
            return "Student is already in the hall.";
        }
        if (data.size() < capacity) {
            data.add(student);
            return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
        } else {
            return "The hall is full.";
        }
    }

    public String remove(Student student) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).equals(student)) {
                Student currentStudent = data.get(i);
                data.remove(i);
                return String.format("Removed student %s %s.", currentStudent.getFirstName(), currentStudent.getLastName());
            }
        }
        return "Student not found";
    }

    public Student getStudent(String firstName, String lastName) {
        return data.stream().filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                .findFirst().orElse(null);
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Hall size: %d%n", data.size()));
        data.forEach(e -> stringBuilder.append(String.format("%s%n", e)));

        return String.valueOf(stringBuilder);
    }
}
