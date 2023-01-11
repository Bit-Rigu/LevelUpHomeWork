package bit.rigu.homework.lesson3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApplicationProcessingText {
    public static void main(String[] args) throws IOException {
        Stream<String> lines = Files.lines(Path.of("src/main/java/bit/rigu/homework/lesson3/Семь.txt"));
        Map<String, Integer> map = lines.flatMap(line -> Stream.of(line.split("[—–,.?!-«»]|\s")))
                .map(str -> str.toLowerCase(Locale.ROOT))
                .filter(str -> !(str.matches("[—–,.?!-«»]")||str.equals("")))
                .collect(Collectors.toMap(
                        Function.identity(),
                        (str) -> 1,
                        Integer::sum
                ));
         map.entrySet().stream().
                 sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                 .forEach(x -> System.out.println(x.getKey()));
/*        System.out.println("--------------");
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " = " + value + "\n");
        }*/
    }
}
