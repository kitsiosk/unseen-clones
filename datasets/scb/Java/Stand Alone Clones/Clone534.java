public class Clone534 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2811001
*  Stack Overflow answer #:24910935
*  And Stack Overflow answer#:36320331
*/
public static void main (String [] args) {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance ();
    factory.setNamespaceAware (true);
    DocumentBuilder builder;
    Document doc = null;
    try {
        builder = factory.newDocumentBuilder ();
        doc = builder.parse ("employees.xml");
        XPathFactory xpathFactory = XPathFactory.newInstance ();
        XPath xpath = xpathFactory.newXPath ();
        String name = getEmployeeNameById (doc, xpath, 4);
        System.out.println ("Employee Name with ID 4: " + name);
        List < String > names = getEmployeeNameWithAge (doc, xpath, 30);
        System.out.println ("Employees with 'age>30' are:" + Arrays.toString (names.toArray ()));
        List < String > femaleEmps = getFemaleEmployeesName (doc, xpath);
        System.out.println ("Female Employees names are:" + Arrays.toString (femaleEmps.toArray ()));
    } catch (ParserConfigurationException | SAXException | IOException e) {
        e.printStackTrace ();
    }
}

public static void main (String s []) throws VTDException, java.io.UnsupportedEncodingException, java.io.IOException {
    VTDGen vg = new VTDGen ();
    if (! vg.parseFile ("input.xml", false)) return;
    VTDNav vn = vg.getNav ();
    AutoPilot ap = new AutoPilot (vn);
    XMLModifier xm = new XMLModifier (vn);
    ap.selectXPath ("/*/place[@id=\"p14\" and   @initialMarking=\"2\"]/@initialMarking");
    int i = 0;
    while ((i = ap.evalXPath ()) != - 1) {
        xm.updateToken (i + 1, "499");
    }
    xm.output ("new.xml");
}

}
