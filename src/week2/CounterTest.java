package week2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CounterTest {
    Counter counter1 = new Counter();

    @Test
    void testIncrement() {
	assertTrue(counter1.increment() == 1);
	assertTrue(counter1.increment() == 2);
    }

    @Test
    void testDecrement() {
	assertTrue(counter1.decrement() == -1);
    }

    @Test
    void testGetCount() {
	assertEquals(0, counter1.getCount());
    }

}
