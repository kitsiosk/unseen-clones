public class Clone811 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:14492848
*  Stack Overflow answer #:14493395
*  And Stack Overflow answer#:14492968
*/
public void actionPerformed (ActionEvent e) {
    long time = System.nanoTime ();
    if (lastTime < 0) {
        lastTime = time;
        timeString = "00.00";
    } else if (time - lastTime > 1000) {
        long duration = time - lastTime;
        double fps = 1000000000d * (double) frameCount / (double) duration;
        timeString = format.format (fps);
        frameCount = 0;
        lastTime = time;
        System.out.println (timeString);
    }
    frameCount ++;
    cards.next (gui);
}

public void actionPerformed (ActionEvent e) {
    long start = System.currentTimeMillis ();
    frame.remove (panel);
    long end = System.currentTimeMillis ();
    JPanel newPanel = new JPanel ();
    newPanel.setBackground (Color.BLUE);
    frame.add (newPanel);
    frame.validate ();
}

}
