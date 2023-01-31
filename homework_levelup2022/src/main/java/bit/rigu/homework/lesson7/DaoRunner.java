package bit.rigu.homework.lesson7;

import bit.rigu.homework.lesson7.dao.MathematicianDao;
import bit.rigu.homework.lesson7.dao.UniversityDao;
import bit.rigu.homework.lesson7.model.Mathematician;
import bit.rigu.homework.lesson7.model.University;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DaoRunner {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DaoRunner.class, args);
        UniversityDao universityDao = context.getBean(UniversityDao.class);
        MathematicianDao mathDao = context.getBean(MathematicianDao.class);

//        //Demonstrating of working all methods
        System.out.println(universityDao.getById(10));
        System.out.println(universityDao.getById(12));
        System.out.println("********************************************");

        universityDao.deleteById(20);

        universityDao.update(new University(1,
                "New University", "New country",3000));

        System.out.println(universityDao.findAll());
        System.out.println("********************************************");

        System.out.println(mathDao.getById(11));
        System.out.println(mathDao.getById(19));

        for(int i = 1; i <= 30; i+=2) {
            mathDao.deleteById(i);
        }

        mathDao.update(new Mathematician(2, "New mathematician",
                2024,"new nationality", "New area of researching",
                null));
        System.out.println("********************************************");
        System.out.println(mathDao.findAll());
    }
}
