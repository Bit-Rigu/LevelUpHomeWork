package bit.rigu.homework.lesson4;

import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;


public class StreamRunner {
    public static void main(String[] args) {
        Random random = new Random();
        IntSummaryStatistics statistics = random.ints()
                .limit(1000)
                .sorted()
                .summaryStatistics();
        System.out.println("Maximum " + statistics.getMax() +
                            "\nMinimum "+ statistics.getMin()+
                            "\nAverage " + statistics.getAverage()
        );
        long sumOfOdd;
        sumOfOdd = random.ints()
                .limit(1000)
                .filter(e -> e % 2 == 1)
                .sum();
        System.out.printf("Сумма нечетных элементов потока %d\n", sumOfOdd);

        Map<Integer, Integer> map = random.ints()
                .limit(1000)
                .boxed()
                .collect(Collectors.toMap( Function.identity(),
                        (Integer number) ->
                        {
                            int sum = 0;
                            int num = Math.abs(number);
                            for (; num > 0; num /= 10)
                                sum += num % 10;
                                return sum;},
                        (previous, next) -> previous));
        System.out.println("Карта, в которой ключ - случайное число, а значение ключа" +
                "есть сумма его цифр:\n" + map);
    }
}
