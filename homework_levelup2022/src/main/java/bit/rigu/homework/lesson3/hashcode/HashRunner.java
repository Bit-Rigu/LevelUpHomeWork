package bit.rigu.homework.lesson3.hashcode;

import java.util.*;

public class HashRunner {


    public static String generatingRandomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 2;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

    }

    public static String testHashMap(Map<Integer, ? extends Entity> map, Entity entity) {
        long startTime = System.currentTimeMillis();
        boolean isEntityInMap = map.containsValue(entity);
        long timeFinding = System.currentTimeMillis() - startTime;
        return "Был ли найден элемент " +  String.valueOf(isEntityInMap) +
                "+ \nВремя, затраченное на поиск, " + String.valueOf(timeFinding) + " мс";
    }

    static final Integer rangeOfRandomIntegerGeneration = 200;
    static final Integer numberOfElementsOfMap = 10_000_000;

    public static void main(String[] args) {

        Random random = new Random();
        Map<Integer ,EntityWithChangeHash> changeHash = new HashMap<>();
        Map<Integer, EntityWithConstantHash> constantHash = new HashMap<>();


        for(int i = 0; i <= numberOfElementsOfMap; i++) {
            changeHash.put(
                    i, new EntityWithChangeHash(
                    generatingRandomString(),
                    random.nextInt(rangeOfRandomIntegerGeneration),
                    random.nextInt(rangeOfRandomIntegerGeneration)
            ));
            constantHash.put(
                    i, new EntityWithConstantHash(
                    generatingRandomString(),
                    random.nextInt(rangeOfRandomIntegerGeneration),
                    random.nextInt(rangeOfRandomIntegerGeneration)
            ));
        }
        System.out.println("Тестирование HashMap с изменяющемся hash");
        System.out.println(
                testHashMap(changeHash,
                        new EntityWithChangeHash(
                                generatingRandomString(),
                                random.nextInt(rangeOfRandomIntegerGeneration),
                                random.nextInt(rangeOfRandomIntegerGeneration)
                        ))
        );
        System.out.println("Тестирование HashMap с постоянным hash");
        System.out.println(
                testHashMap(constantHash,
                        new EntityWithConstantHash(
                                generatingRandomString(),
                                random.nextInt(rangeOfRandomIntegerGeneration),
                                random.nextInt(rangeOfRandomIntegerGeneration)
                        ))
        );

    }
}
