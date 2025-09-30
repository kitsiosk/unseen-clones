public class Clone9 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:43534441
*  Stack Overflow answer #:43534542
*  And Stack Overflow answer#:43534622
*/
public static boolean longerTF (boolean [] guess) {
    int consecutiveVariableTrue = 0, maxConsecutiveVariableTrue = 0;
    int consecutiveVariableFalse = 0, maxConsecutiveVariableFalse = 0;
    for (int x = 0;
    x < guess.length; x ++) {
        if (guess [x] == true) {
            consecutiveVariableTrue ++;
            if (maxConsecutiveVariableTrue < consecutiveVariableTrue) maxConsecutiveVariableTrue = consecutiveVariableTrue;
        } else {
            consecutiveVariableTrue = 0;
        }
    }
    for (int x = 0;
    x < guess.length; x ++) {
        if (guess [x] == false) {
            consecutiveVariableFalse ++;
            if (maxConsecutiveVariableFalse < consecutiveVariableFalse) maxConsecutiveVariableFalse = consecutiveVariableFalse;
        } else {
            consecutiveVariableFalse = 0;
        }
    }
    if (maxConsecutiveVariableTrue >= maxConsecutiveVariableFalse) {
        return true;
    }
    return false;
}

public static boolean longerTF (boolean [] guess) {
    int variableTrue = 0;
    int variableFalse = 0;
    for (int x = 0;
    x < guess.length; x ++) {
        if (guess [x]) {
            variableTrue ++;
        } else {
            variableFalse ++;
        }
    }
    return variableTrue >= variableFalse;
}

}
