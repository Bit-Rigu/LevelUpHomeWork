package bit.rigu.homework.lesson2;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.*;


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
        employees.stream().forEach(System.out::print);
    }

    static void printEmployeeWithDefinedWorkAge(Collection<Employee> employees, int workAge) {
        employees.stream().filter(employee -> employee.getWorkAge() == workAge)
                            .forEach(System.out::print);
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

    public static Set<Employee> union(Set<Employee> set1, Set<Employee> set2) {
        Set<Employee> set = new TreeSet<>(set1);
        set.addAll(set2);
        return set;
    }
    public static Set<Employee> intersect(Set<Employee> set1, Set<Employee> set2) {
        Set<Employee> set = new TreeSet<>();
        for(Employee employee1: set1) {
            for(Employee employee2: set2) {
                if (employee1.equals(employee2)) {
                    set.add(employee1);
                }
            }
        }
        return set;
    }


}
