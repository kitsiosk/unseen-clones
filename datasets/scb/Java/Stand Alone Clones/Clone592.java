public class Clone592 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:38067339
*  Stack Overflow answer #:38094625
*  And Stack Overflow answer#:38111406
*/
public static void main (String [] args) {
    boolean ObjectID = false;
    boolean Class = false;
    boolean LastChangedBy = false;
    boolean Number = false;
    boolean StartEffectivity = false;
    boolean EndEffectivity = false;
    boolean StartSerialNumberEffectivity = false;
    boolean EndSerialNumberEffectivity = false;
    boolean StartLotNumberEffectivity = false;
    boolean EndLotNumberEffectivity = false;
    boolean SerialNumberEffectivityCxtPartNumber = false;
    boolean LotNumberEffectivityCxtPartNumber = false;
    boolean DefaultUnit = false;
    boolean Name = false;
    boolean PartType = false;
    boolean Source = false;
    boolean State = false;
    boolean IsPhantom = false;
    boolean Version = false;
    boolean Iteration = false;
    boolean PreviousVersion = false;
    boolean IsConfigurable = false;
    boolean IsCollapsible = false;
    boolean TargetID = false;
    try {
        XMLInputFactory factory = XMLInputFactory.newInstance ();
        XMLEventReader eventReader = factory.createXMLEventReader (new FileReader ("c:\\staxTestFile.xml"));
        while (eventReader.hasNext ()) {
            XMLEvent event = eventReader.nextEvent ();
            switch (event.getEventType ()) {
                case XMLStreamConstants.START_ELEMENT :
                    StartElement startElement = event.asStartElement ();
                    String qName = startElement.getName ().getLocalPart ();
                    if (qName.equalsIgnoreCase ("Part")) {
                        System.out.println ("Start Element : Part");
                        Iterator < Attribute > attributes = startElement.getAttributes ();
                    } else if (qName.equalsIgnoreCase ("ObjectID")) {
                        ObjectID = true;
                    } else if (qName.equalsIgnoreCase ("Class")) {
                        Class = true;
                    } else if (qName.equalsIgnoreCase ("LastChangedBy")) {
                        LastChangedBy = true;
                    } else if (qName.equalsIgnoreCase ("Number")) {
                        Number = true;
                    } else if (qName.equalsIgnoreCase ("StartEffectivity")) {
                        StartEffectivity = true;
                    } else if (qName.equalsIgnoreCase ("EndSerialNumberEffectivity")) {
                        EndSerialNumberEffectivity = true;
                    } else if (qName.equalsIgnoreCase ("StartSerialNumberEffectivity")) {
                        StartSerialNumberEffectivity = true;
                    } else if (qName.equalsIgnoreCase ("EndSerialNumberEffectivity")) {
                        EndSerialNumberEffectivity = true;
                    } else if (qName.equalsIgnoreCase ("StartLotNumberEffectivity")) {
                        StartLotNumberEffectivity = true;
                    } else if (qName.equalsIgnoreCase ("EndLotNumberEffectivity")) {
                        EndLotNumberEffectivity = true;
                    } else if (qName.equalsIgnoreCase ("SerialNumberEffectivityCxtPartNumber")) {
                        SerialNumberEffectivityCxtPartNumber = true;
                    } else if (qName.equalsIgnoreCase ("LotNumberEffectivityCxtPartNumber")) {
                        LotNumberEffectivityCxtPartNumber = true;
                    } else if (qName.equalsIgnoreCase ("DefaultUnit")) {
                        DefaultUnit = true;
                    } else if (qName.equalsIgnoreCase ("Name")) {
                        Name = true;
                    } else if (qName.equalsIgnoreCase ("PartType")) {
                        PartType = true;
                    } else if (qName.equalsIgnoreCase ("Source")) {
                        Source = true;
                    } else if (qName.equalsIgnoreCase ("State")) {
                        State = true;
                    } else if (qName.equalsIgnoreCase ("IsPhantom")) {
                        IsPhantom = true;
                    } else if (qName.equalsIgnoreCase ("Version")) {
                        Version = true;
                    } else if (qName.equalsIgnoreCase ("Iteration")) {
                        Iteration = true;
                    } else if (qName.equalsIgnoreCase ("PreviousVersion")) {
                        PreviousVersion = true;
                    } else if (qName.equalsIgnoreCase ("IsConfigurable")) {
                        IsConfigurable = true;
                    } else if (qName.equalsIgnoreCase ("IsCollapsible")) {
                        IsCollapsible = true;
                    } else if (qName.equalsIgnoreCase ("TargetID")) {
                        TargetID = true;
                    }
                    break;
                case XMLStreamConstants.CHARACTERS :
                    Characters characters = event.asCharacters ();
                    if (ObjectID) {
                        System.out.println ("ObjectID: " + characters.getData ());
                        ObjectID = false;
                    }
                    if (Class) {
                        System.out.println ("Class: " + characters.getData ());
                        Class = false;
                    }
                    if (LastChangedBy) {
                        System.out.println ("LastChangedBy " + characters.getData ());
                        LastChangedBy = false;
                    }
                    if (Number) {
                        System.out.println ("Number: " + characters.getData ());
                        Number = false;
                    }
                    if (StartEffectivity) {
                        System.out.println ("StartEffectivity: " + characters.getData ());
                        StartEffectivity = false;
                    }
                    if (EndEffectivity) {
                        System.out.println ("EndEffectivity " + characters.getData ());
                        EndEffectivity = false;
                    }
                    if (StartSerialNumberEffectivity) {
                        System.out.println ("StartSerialNumberEffectivity " + characters.getData ());
                        StartSerialNumberEffectivity = false;
                    }
                    if (EndSerialNumberEffectivity) {
                        System.out.println ("EndSerialNumberEffectivity: " + characters.getData ());
                        EndSerialNumberEffectivity = false;
                    }
                    if (StartLotNumberEffectivity) {
                        System.out.println ("StartLotNumberEffectivity" + characters.getData ());
                        StartLotNumberEffectivity = false;
                    }
                    if (EndLotNumberEffectivity) {
                        System.out.println ("EndLotNumberEffectivity: " + characters.getData ());
                        EndLotNumberEffectivity = false;
                    }
                    if (SerialNumberEffectivityCxtPartNumber) {
                        System.out.println ("SerialNumberEffectivityCxtPartNumber " + characters.getData ());
                        SerialNumberEffectivityCxtPartNumber = false;
                    }
                    if (LotNumberEffectivityCxtPartNumber) {
                        System.out.println ("LotNumberEffectivityCxtPartNumber: " + characters.getData ());
                        LotNumberEffectivityCxtPartNumber = false;
                    }
                    if (DefaultUnit) {
                        System.out.println ("DefaultUnit: " + characters.getData ());
                        DefaultUnit = false;
                    }
                    if (Name) {
                        System.out.println ("Name: " + characters.getData ());
                        Name = false;
                    }
                    if (PartType) {
                        System.out.println ("PartType: " + characters.getData ());
                        PartType = false;
                    }
                    if (Source) {
                        System.out.println ("Source: " + characters.getData ());
                        Source = false;
                    }
                    if (State) {
                        System.out.println ("State: " + characters.getData ());
                        State = false;
                    }
                    if (IsPhantom) {
                        System.out.println ("IsPhantom: " + characters.getData ());
                        IsPhantom = false;
                    }
                    if (Version) {
                        System.out.println ("Version: " + characters.getData ());
                        Version = false;
                    }
                    if (Iteration) {
                        System.out.println ("Iteration: " + characters.getData ());
                        Iteration = false;
                    }
                    if (PreviousVersion) {
                        System.out.println ("PreviousVersion: " + characters.getData ());
                        PreviousVersion = false;
                    }
                    if (IsConfigurable) {
                        System.out.println ("IsConfigurable: " + characters.getData ());
                        IsConfigurable = false;
                    }
                    if (IsCollapsible) {
                        System.out.println ("IsCollapsible: " + characters.getData ());
                        IsCollapsible = false;
                    }
                    if (TargetID) {
                        System.out.println ("TargetID: " + characters.getData ());
                        TargetID = false;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT :
                    EndElement endElement = event.asEndElement ();
                    if (endElement.getName ().getLocalPart ().equalsIgnoreCase ("Part")) {
                        System.out.println ("End Element : Part");
                        System.out.println ();
                    }
                    break;
            }
        }
    } catch (Exception e) {
        e.printStackTrace ();
    }
}

public static void main (String [] s) throws VTDException {
    VTDGen vg = new VTDGen ();
    AutoPilot ap = new AutoPilot ();
    ap.selectXPath ("//part/*[text()]");
    if (! vg.parseFile ("d:\\xml\\soap.xml", false)) {
        System.out.println ("invalid xml");
        System.exit (0);
    }
    VTDNav vn = vg.getNav ();
    ap.bind (vn);
    int i = 0;
    while ((i = ap.evalXPath ()) != - 1) {
        System.out.println (" " + vn.toRawString (i) + " = " + vn.toNormalizedString (vn.getText ()));
    }
}

}
