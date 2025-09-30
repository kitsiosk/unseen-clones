public class Clone138 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:27737781
*  Stack Overflow answer #:27739235
*  And Stack Overflow answer#:27738182
*/
public synchronized void add (M msg) {
    Queue < M > queue = threadQueue.get ();
    if (queue == null) {
        queue = new LinkedList < > ();
        queues.add (queue);
        threadQueue.set (queue);
    }
    queue.add (msg);
    notify ();
}

public boolean add (P producer, E item) {
    lock.lock ();
    try {
        if (! queues.containsKey (producer)) {
            queues.put (producer, new PriorityBlockingQueue < > ());
        }
        added.signalAll ();
        return queues.get (producer).add (item);
    } finally {
        lock.unlock ();
    }
}

}
