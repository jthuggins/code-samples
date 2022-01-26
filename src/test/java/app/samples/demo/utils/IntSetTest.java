package app.samples.demo.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntSetTest {

    @Test
    public void that_an_empty_set_is_empty() {
        // given
        IntSet testClass = new IntSet();

        // when
        boolean isEmpty = testClass.isEmpty();

        // then
        assertTrue(isEmpty);
    }

    @Test
    public void that_set_is_not_empty_after_adding() {
        // given
        IntSet testClass = new IntSet();

        // when
        testClass.add(5);

        // then
        assertFalse(testClass.isEmpty());
    }

    @Test
    public void that_set_is_empty_after_clearing() {
        // given
        IntSet testClass = new IntSet();
        testClass.add(5);

        // when
        testClass.clear();

        // then
        assertTrue(testClass.isEmpty());
    }

    @Test
    public void that_size_increments_after_adding() {
        // given
        IntSet testClass = new IntSet();

        // when
        testClass.add(5);
        testClass.add(10);

        // then
        assertEquals(2, testClass.size());
    }

    @Test
    public void that_set_contains_item_after_adding() {
        // given
        IntSet testClass = new IntSet();

        // when
        testClass.add(3);
        testClass.add(10);

        // then
        assertTrue(testClass.contains(3), "Set should contain 3");
        assertTrue(testClass.contains(10), "Set should contain 10");
    }

    @Test
    public void that_set_only_contains_added_items() {
        // given
        IntSet testClass = new IntSet();
        assertFalse(testClass.contains(0));

        // when
        testClass.add(4);

        // then
        assertTrue(testClass.contains(4), "Set should contain 4");
        assertFalse(testClass.contains(3), "Set should not contain 3");
        assertFalse(testClass.contains(0), "Set should not contain 0");
    }

    @Test
    public void that_duplicates_cannot_be_added() {
        // given
        IntSet testClass = new IntSet();

        // when
        testClass.add(7);
        testClass.add(7);

        // then
        assertEquals(1, testClass.size());
        assertTrue(testClass.contains(7));
    }

    @Test
    public void that_an_item_can_be_removed() {
        // given
        IntSet testClass = new IntSet();

        // when
        testClass.add(17);
        testClass.add(71);
        testClass.remove(17);

        // then
        assertEquals(1, testClass.size());
        assertFalse(testClass.contains(17));
    }

    @Test
    public void that_last_item_in_set_can_be_removed() {
        // given
        IntSet testClass = new IntSet();

        // when
        testClass.add(17);
        testClass.add(71);
        testClass.remove(71);

        // then
        assertEquals(1, testClass.size());
        assertFalse(testClass.contains(71));
    }

    @Test
    public void that_remove_does_nothing_if_not_in_set() {
        // given
        IntSet testClass = new IntSet();

        // when
        testClass.add(17);
        testClass.add(71);
        testClass.remove(99);

        // then
        assertEquals(2, testClass.size());
    }

    @Test
    public void that_more_items_than_the_capacity_can_be_added_to_set() {
        // given
        int capacity = 10;
        IntSet testClass = new IntSet(capacity);

        // when
        for(int i = 0; i < capacity + 10; i++) {
            testClass.add(i);
        }

        // then
        assertEquals(20, testClass.size());
        assertTrue(testClass.contains(17));
    }
}
