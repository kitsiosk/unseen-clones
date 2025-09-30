public class Clone201 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2052563
*  Stack Overflow answer #:46520671
*  And Stack Overflow answer#:46520671
*/
public void mirroeView () {
    BSTNode node = mirroeView (root);
    preorder (node);
    System.out.println ();
    inorder (node);
    System.out.println ();
    postorder (node);
    System.out.println ();
}

private BSTNode mirroeView (BSTNode node) {
    if (node == null || (node.left == null && node.rigth == null)) return node;
    BSTNode temp = node.left;
    node.left = node.rigth;
    node.rigth = temp;
    mirroeView (node.left);
    mirroeView (node.rigth);
    return node;
}

}
