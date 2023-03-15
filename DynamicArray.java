import java.util.Arrays;
import java.util.NoSuchElementException;

public class DynamicArray<T> {
    private T[] array;
    private int length;

    public DynamicArray() {
        this.array = (T[]) new Object[0];
        this.length = 0;
    }

    public DynamicArray(T[] data) {
        this.array = data.clone();
        this.length = data.length;
    }

    public void insert(T item) {
        T[] newArray = (T[]) new Object[length + 1];
        for (int i = 0; i < length; i++) {
            newArray[i] = array[i];
        }
        newArray[length++] = item;
        array = newArray;
    }

    public void deleteByIndex(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
        T[] newArray = (T[]) new Object[length - 1];
        for (int i = 0, j = 0; i < length; i++) {
            if (i != index) {
                newArray[j++] = array[i];
            }
        }
        length--;
        array = newArray;
    }

    public void deleteAll(T item) {
        T[] newArray = (T[]) new Object[length];
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (!array[i].equals(item)) {
                newArray[count++] = array[i];
            }
        }
        length = count;
        array = Arrays.copyOf(newArray, length);
    }

    public T findMin() {
        if (length == 0) {
            throw new NoSuchElementException();
        }
        T min = array[0];
        for (int i = 1; i < length; i++) {
            if (((Comparable<T>) array[i]).compareTo(min) < 0) {
                min = array[i];
            }
        }
        return min;
    }

    public T findMax() {
        if (length == 0) {
            throw new NoSuchElementException();
        }
        T max = array[0];
        for (int i = 1; i < length; i++) {
            if (((Comparable<T>) array[i]).compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }

    public T sum() {
        if (length == 0) {
            throw new NoSuchElementException();
        }
        T sum = array[0];
        for (int i = 1; i < length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public T product() {
        if (length == 0) {
            throw new NoSuchElementException();
        }
        T product = array[0];
        for (int i = 1; i < length; i++) {
            product *= array[i];
        }
        return product;
    }

    public int findIndex(T item) {
        for (int i = 0; i < length; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T item) {
        return findIndex(item) != -1;
    }

    public void bubbleSort() {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (((Comparable<T>) array[j]).compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1= temp;
                }
            }
        }
    }

    public void insertionSort() {
        for (int i = 1; i < length; i++) {
            T current = array[i];
            int j = i - 1;
            while (j >= 0 && ((Comparable<T>) array[j]).compareTo(current) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }
    
    public void selectionSort() {
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (((Comparable<T>) array[j]).compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            T temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
    
    public T get(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }
    
    public void set(int index, T item) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = item;
    }
    
    public void print() {
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            System.out.print(array[i]);
            if (i != length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    public int length() {
        return length;
    }
}