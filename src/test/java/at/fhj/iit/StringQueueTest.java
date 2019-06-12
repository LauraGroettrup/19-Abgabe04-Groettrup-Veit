package at.fhj.iit;

/**
 * This class contains the tests to test if the methods in StringQueue.java
 * provide the expected outcome.
 *
 * @author Jessy and Laura
 * @version 1.0
 *
 */
import static org.junit.Assert.assertEquals;
import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;

public class StringQueueTest {

    private StringQueue que;

    /**
     * Initialize a StringQueue with maxsize=3.
     */
    @Before
    public void setup()  {
        que = new StringQueue(3);
    }

    /**
     * Test if offer() works if the Stringqueue contains no elements. Because
     * the maxsize is not exceeded, the method should be able to add an element.
     * If the operation can be executed, the method should return true.
     */
    @Test
    public void offerNotFull() {
        assertEquals(true, que.offer("first"));
    }

    /**
     * Test if offer() works if the Stringqueue contains as much elements as
     * maxsize is big. Because the maxsize is exceeded, the method should not be
     * able to add an element. If the operation can not be executed, the method
     * should return false.
     */
    @Test
    public void offerFull() {
        que.offer("first");
        que.offer("second");
        que.offer("third");
        assertEquals(false, que.offer("fourth"));
    }

    /**
     * Test if poll() works if the Stringqueue contains an element. Because the
     * queue is not empty, the method should be able to return and delete the
     * first element. If the operation can be executed, the method should return
     * the first element(String) in the queue.
     */
    @Test
    public void pollNotEmpty() {
        que.offer("first");
        assertEquals("first", que.poll());
    }

    /**
     * Test if poll() works if the Stringqueue contains no elements. Because the
     * queue is empty, the method should not be able to return and delete the
     * first element, because there is none. If the operation can not be
     * executed, the method should return null.
     */
    @Test
    public void pollEmpty() {
        assertEquals(null, que.poll());
    }

    /**
     * Test if remove() works if the Stringqueue contains an element. Because
     * the queue is not empty, the method should be able to return and delete
     * the first element. If the operation can be executed, the method should
     * return the first element(String) in the queue.
     */
    @Test
    public void removeNotEmpty() {
        que.offer("first");
        assertEquals("first", que.remove());
    }

    /**
     * Test if remove() works if the Stringqueue contains no elements. Because
     * the queue is empty, the method should not be able to return and delete
     * the first element, because there is none. If the operation can not be
     * executed, the method should throw a NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void removeEmpty() {
        que.remove();
    }

    /**
     * Test if peek() works if the Stringqueue contains an element. Because the
     * queue is not empty, the method should be able to return the first
     * element. If the operation can be executed, the method should return the
     * first element(String) in the queue.
     */
    @Test
    public void peekNotEmpty() {
        que.offer("first");
        assertEquals("first", que.peek());
    }

    /**
     * Test if peek() works if the Stringqueue contains no elements. Because the
     * queue is empty, the method should not be able to return the first
     * element, because there is none. If the operation can not be executed, the
     * method should return null.
     */
    @Test
    public void peekEmpty() {
        assertEquals(null, que.peek());
    }

    /**
     * Test if element() works if the Stringqueue contains an element. Because
     * the queue is not empty, the method should be able to return the first
     * element. If the operation can be executed, the method should return the
     * first element(String) in the queue.
     */
    @Test
    public void elementNotEmpty() {
        que.offer("first");
        assertEquals("first", que.peek());
    }

    /**
     * Test if element() works if the Stringqueue contains no elements. Because
     * the queue is empty, the method should not be able to return the first
     * element, because there is none. If the operation can not be executed, the
     * method throw a NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void elementEmpty() {
        que.element();
    }

}
