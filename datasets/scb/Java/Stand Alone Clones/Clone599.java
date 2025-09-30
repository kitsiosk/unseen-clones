public class Clone599 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:10647520
*  Stack Overflow answer #:40054204
*  And Stack Overflow answer#:10647639
*/
static String compress (String str) {
    StringBuilder stringBuilder = new StringBuilder ();
    char [] charArray = str.toCharArray ();
    int count = 1;
    char lastChar = 0;
    char nextChar = 0;
    lastChar = charArray [0];
    for (int i = 1;
    i < charArray.length; i ++) {
        nextChar = charArray [i];
        if (lastChar == nextChar) {
            count ++;
        } else {
            stringBuilder.append (count).append (lastChar);
            count = 1;
            lastChar = nextChar;
        }
    }
    stringBuilder.append (count).append (lastChar);
    String compressed = stringBuilder.toString ();
    return compressed;
}

public static String compress (String text) {
    String result = "";
    int index = 0;
    while (index < text.length ()) {
        char c = text.charAt (index);
        int count = count (text, index);
        if (count == 1) result += "" + c;
        else result += "" + count + c;
        index += count;
    }
    return result;
}

}
