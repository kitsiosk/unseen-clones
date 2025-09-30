public class Clone785 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:11242208
*  Stack Overflow answer #:11242577
*  And Stack Overflow answer#:24974246
*/
public static void main (String args []) throws IOException {
    BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
    String st = br.readLine ();
    int len = st.length ();
    String [] str = new String [7];
    len = len / 30;
    int i = 0;
    for (; i < 7 && i < len; i ++) {
        str [i] = st.substring (30 * i, 30 * (i + 1));
        System.out.println (str [i]);
    }
    if (i != 7) {
        str [i] = st.substring (30 * i, st.length ());
        System.out.println (str [i]);
    }
}

public static void main (String [] args) {
    String x = "flskdafsld~fdsakçkçfsda sfdaldsak~çfdskkfadsçlkçfldskçlflçfdskçldksçlkfdslçakafdslçdsklçfdskçlafdskçkdfsçlkfds~çlkfasdçlçfdls~kçlf~dksçlsakdçlkfç";
    System.out.println ("x length: " + x.length ());
    String [] lines = Split (x, 30, 210);
    for (int i = 0;
    i < lines.length; i ++) {
        System.out.println ("lines[" + i + "]: (len: " + lines [i].length () + ") : " + lines [i]);
    }
}

}
