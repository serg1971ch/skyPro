package org.example;

import org.example.exceptions.IncorrectCapacityException;
import org.example.exceptions.InvalidIndexException;
import org.example.exceptions.NotFoundException;

import java.util.Arrays;
import java.util.Objects;

public class SimpleIntegerListImpl implements SimpleIntegerList {

    private final static int DEFAULT_CAPACITY = 0;
    private final Integer[] storage;
    private int size;

    public SimpleIntegerListImpl() {
        this(DEFAULT_CAPACITY);
    }

    public SimpleIntegerListImpl(int size) {
        if (size <= 0) {
            throw new IncorrectCapacityException("Initial capacity must be greater than zero.");
        }
        storage = new Integer[size];
        size = 0;
    }

    @Override
    public int add(Integer item) {
        return add(size, item);
    }

    @Override
    public int add(int index, Integer item) {
        checkIsNull(item);
        if (size == storage.length) {
            throw new IncorrectCapacityException("Wrong capacity");
        }
        checkIndex(index, false);
        if (index < size) {
            System.arraycopy(storage, index, storage, index + 1, size - index);
        }

        storage[index] = item;
        size++;
        return item;
    }

    @Override
    public int set(int index, Integer item) {
        checkIsNull(item);
        checkIndex(index, true);
        return storage[index] = item;
    }

    @Override
    public int remove(Integer item) {
        return remove(indexOf(item));
    }


    @Override
    public int remove(int index) {
        checkIndex(index, true);
        if (index < size - 1) {
            System.arraycopy(storage, index + 1, storage, index + 1, size - index - 1);
        }
        Integer removed = storage[index];
        storage[--size] = null;
        return removed;
    }

    @Override
    public boolean contains(Integer item) {
        checkIsNull(item);
//        for (int i = 0; i < size; i++) {
//            if (storage[i].equals(item)) {
//                return true;
//            }
//        }
//        return false;
        Integer[] copy = toArray();
        sortInsertion(copy);
        return contains(copy, item);
    }

    @Override
    public int indexOf(Integer item) {
        checkIsNull(item);
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        checkIsNull(item);
        for (int i = size - 1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        checkIndex(index, true);
        return storage[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if(otherList == null) {
            throw new NotFoundException("OtherList not found");
        }
        if (size() != otherList.size()) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (!storage[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    private static void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1].compareTo(temp) >= 0) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static boolean contains(Integer[]array, Integer element) {
        int min = 0;
        int max = array.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element.equals(array[mid])) {
                return true;
            }

            if (element.compareTo(array[mid]) < 0) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    private void checkIsNull(Integer item) {
        if (Objects.isNull(item)) {
            throw new NotFoundException("Item not found.");
        }
    }

    private void checkIndex(int index, boolean include) {
        if (index < 0 && include ? index >= size : index > size) {
            throw new InvalidIndexException("Wrong index");
        }
    }
}
