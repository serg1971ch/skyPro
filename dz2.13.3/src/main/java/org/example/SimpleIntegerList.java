package org.example;

public interface SimpleIntegerList {
    int add(Integer item);

    int add(int index, Integer item);

    int set(int index, Integer item);

    int remove(Integer item);

    int remove(int index);

    boolean contains(Integer item);

    int indexOf(Integer item);

    int lastIndexOf(Integer item);

    Integer get(int index);

    boolean equals(StringList otherList);

    int size();

    boolean isEmpty();

    void clear();

    Integer[] toArray();
}
