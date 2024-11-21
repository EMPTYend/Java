import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    int availableProcessors = Runtime.getRuntime().availableProcessors();
    System.out.println("Количество доступных процессоров: " + availableProcessors);

    Scanner scanner = new Scanner(System.in);
    String[] dataArray = new String[0];

    try {
      System.out.print("Введите количество элементов в массиве: ");
      int size = scanner.nextInt();
      scanner.nextLine();
      dataArray = new String[size];

      System.out.println("Введите " + size + " строк для массива:");
      for (int i = 0; i < size; i++) {
        dataArray[i] = scanner.nextLine();
      }
    } catch (Exception e) {
      System.out.println("Неверный ввод, пожалуйста, введите корректные данные.");
      return;
    }

    Thread searchJava = new Thread(new WordSearchTask(dataArray, "Java"));
    Thread searchJavaEE = new Thread(new WordSearchTask(dataArray, "JavaEE"));

    searchJava.start();
    searchJavaEE.start();

    try {
      searchJava.join();
      searchJavaEE.join();
    } catch (InterruptedException e) {
      System.out.println("Ошибка при ожидании завершения потоков.");
    }

    scanner.close();
  }
}
