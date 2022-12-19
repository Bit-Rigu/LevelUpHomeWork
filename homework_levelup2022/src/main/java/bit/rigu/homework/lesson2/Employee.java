package bit.rigu.homework.lesson2;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;


@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Employee implements Comparable<Employee> {

    private String firstName;
    private String surName;
    private String patronymic;
    private int workAge;


    @Override
    public String toString() {
        return getSurName() + " " + getFirstName() + " " + getPatronymic() + " " +getWorkAge() + "\n";
    }

    static void printEmployee(Collection<Employee> employees) {
        employees.stream().forEach(System.out::println);
    }

    static void printEmployeeWithDefinedWorkAge(Collection<Employee> employees, int workAge) {
        employees.stream().filter(employee -> employee.getWorkAge() == workAge)
                            .forEach(System.out::println);
    }

    static List<Employee> deleteEmployeesOnTheOddNumber(List<Employee> list) {
        int count = 0;
        for(ListIterator<Employee> iterator = list.listIterator(list.size()); iterator.hasPrevious(); ) {
            iterator.previous();
            count++;
            if (count % 2 == 1) iterator.remove();
        }
        return list;
    }
    // Убывающий порядок
    @Override
    public int compareTo(Employee o) {
        return (0 == Integer.compare(o.workAge, this.workAge)) ?
                (this.firstName + this.surName + this.patronymic).compareTo(
                        o.firstName + o.surName + o.patronymic
                ) : Integer.compare(o.workAge, this.workAge);
    }
}
