public class Clone268 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:21722458
*  Stack Overflow answer #:21724813
*  And Stack Overflow answer#:21722533
*/
public static boolean isAvailable (String link) {
    boolean available = false;
    URL url = null;
    try {
        url = new URL (link);
    } catch (MalformedURLException e) {
        e.printStackTrace ();
    }
    HttpURLConnection connection = null;
    try {
        connection = (HttpURLConnection) url.openConnection ();
    } catch (IOException e1) {
    }
    connection.setRequestProperty ("Connection", "close");
    connection.setConnectTimeout (100000);
    try {
        connection.connect ();
    } catch (IOException e) {
    }
    try {
        if (connection.getResponseCode () == 200) {
            available = true;
        } else available = false;
    } catch (IOException e) {
        e.printStackTrace ();
    }
    return available;
}

public void isAvailable () {
    URL url = new URL ("URL HERE");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection ();
    connection.setRequestProperty ("Connection", "close");
    connection.setConnectTimeout (10000);
    connection.connect ();
    if (connection.getResponseCode () == 200) {
        return true;
    } else return false;
}

}
