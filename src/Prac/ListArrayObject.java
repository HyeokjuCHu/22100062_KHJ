package Prac;


public class ListArrayObject {
    Object[] array = null;

    public ListArrayObject() {
        array = new Object[0];
    }

    public void add(Object o) {
        Object[] newArray = new Object[size() + 1];
        newArray = array;
        array = new Object[size() + 1];
        array = newArray;
        array[size() - 1] = o;
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
        } else {
            Object[] deleteArray = new Object[size()];
            for (int i = 0; i < size(); i++) {
                deleteArray[i] = array[i];
            }
            array = new Object[size() - 1];
            int count = 0;
            for (int i = 0; i < deleteArray.length; i++) {
                if (i == index) {
                    continue;
                }
                array[count++] = deleteArray[i];
            }
        }

    }

    public void remove() {
        Object[] deleteArray = new Object[size()];
        for (int i = 0; i < size(); i++) {  //same as deleteArray = array;
            deleteArray[i] = array[i];
        }
        array = new Object[size() - 1];
        for (int i = 0; i < size(); i++) {
            array[i] = deleteArray[i];
        }
    }

    public int size() {
        return array.length;
    }

    public boolean isNull(int index) {
        if (index > -1 && index < array.length) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String args[]) {

    }
}