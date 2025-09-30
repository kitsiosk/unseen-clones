public class Clone520 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:1919059
*  Stack Overflow answer #:1919074
*  And Stack Overflow answer#:1919067
*/
private byte [] readData (File f, int startByte, int chunkSize) throws Exception {
    RandomAccessFile raf = new RandomAccessFile (f, "r");
    raf.seek (startByte);
    byte [] data = new byte [chunkSize];
    int bytesRead = raf.read (data);
    if (bytesRead != chunkSize) {
        byte [] smallerData = new byte [bytesRead];
        System.arraycopy (data, 0, smallerData, 0, bytesRead);
        data = smallerData;
    }
    raf.close ();
    return data;
}

private byte [] readData (File f, int startByte, int chunkSize) throws Exception {
    RandomAccessFile raf = new RandomAccessFile (f, "r");
    raf.seek (startByte);
    byte [] data = new byte [chunkSize];
    int read = raf.read (data);
    raf.close ();
    if (read == data.length) return data;
    else return Arrays.copyOf (data, read);
}

}
