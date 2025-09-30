public class Clone171 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:6309407
*  Stack Overflow answer #:6318293
*  And Stack Overflow answer#:6375412
*/
private void remWins () {
    Runtime runtime = Runtime.getRuntime ();
    long total = runtime.totalMemory ();
    long free = runtime.freeMemory ();
    long max = runtime.maxMemory ();
    long used = total - free;
    System.out.println (Math.round (used / 1e3) + " KB used before GC");
    Window [] wins = Window.getWindows ();
    for (int i = 0;
    i < wins.length; i ++) {
        if (wins [i] instanceof JDialog) {
            System.out.println ("    Trying to Remove JDialog");
            wins [i].setVisible (false);
            wins [i].dispose ();
            WindowEvent windowClosing = new WindowEvent (wins [i], WindowEvent.WINDOW_CLOSING);
            wins [i].dispatchEvent (windowClosing);
            Toolkit.getDefaultToolkit ().getSystemEventQueue ().postEvent (windowClosing);
            runtime = Runtime.getRuntime ();
            runtime.gc ();
            runtime.runFinalization ();
        }
    }
    wins = null;
    System.out.println ("    Remove Cycle Done :-)");
    runtime.runFinalization ();
    runtime.gc ();
    runtime = Runtime.getRuntime ();
    total = runtime.totalMemory ();
    free = runtime.freeMemory ();
    max = runtime.maxMemory ();
    used = total - free;
    System.out.println (Math.round (used / 1e3) + " KB used after GC");
    startOO ();
}

private void remWins () {
    runProcess = true;
    timer = new Timer (1000, new ActionListener () {
        @Override
        public void actionPerformed (ActionEvent e) {
            if (runProcess) {
                for (Window win : Window.getWindows ()) {
                    if (win instanceof JDialog) {
                        System.out.println ("    Trying to Remove JDialog");
                        win.dispose ();
                    }
                }
                System.out.println ("    Remove Cycle Done :-)");
                runProcess = false;
                new Thread () {
                    @Override
                    public void run () {
                        try {
                            Thread.sleep (100);
                        } catch (InterruptedException e) {
                            e.printStackTrace ();
                        }
                        Runtime.getRuntime ().gc ();
                    }}
                .start ();
            } else {
                pastRemWins ();
                runProcess = true;
            }
        }}
    );
    timer.setRepeats (true);
    timer.start ();
}

}
