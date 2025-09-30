public class Clone122 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:7541843
*  Stack Overflow answer #:7541875
*  And Stack Overflow answer#:51843316
*/
private static void removeComments (Node node) {
    for (int i = 0;
    i < node.childNodesSize ();) {
        Node child = node.childNode (i);
        if (child.nodeName ().equals ("#comment")) child.remove ();
        else {
            removeComments (child);
            i ++;
        }
    }
}

private void removeComments (Element article) {
    article.filter (new NodeFilter () {
        @Override
        public FilterResult tail (Node node, int depth) {
            if (node instanceof Comment) {
                return FilterResult.REMOVE;
            }
            return FilterResult.CONTINUE;
        }@Override
        public FilterResult head (Node node, int depth) {
            if (node instanceof Comment) {
                return FilterResult.REMOVE;
            }
            return FilterResult.CONTINUE;
        }}
    );
}

}
