public class Clone23 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:12591264
*  Stack Overflow answer #:12591381
*  And Stack Overflow answer#:12591405
*/
public double getSum () {
    if (subAccounts != null) {
        Double sum = 0.0;
        for (int i = 0;
        i < subAccounts.size (); i ++) {
            sum += subAccounts.get (i).getSum ();
        }
        return amount + sum;
    } else {
        return amount;
    }
}

public double getSum () {
    double result = this.amount;
    if (this.subAccounts != null) {
        for (Balance subAccount : this.subAccounts) {
            result = result + subAccount.getSum ();
        }
    }
    return result;
}

}
