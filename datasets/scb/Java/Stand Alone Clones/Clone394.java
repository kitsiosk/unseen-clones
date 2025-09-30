public class Clone394 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:21491635
*  Stack Overflow answer #:24528115
*  And Stack Overflow answer#:21492113
*/
public void switchPairs () {
    ListNode prev = front;
    if (front != null && front.next != null) {
        ListNode temp = front;
        front = front.next;
        temp.next = front.next;
        front.next = temp;
        prev = temp;
    }
    while (prev != null && prev.next != null && prev.next.next != null) {
        ListNode first_node = prev.next;
        ListNode second_node = first_node.next;
        first_node.next = second_node.next;
        second_node.next = first_node;
        prev.next = second_node;
        prev = first_node;
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
