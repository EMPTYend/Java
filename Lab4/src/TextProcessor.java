import java.util.*;
import java.util.regex.*;

public class TextProcessor {

  public static List<String> extractNumbers(String input) {
    List<String> numbers = new ArrayList<>();
    Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    Matcher matcher = pattern.matcher(input);

    while (matcher.find()) {
      numbers.add(matcher.group());
    }
    return numbers;
  }

  public static List<String> extractWords(String input) {
    List<String> words = new ArrayList<>();
    Pattern pattern = Pattern.compile("[a-zA-Zа-яА-ЯёЁ]+(?:-[a-zA-Zа-яА-ЯёЁ]+)*");
    Matcher matcher = pattern.matcher(input);

    while (matcher.find()) {
      words.add(matcher.group());
    }
    return words;
  }
}
