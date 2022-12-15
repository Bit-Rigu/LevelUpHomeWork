package bit.rigu.homework.lesson2;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;


@AllArgsConstructor
@Getter
public class Employee {

    private String firstName;
    private String surName;
    private String patronymic;
    private int workAge;


    @Override
    public String toString() {
        return getSurName() + " " + getFirstName() + " " + getPatronymic() + " " +getWorkAge() + "\n";
    }

    static void printEmployee(Collection<Employee> employees, int workAge) {
        employees.stream().filter(employee -> employee.getWorkAge() == workAge)
                            .forEach(System.out::println);
    }
}
