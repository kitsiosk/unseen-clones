public class Clone395 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:21491635
*  Stack Overflow answer #:21492296
*  And Stack Overflow answer#:21492113
*/
public void switchPairs () {
    if (front == null || front.next == null) return;
    ListNode current = front.next;
    front.next = current.next;
    current.next = front;
    front = current;
    current = current.next;
    while (current.next != null && current.next.next != null) {
        ListNode temp = current.next.next;
        current.next.next = temp.next;
        temp.next = current.next;
        current.next = temp;
        current = temp.next;
    }
}

public ListNode switchPairs () {
    if (this == null || this.next == null) return this;
    ListNode top = this.next;
    ListNode first = this;
    ListNode second = first.next;
    do {
        ListNode third = second.next;
        second.next = first;
        first.next = third;
        first = third;
        System.out.println ("@@@ " + this.toString ());
        if (first != null) {
            second.next.next = first.next;
            second = first.next;
        }
    } while (first != null && second != null);
    return top;
}

}
