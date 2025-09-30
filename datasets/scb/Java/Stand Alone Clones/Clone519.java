public class Clone519 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:34150685
*  Stack Overflow answer #:34156322
*  And Stack Overflow answer#:34159302
*/
public void inOrder () {
    Stack < BSTNode > myStack = new Stack < BSTNode > ();
    Set < BSTNode > visited = new HashSet < BSTNode > ();
    BSTNode current = m_root;
    if (current != null) myStack.push (current);
    while (! myStack.isEmpty ()) {
        current = myStack.peek ();
        if (current.getLeft () != null && ! visited.contains (current.getLeft ())) myStack.push (current.getLeft ());
        else {
            System.out.print (current.getInfo () + " ");
            visited.add (current);
            myStack.pop ();
            if (current.getRight () != null && ! visited.contains (current.getRight)) myStack.push (current.getRight ());
        }
    }
}

public void inOrder () {
    if (m_root == null) {
        return;
    }
    Stack < BSTNode > myStack = new Stack < BSTNode > ();
    BSTNode current = m_root;
    while (current != null) {
        myStack.push (current);
        current = current.getLeft ();
    }
    while (! myStack.isEmpty ()) {
        current = (BSTNode) myStack.pop ();
        System.out.print (current.getInfo () + " ");
        if (current.getRight () != null) {
            current = current.getRight ();
            while (current != null) {
                myStack.push (current);
                current = current.getLeft ();
            }
        }
    }
}

}
