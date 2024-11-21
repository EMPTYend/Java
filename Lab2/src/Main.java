import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Введите данные для большой миски:");
    System.out.print("Координата X: ");
    double xLarge = scanner.nextDouble();
    System.out.print("Координата Y: ");
    double yLarge = scanner.nextDouble();
    System.out.print("Радиус: ");
    double radiusLarge = scanner.nextDouble();
    System.out.print("Высота: ");
    double heightLarge = scanner.nextDouble();

    System.out.println("\nВведите данные для маленькой миски:");
    System.out.print("Координата X: ");
    double xSmall = scanner.nextDouble();
    System.out.print("Координата Y: ");
    double ySmall = scanner.nextDouble();
    System.out.print("Радиус: ");
    double radiusSmall = scanner.nextDouble();
    System.out.print("Высота: ");
    double heightSmall = scanner.nextDouble();

    Program.Bowl largeBowl = new Program.Bowl(xLarge, yLarge, radiusLarge, heightLarge);
    Program.Bowl smallBowl = new Program.Bowl(xSmall, ySmall, radiusSmall, heightSmall);

    System.out.println("\nБольшая миска: " + largeBowl);
    System.out.println("Меньшая миска: " + smallBowl);

    double halfSmallBowl = smallBowl.calculateSoupVolume() / 2;
    double remainingSoup = largeBowl.calculateSoupVolume() - halfSmallBowl;

    // Вывод результата
    System.out.printf("После наполнения половины меньшей миски, в большой миске останется %.2f супа.%n", remainingSoup);
  }
}
