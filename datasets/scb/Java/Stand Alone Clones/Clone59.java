public class Clone59 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2952732
*  Stack Overflow answer #:2976368
*  And Stack Overflow answer#:2954773
*/
public static void main (String [] args) {
    try {
        File file = new File ("company.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance ();
        DocumentBuilder db = dbf.newDocumentBuilder ();
        Document doc = db.parse (file);
        doc.getDocumentElement ().normalize ();
        NodeList nodeLst = doc.getElementsByTagName ("employee");
        for (int s = 0;
        s < nodeLst.getLength (); s ++) {
            Node fstNode = nodeLst.item (s);
            if (fstNode.getNodeType () == Node.ELEMENT_NODE) {
                Element fstElmnt = (Element) fstNode;
                NodeList fstNmElmntLst = fstElmnt.getElementsByTagName ("firstname");
                Element fstNmElmnt = (Element) fstNmElmntLst.item (0);
                NodeList fstNm = fstNmElmnt.getChildNodes ();
                System.out.println ("First Name: " + ((Node) fstNm.item (0)).getNodeValue ());
                NodeList lstNmElmntLst = fstElmnt.getElementsByTagName ("lastname");
                Element lstNmElmnt = (Element) lstNmElmntLst.item (0);
                NodeList lstNm = lstNmElmnt.getChildNodes ();
                System.out.println ("Last Name: " + ((Node) lstNm.item (0)).getNodeValue ());
            }
        }
    } catch (Exception e) {
        e.printStackTrace ();
    }
}

public static void main (String [] args) {
    List < String > keywords = Arrays.asList ("Apple", "Ananas", "Mango", "Banana", "Beer");
    Map < Character, List < String > > result = new HashMap < Character, List < String > > ();
    for (String k : keywords) {
        char firstChar = k.charAt (0);
        if (! result.containsKey (firstChar)) {
            result.put (firstChar, new ArrayList < String > ());
        }
        result.get (firstChar).add (k);
    }
    for (List < String > list : result.values ()) {
        Collections.sort (list);
    }
    System.out.println (result);
}

}
