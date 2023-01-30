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
        //Add data to tables
        List<University> listOfUniversities = (List.of(
            new University(1, "University of Cambridge",
                       "England", 1209),
            new University(2, "École normale supérieure",
                       "France", 1794),
            new University(3, "Lund University",
                        "Sweden", 1666),
            new University(4, "Moscow State University",
                     "Russia", 1755),
            new University(5, "Harvard University",
                     "USA", 1636),
            new University(6, "Université libre de Bruxelles",
                     "Belgium", 1834),
            new University(7, "University of California," +
                    " Berkeley", "USA", 1868),
            new University(8, "University of Münster",
                    "Germany", 1780),
            new University(9, "Kyoto University",
                    "Japan", 1897),
            new University(10, "Saint Petersburg State University",
                    "Russia", 1724),
            new University(11, "Princeton University",
                    "USA", 1746),
            new University(12, "Hebrew University of Jerusalem",
                    "Israel", 1918),
            new University(13, "University of Bonn",
                    "Germany", 1777),
            new University(14, "Seoul National University",
                    "South Korea", 1946),
            new University(15, "University of Geneva",
                    "Switzerland", 1559)));

        universityDao.create(listOfUniversities.get(0));
        universityDao.create(listOfUniversities.get(1));
        universityDao.create(listOfUniversities.get(2));
        universityDao.create(listOfUniversities.get(3));
        universityDao.create(listOfUniversities.get(4));
        universityDao.create(listOfUniversities.get(5));
        universityDao.create(listOfUniversities.get(6));
        universityDao.create(listOfUniversities.get(7));
        universityDao.create(listOfUniversities.get(8));
        universityDao.create(listOfUniversities.get(9));
        universityDao.create(listOfUniversities.get(10));
        universityDao.create(listOfUniversities.get(11));
        universityDao.create(listOfUniversities.get(12));
        universityDao.create(listOfUniversities.get(13));
        universityDao.create(listOfUniversities.get(14));

        mathDao.create(new Mathematician(1, "Lars Ahlfors",
                1936, "finn",
                "complex analysis, mathematical analysis, conformal geometry",
                null));
        mathDao.create(new Mathematician(2,
                "Atle Selberg", 1950, "norwegian",
                "number theory, complex analysis" +
                "Group of Lie type ", null ));
        mathDao.create(new Mathematician(3, "René Frédéric Thom",
                1958, "frenchman",
                "singularity theory, catastrophe theory",
                listOfUniversities.get(1)));
        mathDao.create(new Mathematician(4, "Lars Valter Hörmander", 1962,
                "swede", "partial differential equation, harmonic analysis",
                listOfUniversities.get(2)));
        mathDao.create(new Mathematician(5, "John Milnor", 1962,
                "american", "differential topology, Milnor K-theory",
                listOfUniversities.get(10)));
        mathDao.create(new Mathematician(6, "Michael Francis Atiyah", 1966,
                "britisher", "K-theory, algebraic geometry",
                null));
        mathDao.create(new Mathematician(7, "Alexander Grothendieck", 1966,
                "frenchman", "algebraic geometry, K-theory, category theory",
                null));
        mathDao.create(new Mathematician(8, "Stephen Smale", 1966,
                "american", "differential topology, dynamical system",
                null));
        mathDao.create(new Mathematician(9, "Sergei Petrovich Novikov", 1970,
                "russian", "algebraic topology, soliton theory",
                listOfUniversities.get(3)));
        mathDao.create(new Mathematician(10, "David Bryant Mumford", 1974,
                "american", "algebraic geometry, algebraic surface",
                listOfUniversities.get(4)));
        mathDao.create(new Mathematician(11, "Pierre René, Viscount Deligne", 1978,
                "belgian", "algebraic geometry, algebraic number theory",
                listOfUniversities.get(5)));
        mathDao.create(new Mathematician(12, "Grigory Aleksandrovich Margulis", 1978,
                "russian", "combinatorics, differential geometry, ergodic theory",
                listOfUniversities.get(3)));
        mathDao.create(new Mathematician(13, "Alain Connes", 1982, "american",
                "operator algebra, noncommutative geometry",
                listOfUniversities.get(1)));
        mathDao.create(new Mathematician(14, "William Paul Thurston", 1982, "american",
                "foliation theory, compact-open topology", null));
        mathDao.create(new Mathematician(15, "Shing-Tung Yau", 1982,
                "сhinese", "differential equations, algebraic geometry, geometric analysis",
                null));
        mathDao.create(new Mathematician(16, "Simon Kirwan Donaldson", 1986,
                "britisher", "Donaldson–Thomas theory, differential geometry",
                listOfUniversities.get(0)));
        mathDao.create(new Mathematician(17, "Gerd Faltings", 1986, "german",
                "arithmetic geometry", listOfUniversities.get(7)));
        mathDao.create(new Mathematician(18, "Vladimir Gershonovich Drinfeld",
                1990, "ukrainian", "geometric Langlands correspondence, mathematical physics",
                listOfUniversities.get(3)));
        mathDao.create(new Mathematician(19, "Vaughan Frederick Randal Jones",
                1990, "new zealander", "von Neumann algebras, geometric topology," +
                "quantum topology", listOfUniversities.get(14)));
        mathDao.create(new Mathematician(20, "Edward Witten", 1990, "american",
                "string theory, quantum gravity, supersymmetric theory",
                listOfUniversities.get(10)));

        //Demonstrating of working all methods
        System.out.println(universityDao.getById(10));
        System.out.println(universityDao.getById(12));
        System.out.println("********************************************");
        for(int i = 2; i <= 15; i +=3) {
            universityDao.deleteById(i);
        }

        universityDao.update(new University(1,
                "New University", "New country",3000));

        System.out.println(universityDao.findAll());
        System.out.println("********************************************");

        System.out.println(mathDao.getById(11));
        System.out.println(mathDao.getById(19));

        for(int i = 1; i <= 20; i+=2) {
            mathDao.deleteById(i);
        }

        mathDao.update(new Mathematician(2, "New mathematician",
                2024,"new nationality", "New area of researching",
                null));
        System.out.println("********************************************");
        System.out.println(mathDao.findAll());
    }
}
