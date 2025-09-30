public class Clone516 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:30661832
*  Stack Overflow answer #:30701775
*  And Stack Overflow answer#:30662037
*/
public Thread newThread (Runnable runnable) {
    Runnable proxyRunnable = (Runnable) Proxy.newProxyInstance (runnable.getClass ().getClassLoader (), runnable.getClass ().getInterfaces (), new RunnableProxy (runnable));
    Thread thread = new Thread (threadGroup, proxyRunnable, namePrefix + threadNumber.getAndIncrement (), 0);
    thread.setPriority (Thread.NORM_PRIORITY);
    thread.setUncaughtExceptionHandler (new Thread.UncaughtExceptionHandler () {
        public void uncaughtException (Thread thread, Throwable cause) {
            logger.fine (cause.getMessage ());
        }}
    );
    logger.fine (thread.toString () + " created.");
    return thread;
}

public Thread newThread (Runnable runnable) {
    Runnable wrapper = new Runnable () {
        @Override
        public void run () {
            System.out.println ("Starting thread ...");
            try {
                runnable.run ();
                System.out.println ("Thread done");
            } catch (Throwable t) {
                System.out.println ("Thread exited abnormally");
            }
        }}
    ;
    Thread thread = new Thread (threadGroup, wrapper, namePrefix + threadNumber.getAndIncrement (), 0);
}

}
