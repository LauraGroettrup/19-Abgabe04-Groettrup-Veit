package at.fhj.iit;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Implementation of a queue for managing string-objects.
 *
 * @author Jessy
 */
public class StringQueue implements Queue {

    private static final Logger LOG = LogManager.getLogger(StringQueue.class);
    private List<String> elements = new ArrayList<String>();
    private int maxSize = 5;

    public StringQueue(int maxsize) {
        LOG.info("Construct a StringQueue with the maxsize = " + maxsize);
        this.maxSize = maxsize;
    }

    /**
     * Adds the given string object to the queue. If the addition is successful,
     * the method returns true.
     *
     * @param obj
     * @return
     */
    @Override
    public boolean offer(String obj) {
        if (elements.size() != maxSize) {
            elements.add(obj);
            LOG.info("Method offer has add an element to the queue: " + obj);
        } else {
            LOG.info("Method offer has could not add an element to the queue. Maxsize is already reached.");
            return false;
        }
        return true;
    }

    /**
     * Returns the head (first) string in the queue and deletes it. Returns null
     * if queue is empty.
     *
     * @return
     */
    @Override
    public String poll() {
        String element = peek();

        if (!elements.isEmpty()) {
            LOG.info("Method poll returned and deleted the first element in queue: " + element);
            elements.remove(0);
        } else {
            LOG.info("Method poll could not return and delete the first element in queue. There is no element left.");
        }
        return element;
    }

    /**
     * Returns the head (first) string in the queue and deletes it. Throws
     * NoSuchElementException if queue is empty.
     *
     * @return
     */
    @Override
    public String remove() {
        String element = poll();
        if (element == null) {
            LOG.error("Method remove could not return and delete the first element in queue. There is no element left.");
            throw new NoSuchElementException("there's no element any more");
        }
        LOG.info("Method remove returned and deleted the first element in queue: " + element);
        return element;
    }

    /**
     * Returns the head (first) string in the queue. Returns null if queue is empty.
     *
     * @return
     */
    @Override
    public String peek() {
        String element;
        if (elements.size() > 0) {
            element = elements.get(0);
            LOG.info("Method peek returned the first element in queue: " + element);
        } else {
            element = null;
            LOG.info("Method peek could not return the first element in queue. There is no element left.");
        }
        return element;
    }

    /**
     * Returns the head (first) string in the queue. Throws
     * NoSuchElementException if queue is empty.
     *
     * @return
     */
    @Override
    public String element() {
        String element = peek();
        if (element == null) {
            LOG.error("Method element could not return the first element in queue. There is no element left.");
            throw new NoSuchElementException("there's no element any more");
        }
        LOG.info("Method element returned the first element in queue: " + element);
        return element;
    }
}
