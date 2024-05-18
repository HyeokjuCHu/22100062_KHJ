package Prac;

public class ListArrayObject {
    private Object[] array;

    public ListArrayObject() {
        array = new Object[0];
    }

    public void add(Object o) {
        Object[] newArray = new Object[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = o;
        array = newArray;
    }

    public Object get(int index) {
        if (isNull(index)) {
            return null;
        } else {
            return array[index];
        }
    }

    public void remove(int index) {
        if (isNull(index)) {
            return;
        }
        Object[] newArray = new Object[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
        array = newArray;
    }

    public void remove() {
        if (array.length == 0) {
            return;
        }
        Object[] newArray = new Object[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, array.length - 1);
        array = newArray;
    }

    public int size() {
        return array.length;
    }

    public boolean isNull(int index) {
        return index < 0 || index >= array.length;
    }
}
