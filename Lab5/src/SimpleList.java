import java.util.Arrays;

public class SimpleList<T> {
  private Object[] elements;
  private int size;
  private static final int INITIAL_CAPACITY = 10;

  public SimpleList() {
    elements = new Object[INITIAL_CAPACITY];
    size = 0;
  }

  public void add(T element) {
    if (size == elements.length) {
      resize();
    }
    elements[size++] = element;
  }

  public void remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Неверный индекс");
    }

    for (int i = index; i < size - 1; i++) {
      elements[i] = elements[i + 1];
    }
    elements[--size] = null;
  }

  public T get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Неверный индекс");
    }
    return (T) elements[index];
  }

  public int size() {
    return size;
  }

  private void resize() {
    elements = Arrays.copyOf(elements, elements.length * 2);
  }

  public void printList() {
    for (int i = 0; i < size; i++) {
      System.out.println(elements[i]);
    }
  }
}
