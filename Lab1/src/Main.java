import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Введите количество строк матрицы: ");
    int rows = scanner.nextInt();
    System.out.print("Введите количество столбцов матрицы: ");
    int cols = scanner.nextInt();

    Matrix matrix = new Matrix(rows, cols);

    matrix.inputMatrix(scanner);
    matrix.printMatrix();
    System.out.println("Минимальный элемент: " + matrix.findMin());
    System.out.println("Максимальный элемент: " + matrix.findMax());
  }
}
