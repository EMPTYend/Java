import java.util.*;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Введите строку: ");
    String input = scanner.nextLine();

    List<String> numbers = TextProcessor.extractNumbers(input);
    System.out.println("Числа в строке:");
    for (String number : numbers) {
      System.out.println(number);
    }

    List<String> words = TextProcessor.extractWords(input);
    System.out.println("\nКоличество слов: " + words.size());
    System.out.println("Слова в строке:");
    for (String word : words) {
      System.out.println(word);
    }

    Collections.sort(words);
    System.out.println("\nСортированные слова:");
    for (String word : words) {
      System.out.println(word);
    }

    scanner.close();
  }
}
