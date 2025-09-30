public class Clone630 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:7943584
*  Stack Overflow answer #:7944388
*  And Stack Overflow answer#:8130028
*/
private void printWords () {
    for (int i = 0;
    i < petStrings.length; i ++) {
        String word = petStrings [i].toString ();
        System.out.println (word);
        try {
            Thread.sleep (100);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        three.setText (word);
    }
    three.setText ("<html> Concurency Issues in Swing<br>" + " never to use Thread.sleep(int) <br>" + " durring EDT, simple to freeze GUI </html>");
}

private void printWords () {
    final Timer timer = new Timer (100, null);
    ActionListener listener = new ActionListener () {
        private Iterator < Word > w = words.iterator ();
        @Override
        public void actionPerformed (ActionEvent e) {
            if (w.hasNext ()) {
                _textField.setText (w.next ().getName ());
            } else {
                timer.stop ();
            }
        }}
    ;
    timer.addActionListener (listener);
    timer.start ();
}

}
