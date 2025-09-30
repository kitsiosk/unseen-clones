public class Clone826 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:19552754
*  Stack Overflow answer #:35662562
*  And Stack Overflow answer#:19577808
*/
public int [] solution (String S, int [] P, int [] K) {
    char [] sc = S.toCharArray ();
    int [] A = new int [sc.length];
    int [] G = new int [sc.length];
    int [] C = new int [sc.length];
    int prevA = - 1, prevG = - 1, prevC = - 1;
    for (int i = 0;
    i < sc.length; i ++) {
        if (sc [i] == 'A') prevA = i;
        else if (sc [i] == 'G') prevG = i;
        else if (sc [i] == 'C') prevC = i;
        A [i] = prevA;
        G [i] = prevG;
        C [i] = prevC;
    }
    int [] result = new int [P.length];
    for (int i = 0;
    i < P.length; i ++) {
        if (A [K [i]] >= P [i] && A [K [i]] <= K [i]) {
            result [i] = 1;
        } else if (C [K [i]] >= P [i] && C [K [i]] <= K [i]) {
            result [i] = 2;
        } else if (G [K [i]] >= P [i] && G [K [i]] <= K [i]) {
            result [i] = 3;
        } else {
            result [i] = 4;
        }
    }
    return result;
}

public int [] solution (String S, int [] P, int [] Q) {
    int [] answer = new int [P.length];
    char [] chars = S.toCharArray ();
    int [] [] cumulativeAnswers = new int [4] [chars.length + 1];
    for (int iii = 0;
    iii < chars.length; iii ++) {
        if (iii > 0) {
            for (int zzz = 0;
            zzz < 4; zzz ++) {
                cumulativeAnswers [zzz] [iii + 1] = cumulativeAnswers [zzz] [iii];
            }
        }
        switch (chars [iii]) {
            case 'A' :
                cumulativeAnswers [0] [iii + 1] ++;
                break;
            case 'C' :
                cumulativeAnswers [1] [iii + 1] ++;
                break;
            case 'G' :
                cumulativeAnswers [2] [iii + 1] ++;
                break;
            case 'T' :
                cumulativeAnswers [3] [iii + 1] ++;
                break;
        }
    }
    for (int iii = 0;
    iii < P.length; iii ++) {
        for (int zzz = 0;
        zzz < 4; zzz ++) {
            if ((cumulativeAnswers [zzz] [Q [iii] + 1] - cumulativeAnswers [zzz] [P [iii]]) > 0) {
                answer [iii] = zzz + 1;
                break;
            }
        }
    }
    return answer;
}

}
