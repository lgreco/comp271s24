import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SimpleLinkedListSolutionTest {

    static SimpleLinkedListSolution queue = new SimpleLinkedListSolution();
    static SimpleLinkedListSolution stack = new SimpleLinkedListSolution();

    @Test
    public void testAdd() {
        assertTrue(queue.add("A"));
        assertTrue(queue.add("B"));
        assertTrue(queue.add("C"));
    }

    @Test
    public void testPull() {
        assertEquals("A", queue.remove());
        assertEquals("B", queue.remove());
        assertEquals("C", queue.remove());
        assertEquals(null, queue.remove());
    }

    @Test
    public void testPush() {
        assertTrue(stack.push("A"));
        assertTrue(stack.push("B"));
        assertTrue(stack.push("C"));
    }

    @Test
    public void testRemove() {
        assertEquals("C",stack.pull());
        assertEquals("B",stack.pull());
        assertEquals("A",stack.pull());
        assertEquals(null, stack.pull());
    }
}
