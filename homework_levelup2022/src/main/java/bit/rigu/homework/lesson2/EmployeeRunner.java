package bit.rigu.homework.lesson2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmployeeRunner {

                // Предварительные данные для случайной генерации имен работников
                // для мужских и женских работников созданы отдельные массивы для согласования окончаний

    static String[] firstNameMale= new String[] {"Сергей", "Кирилл", "Василий", "Дмитрий", "Борис",
                                                "Себастьян", "Адам", "Михаил", "Григорий", "Жерар",
                                                "Клайд", "Энколпий", "Ганс", "Петр", "Персей"};
    static String[] firstNameFemale= new String[] {"Анна", "Елизавета", "Жозефина", "Екатерина", "Александра",
                                                "Юдифь", "Ксения", "Ада", "Алена", "Мишель",
                                                "Зигги", "Джульета", "Беатриче", "Фекла", "Светлана"};
    static String[] surNameMale= new String[] {"Пушкин", "Достоевский", "Грин", "Чайковский", "Грибоедов",
                                                "Миллер", "Поддубный", "Лермонтов", "Бродский", "Гейм",
                                                "Блок", "Брюсов", "Стругацкий", "Ноздрев", "Греческий"};
    static String[] surNameFemale= new String[] {"Гончарова", "Собчак", "Борисова", "Шульман", "Бит-Ригу",
                                                "Красноглазова", "Пугачева", "Фоменко", "Бутусова", "Рукавицина",
                                                "Кирпичева", "Тэтчер", "Портман", "Грей", "Громова"};
    static String[] patronymicMale= new String[] {"Андреевич", "Михайлович", "Лазаревич", "Дмитриевич", "Егорович",
                                                "Петрович", "Адамович", "Кириллович", "Николаевич", "Джонович",
                                                "Федерович", "Цикаевич", "Гансович", "Викторович", "Иванович"};
    static String[] patronymicFemale= new String[] {"Крестьяновичнова", "Стрелковична", "Луковична", "Дмитриевна", "Хазаровна",
                                                "Петровична", "Иосифна", "Михайловна", "Григорьевна", "Сиддовна",
                                                "Джиммовна", "Лотаровна", "Рисковна", "Фомична", "Ивановна"};

        // Метод случайным образом определяет пол генерируемого работника

    static Employee generateEmployee() {
        Random random = new Random();
        if(random.nextDouble() > 0.5)
            return new Employee(firstNameMale[random.nextInt(firstNameMale.length - 1)],
                    surNameMale[random.nextInt(surNameMale.length - 1)],
                    patronymicMale[random.nextInt(patronymicMale.length - 1)],
                    random.nextInt(30));
        else return  new Employee(firstNameFemale[random.nextInt(firstNameFemale.length - 1)],
                    surNameFemale[random.nextInt(surNameFemale.length - 1)],
                    patronymicFemale[random.nextInt(patronymicFemale.length - 1)],
                    random.nextInt(30));

    }

    public static void main(String[] args) {

        Random random = new Random();
        List<Employee> list = new ArrayList<>();
        // Генерация списка работников
        for(int i = 0; i < 100 + random.nextInt(1000); i++) {
            list.add(generateEmployee());
        }

        // Вывод списка всех работников
        System.out.println(list);

        int requireAgeWork = random.nextInt(30);
        System.out.println("-------------------");
        System.out.println("Список работников с рабочим стажем равным " + requireAgeWork + " годам\n");
        Employee.printEmployee(list, requireAgeWork);
    }
}
