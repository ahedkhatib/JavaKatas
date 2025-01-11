package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QueueWithFailoverTest {

    @Test
    void testSendandRetrieveJob(){
        QueueWithFailover queue = new QueueWithFailover(3);
        queue.sendJob("Job 1");
        queue.sendJob("Job 2");

        assertEquals("Job 1", queue.getJob());
        assertEquals("Job 2", queue.getJob());
    }

    @Test
    void testGetJobFromEmptyQueue(){
        QueueWithFailover queue = new QueueWithFailover(3);

        assertThrows(QueueWithFailover.EmptyQueueException.class, queue::getJob);
    }

    @Test
    void testJobDone(){
        QueueWithFailover queue = new QueueWithFailover(3);
        queue.sendJob("Job 1");
        String job = queue.getJob();
        queue.jobDone(job);
        assertEquals(0, queue.size());
    }

    @Test
    void testJobDoneThrows(){
        QueueWithFailover queue = new QueueWithFailover(3);
        assertThrows(IllegalArgumentException.class, () -> queue.jobDone("Unknown job"));
    }

    @Test
    void testInFlightSize(){
        QueueWithFailover queue = new QueueWithFailover(3);
        queue.sendJob("Job 1");
        queue.sendJob("Job 2");
        queue.getJob();
        assertEquals(1, queue.inFlightSize());
        queue.getJob();
        assertEquals(2, queue.inFlightSize());
    }

    @Test
    void testReturnExpiredJobsToQueue(){
        QueueWithFailover queue = new QueueWithFailover(2);
        queue.sendJob("Job 1");
        queue.sendJob("Job 2");
        queue.getJob();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        queue.returnExpiredJobsToQueue();
        assertEquals("Job 2", queue.getJob());
        assertEquals("Job 1", queue.getJob());
    }

    @Test
    void testJobDoneAfterTimeOut(){
        QueueWithFailover queue = new QueueWithFailover(2);
        queue.sendJob("Job 1");
        queue.sendJob("Job 2");
        String currentJob = queue.getJob();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        queue.returnExpiredJobsToQueue();
        assertThrows(IllegalArgumentException.class, () -> queue.jobDone(currentJob));
    }

}
