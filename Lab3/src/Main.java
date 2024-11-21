import java.util.Scanner;

public class Main {

  public static class MDouble {
    private double value;

    public MDouble(double value) throws MDoubleException {
      if (Double.isInfinite(value)) {
        this.value = 99999;  // Заменяем POSITIVE_INFINITY на 99999
        throw new MDoubleException("Значение POSITIVE_INFINITY заменено на 99999");
      } else if (Double.isNaN(value)) {
        this.value = 0;  // Заменяем NaN на 0
        throw new MDoubleException("Значение NaN заменено на 0");
      } else {
        this.value = value;
      }
    }

    public double getValue() {
      return value;
    }

    public String toString() {
      return String.valueOf(value);
    }
  }

  public static class MDoubleException extends Exception {
    public MDoubleException(String message) {
      super(message);
    }
  }

  public static class MDoubleCalculator {
    public static MDouble[] divideArrays(MDouble[] x, MDouble[] y) {
      if (x.length != y.length) {
        throw new IllegalArgumentException("Массивы должны быть одинаковой длины");
      }

      MDouble[] z = new MDouble[x.length];
      for (int i = 0; i < x.length; i++) {
        try {

          double xi = x[i].getValue();
          double yi = y[i].getValue();

          if (yi == 0) {
            throw new ArithmeticException("Деление на 0");
          }
          z[i] = new MDouble(xi / yi);
        } catch (MDoubleException e) {
          System.out.println("Ошибка: " + e.getMessage() + " для индекса " + i);
          try {
            z[i] = new MDouble(0);
          } catch (MDoubleException ex) {
            System.out.println("Не удалось создать MDouble для индекса " + i + ": " + ex.getMessage());
          }
        } catch (ArithmeticException e) {
          System.out.println("Ошибка: " + e.getMessage() + " для индекса " + i);
          try {
            z[i] = new MDouble(0);
          } catch (MDoubleException ex) {
            System.out.println("Не удалось создать MDouble для индекса " + i + ": " + ex.getMessage());
          }
        }
      }
      return z;
    }
  public static void main(String[] args) {
      try {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные для массива X (MDouble):");
        MDouble[] x = new MDouble[5];
        for (int i = 0; i < 5; i++) {
          System.out.print("Введите значение для x[" + i + "]: ");
          double value = scanner.nextDouble();
          x[i] = new MDouble(value);
        }

        System.out.println("Введите данные для массива Y (MDouble):");
        MDouble[] y = new MDouble[5];
        for (int i = 0; i < 5; i++) {
          System.out.print("Введите значение для y[" + i + "]: ");
          double value = scanner.nextDouble();
          y[i] = new MDouble(value);
        }

        MDouble[] z = MDoubleCalculator.divideArrays(x, y);
        
        System.out.println("Результаты деления массивов X и Y:");
        for (int i = 0; i < z.length; i++) {
          if (z[i] != null) {
            System.out.println("z[" + i + "] = " + z[i].toString());
          } else {
            System.out.println("z[" + i + "] = Ошибка");
          }
        }
      } catch (MDoubleException e) {
        System.out.println("Ошибка при создании MDouble: " + e.getMessage());
      } catch (Exception e) {
        System.out.println("Произошла ошибка: " + e.getMessage());
      }
    }
  }
}
