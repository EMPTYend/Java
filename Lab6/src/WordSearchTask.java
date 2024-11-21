import java.util.regex.*;

public class WordSearchTask implements Runnable {
  private final String[] data;
  private final String word;

  public WordSearchTask(String[] data, String word) {
    this.data = data;
    this.word = word;
  }

  @Override
  public void run() {
    String regex = "\\b" + Pattern.quote(word) + "\\b";

    Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
    boolean found = false;

    for (int i = 0; i < data.length; i++) {
      Matcher matcher = pattern.matcher(data[i]);
      if (matcher.find()) {
        found = true;
        System.out.println("Слово '" + word + "' найдено в строке: " + data[i] + " на позиции " + (i + 1));
        break;
      }
    }

    if (!found) {
      System.out.println("Слово '" + word + "' не найдено в массиве.");
    }
  }
}
