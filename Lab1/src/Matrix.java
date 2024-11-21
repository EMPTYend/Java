import java.util.Scanner;

public class Matrix {
  private int[][] array;

  public Matrix(int rows, int cols) {
    array = new int[rows][cols];
  }

  public void inputMatrix(Scanner scanner) {
    System.out.println("Введите элементы матрицы по строкам (всего " + array.length + " строк и " + array[0].length + " столбцов):");
    for (int i = 0; i < array.length; i++)
      for (int j = 0; j < array[i].length; j++)
        array[i][j] = scanner.nextInt();
  }

  public void printMatrix() {
    System.out.println("Введённая матрица:");
    for (int[] row : array) {
      for (int elem : row) System.out.print(elem + " ");
      System.out.println();
    }
  }

  public int findMin() {
    int min = Integer.MAX_VALUE;
    for (int[] row : array)
      for (int elem : row)
        min = Math.min(min, elem);
    return min;
  }

  public int findMax() {
    int max = Integer.MIN_VALUE;
    for (int[] row : array)
      for (int elem : row)
        max = Math.max(max, elem);
    return max;
  }
}
