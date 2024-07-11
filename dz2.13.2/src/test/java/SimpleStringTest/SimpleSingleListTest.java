package SimpleStringTest;

import org.example.SimpleStringList;
import org.example.exceptions.IncorrectCapacityException;
import org.example.exceptions.InvalidIndexException;
import org.example.exceptions.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class SimpleStringListTest {

    private SimpleStringList list;

    @BeforeEach
    void setUp() {
        list = new SimpleStringList(10);
    }

    @Test
    void testAdd() {
        assertEquals("Hello", list.add("Hello"));
        assertThrows(NotFoundException.class, () -> list.add(null), "Item cannot be null");
    }

    @Test
    void testAddAtIndex() {
        list.add("Hello");
        list.add("World");
        assertEquals("Java", list.add(1, "Java"));
        assertEquals("Java", list.get(1));
        assertThrows(NotFoundException.class, () -> list.add(1, null), "Item cannot be null");
        assertThrows(InvalidIndexException.class, () -> list.add(10, "OutOfBounds"), "Index out of bounds");
    }

    @Test
    void testSet() {
        list.add("Hello");
        list.add("World");
        assertEquals("JAVA", list.set(1, "JAVA"));
        assertEquals("JAVA", list.get(1));
        assertThrows(NotFoundException.class, () -> list.set(1, null), "Item cannot be null");
        assertThrows(InvalidIndexException.class, () -> list.set(5, "OutOfBounds"), "Index out of bounds");
    }

    @Test
    void testRemoveItem() {
        list.add("Hello");
        list.add("World");
        assertEquals("World", list.remove("World"));
        assertThrows(NotFoundException.class, () -> list.remove(null), "Item cannot be null");
    }

    @Test
    void testRemoveAtIndex() {
        list.add("Hello");
        list.add("World");
        assertEquals("Hello", list.remove(0));
        assertThrows(InvalidIndexException.class, () -> list.remove(5), "Index out of bounds");
    }

    @Test
    void testContains() {
        list.add("Hello");
        list.add("World");
        assertTrue(list.contains("World"));
        assertFalse(list.contains("Java"));
        assertThrows(NotFoundException.class, () -> list.contains(null), "Item cannot be null");
    }

    @Test
    void testIndexOf() {
        list.add("Hello");
        list.add("World");
        assertEquals(1, list.indexOf("World"));
        assertEquals(-1, list.indexOf("Java"));
        assertThrows(NotFoundException.class, () -> list.indexOf(null), "Item cannot be null");
    }

    @Test
    void testLastIndexOf() {
        list.add("Hello");
        list.add("Hello");
        assertEquals(1, list.lastIndexOf("Hello"));
        assertEquals(-1, list.lastIndexOf("World"));
        assertThrows(NotFoundException.class, () -> list.lastIndexOf(null), "Item cannot be null");
    }

    @Test
    void testGet() {
        list.add("Hello");
        assertEquals("Hello", list.get(0));
        assertThrows(InvalidIndexException.class, () -> list.get(10), "Index out of bounds");
    }

    @Test
    void testEquals() {
        SimpleStringList otherList = new SimpleStringList(10);
        list.add("Hello");
        list.add("World");
        otherList.add("Hello");
        otherList.add("World");
        assertTrue(list.equals(otherList));
        otherList.add("Java");
        assertFalse(list.equals(otherList));
        assertThrows(NotFoundException.class, () -> list.equals(null), "Other list cannot be null");
    }
}