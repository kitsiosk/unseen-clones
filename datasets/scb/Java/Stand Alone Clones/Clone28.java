public class Clone28 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:18765197
*  Stack Overflow answer #:18765466
*  And Stack Overflow answer#:18765584
*/
public void manage () {
    double speed = getSpeedfromVehicle ();
    if ((speed >= 0 && speed <= 10) && state != SpeedState.LOW) {
        state = SpeedState.LOW;
        System.out.println ("Low Speed mode");
    } else if ((speed > 10 && speed < 60) && state != SpeedState.MEDIUM) {
        state = SpeedState.MEDIUM;
        System.out.println ("Medium Speed Mode");
    } else if ((speed >= 60) && state != SpeedState.HIGH) {
        state = SpeedState.HIGH;
        System.out.println ("High Speed Mode");
    }
}

public Speedo manage (int speed) {
    if (speed < getLowRange ()) {
        onLowTransition ();
        return getLowState ();
    } else if (speed > getHighRange ()) {
        onHighTransition ();
        return getHighState ();
    } else {
        return this;
    }
}

}
