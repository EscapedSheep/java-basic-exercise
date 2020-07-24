import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GrammarExercise {
    public static void main(String[] args) {
        //需要从命令行读入
        String firstWordList = "";
        String secondWordList = "";

        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        //按要求输出到命令行

    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        firstWordList = firstWordList.toUpperCase();
        secondWordList = secondWordList.toUpperCase();
        List<String> firstList = Arrays.asList(firstWordList.split(","));
        List<String> secondList = Arrays.asList(secondWordList.split(","));
        Predicate<String> isWord = s -> s.matches("^[a-zA-Z]+$");
        if (!firstList.stream().allMatch(isWord) || !secondList.stream().allMatch(isWord)) {
            throw new RuntimeException();
        };
        return firstList
                .stream()
                .distinct()
                .filter(s -> secondList.contains(s))
                .map(s -> String.join(" ",s.split("")))
                .sorted()
                .collect(Collectors.toList());
    }
}
