public class Clone950 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:42113653
*  Stack Overflow answer #:42113735
*  And Stack Overflow answer#:42113902
*/
protected Node getTrueParent () {
    for (Edge e : this.edges) {
        if (e.getNode2 () == this && (! e.isPseudo ())) {
            Node parent = e.getNode1 ();
            return parent;
        }
    }
    return null;
}

protected Node getTrueParent () {
    if (getEdges () != null && ! getEdges ().isEmpty ()) {
        for (Edge e : getEdges ()) {
            if (e != null && e.getNode2 () == this && ! e.isPseudo ()) {
                return e.getNode1 ();
            }
        }
    }
    return null;
}

}
