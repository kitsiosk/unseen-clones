public class Clone719 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:21884720
*  Stack Overflow answer #:21884799
*  And Stack Overflow answer#:21885525
*/
public static void main (String args []) throws IOException {
    BufferedReader dataIn = new BufferedReader (new InputStreamReader (System.in));
    String strSize, strGrades;
    int laki = 100;
    int totalGrades = 0;
    float gradeAverage = 0;
    float [] grades = new float [laki];
    System.out.print ("How many grades will you enter?");
    strSize = dataIn.readLine ();
    laki = Integer.parseInt (strSize);
    grades = new float [laki];
    for (int i = 0;
    i < laki; i ++) {
        System.out.print ("Please enter grade # " + (i + 1) + ": ");
        strGrades = dataIn.readLine ();
        grades [i] = Float.parseFloat (strGrades);
        totalGrades += grades [i];
    }
    gradeAverage = totalGrades / laki;
    System.out.println ("Your grades average is " + gradeAverage);
}

public static void main (String args []) throws IOException {
    BufferedReader dataIn = new BufferedReader (new InputStreamReader (System.in));
    int totalGrades = 0;
    float gradeAverage = 0;
    System.out.print ("How many grades will you enter?");
    int laki = Integer.parseInt (dataIn.readLine ());
    float [] grades = new float [laki];
    int count = 0;
    while (laki > 0) {
        System.out.print ("Please enter grade # " + (count + 1) + ": ");
        grades [count] = Float.parseFloat (dataIn.readLine ());
        totalGrades += grades [count];
        laki --;
        count ++;
    }
    gradeAverage = (float) totalGrades / count;
    System.out.println ("Your grades average is " + gradeAverage);
}

}
