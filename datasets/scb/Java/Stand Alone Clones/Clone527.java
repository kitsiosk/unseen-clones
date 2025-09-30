public class Clone527 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:8638882
*  Stack Overflow answer #:8639081
*  And Stack Overflow answer#:8639119
*/
public void refund (float balance) {
    System.out.println ("You have selected the refund option:");
    for (int counter = (int) balance;
    counter >= 10; counter -= 10) {
        System.out.println ("Balance: £" + balance);
        balance -= 10;
    }
    for (int counter = (int) balance;
    counter > 0; counter -= 1) {
        System.out.println ("Balance: £" + balance);
        balance -= 1;
    }
    System.out.println ("Balance: £" + balance);
}

public void refund (int balance) {
    while (balance >= 10) {
        System.out.println ("Balance: £" + balance);
        balance -= 10;
    }
    while (balance >= 0) {
        System.out.println ("Balance: £" + balance);
        balance -= 1;
    }
}

}
