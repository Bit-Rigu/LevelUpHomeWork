package bit.rigu.homework.lesson2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

@Data
@AllArgsConstructor
public class Employee {

    private String firstName;
    private String surName;
    private String patronymic;
    private int workAge;

    static void printEmployee(Collection<Employee> employees, int workAge) {
        employees.stream().filter(employee -> employee.getWorkAge() > workAge)
                            .forEach(System.out::println);
    }
}
