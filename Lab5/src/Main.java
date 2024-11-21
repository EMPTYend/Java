import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Введите количество элементов в списке: ");
    int size = scanner.nextInt();

    SimpleList<Integer> list = new SimpleList<>();

    for (int i = 0; i < size; i++) {
      System.out.print("Введите элемент " + (i + 1) + ": ");
      int element = scanner.nextInt();
      list.add(element);
    }

    System.out.println("\nСписок после добавления элементов:");
    list.printList();

    System.out.print("\nВведите индекс элемента для получения (1 - " + list.size() + "): ");
    int index = scanner.nextInt() - 1;  // Индексы для пользователя начинаются с 1, а в массиве с 0
    if (index >= 0 && index < list.size()) {
      System.out.println("\nЭлемент на позиции " + (index + 1) + ": " + list.get(index));
    } else {
      System.out.println("Неверный индекс.");
    }

    System.out.print("\nВведите индекс элемента для удаления (1 - " + list.size() + "): ");
    index = scanner.nextInt() - 1;  // Индексы для пользователя начинаются с 1
    if (index >= 0 && index < list.size()) {
      list.remove(index);
      System.out.println("\nСписок после удаления элемента с позиции " + (index + 1) + ":");
      list.printList();
    } else {
      System.out.println("Неверный индекс для удаления.");
    }

    System.out.println("\nРазмер списка: " + list.size());

    scanner.close();
  }
}
