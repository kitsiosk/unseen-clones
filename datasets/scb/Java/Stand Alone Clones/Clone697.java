public class Clone697 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:9413656
*  Stack Overflow answer #:43063982
*  And Stack Overflow answer#:9413767
*/
public static void main (String [] args) throws Exception {
    CountDownLatch latch = new CountDownLatch (1);
    JobDetail job = JobBuilder.newJob (SimpleJob.class).withIdentity ("CronQuartzJob", "Group").build ();
    Trigger trigger = newTrigger ().withIdentity ("TriggerName", "Group").withSchedule (CronScheduleBuilder.cronSchedule ("0/1 * * * * ?")).build ();
    final Scheduler scheduler = new StdSchedulerFactory ().getScheduler ();
    scheduler.start ();
    scheduler.scheduleJob (job, trigger);
    latch.await ();
    Runtime.getRuntime ().addShutdownHook (new Thread (new Runnable () {
        @Override
        public void run () {
            try {
                scheduler.shutdown ();
                latch.countDown ();
            } catch (Exception e) {
                e.printStackTrace ();
            }
        }}
    ));
}

public static void main (String [] args) {
    final ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor ();
    ses.scheduleWithFixedDelay (new Runnable () {
        @Override
        public void run () {
            System.out.println (new Date ());
        }}
    , 0, 1, TimeUnit.SECONDS);
}

}
