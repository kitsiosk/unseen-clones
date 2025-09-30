public class Clone863 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:302371
*  Stack Overflow answer #:302439
*  And Stack Overflow answer#:10431954
*/
public static void main (String...argv) throws Exception {
    FileChannel fc = new FileInputStream (argv [0]).getChannel ();
    ByteBuffer bb = fc.map (FileChannel.MapMode.READ_ONLY, 0, fc.size ());
    CharBuffer cb = Charset.defaultCharset ().decode (bb);
    Pattern p = Pattern.compile ("[^ \t\r\n\f.,!?:;\"()']+");
    Map < String, Integer > counts = new TreeMap < String, Integer > ();
    Matcher m = p.matcher (cb);
    while (m.find ()) {
        String word = m.group ();
        Integer count = counts.get (word);
        count = (count == null) ? 1 : count + 1;
        counts.put (word, count);
    }
    fc.close ();
    for (Map.Entry < String, Integer > e : counts.entrySet ()) {
        System.out.printf ("%s: %d%n", e.getKey (), e.getValue ());
    }
}

public static void main (String args []) {
    Map < String, Integer > tm = new TreeMap < String, Integer > ();
    try {
        FileInputStream fis = new FileInputStream ("Test.txt");
        DataInputStream in = new DataInputStream (fis);
        BufferedReader br = new BufferedReader (new InputStreamReader (in));
        String line;
        int countValue = 1;
        while ((line = br.readLine ()) != null) {
            line = line.replaceAll ("[-+.^:;,()\"\\[\\]]", "");
            StringTokenizer st = new StringTokenizer (line, " ");
            while (st.hasMoreTokens ()) {
                String nextElement = (String) st.nextElement ();
                if (tm.size () > 0 && tm.containsKey (nextElement)) {
                    int val = 0;
                    if (tm.get (nextElement) != null) {
                        val = (Integer) tm.get (nextElement);
                        val = val + 1;
                    }
                    tm.put (nextElement, val);
                } else {
                    tm.put (nextElement, 1);
                }
            }
        }
        for (Map.Entry < String, Integer > entry : tm.entrySet ()) {
            System.out.println (entry.getKey () + " : " + entry.getValue ());
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace ();
    } catch (IOException e) {
        e.printStackTrace ();
    }
}

}
