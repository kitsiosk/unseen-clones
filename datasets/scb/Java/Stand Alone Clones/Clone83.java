public class Clone83 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3256269
*  Stack Overflow answer #:3264717
*  And Stack Overflow answer#:3256941
*/
protected void paintComponent (Graphics g) {
    int width = this.getWidth ();
    int height = this.getHeight ();
    if (activeRedraw) {
        if (repaintBuffer1) {
            Graphics g1 = buffer1.getGraphics ();
            g1.clearRect (0, 0, width, height);
            g1.setColor (Color.green);
            g1.drawRect (0, 0, width - 1, height - 1);
            g.drawImage (buffer1, 0, 0, null);
            repaintBuffer1 = false;
        }
        double time = 2 * Math.PI * (System.currentTimeMillis () % 5000) / 5000.;
        g.setColor (Color.RED);
        if (rect != null) {
            g.drawImage (buffer1, rect.x, rect.y, rect.x + rect.width, rect.y + rect.height, rect.x, rect.y, rect.x + rect.width, rect.y + rect.height, this);
        }
        rect = new Rectangle ((int) (Math.sin (time) * width / 3 + width / 2 - 20), (int) (Math.cos (time) * height / 3 + height / 2) - 20, 40, 40);
        g.fillRect (rect.x, rect.y, rect.width, rect.height);
        activeRedraw = false;
    }
}

protected void paintComponent (Graphics g) {
    long start = System.nanoTime ();
    super.paintComponent (g);
    int w = this.getWidth ();
    int h = this.getHeight ();
    g.drawImage (background, 0, 0, this);
    double theta = 2 * Math.PI * index ++ / 64;
    g.setColor (Color.blue);
    rect.setRect ((int) (Math.sin (theta) * w / 3 + w / 2 - RADIUS), (int) (Math.cos (theta) * h / 3 + h / 2 - RADIUS), 2 * RADIUS, 2 * RADIUS);
    g.fillOval (rect.x, rect.y, rect.width, rect.height);
    g.setColor (Color.white);
    if (frameCount == FRAMES) {
        averageTime = totalTime / FRAMES;
        totalTime = 0;
        frameCount = 0;
    } else {
        totalTime += System.nanoTime () - start;
        frameCount ++;
    }
    String s = String.format ("%1$5.3f", averageTime / 1000000d);
    g.drawString (s, 5, 16);
}

}
