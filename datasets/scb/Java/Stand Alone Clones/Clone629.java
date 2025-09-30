public class Clone629 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:7704827
*  Stack Overflow answer #:19977544
*  And Stack Overflow answer#:46216808
*/
public static void main (String [] args) {
    Customer customer = new Customer ();
    customer.setId (100);
    customer.setName ("mkyong");
    customer.setAge (29);
    try {
        File file = new File ("C:\\file.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance (Customer.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller ();
        jaxbMarshaller.setProperty (Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal (customer, file);
        jaxbMarshaller.marshal (customer, System.out);
    } catch (JAXBException e) {
        e.printStackTrace ();
    }
}

public static void main (String [] args) throws ParserConfigurationException, SAXException, IOException, VerifyError {
    SAXParserFactory saxDoc = SAXParserFactory.newInstance ();
    SAXParser saxParser = saxDoc.newSAXParser ();
    DefaultHandler handler = new DefaultHandler () {
        String tmpElementName = null;
        String tmpElementValue = null;
        @Override
        public void startElement (String uri, String localName, String qName, Attributes attributes) throws SAXException {
            tmpElementValue = "";
            tmpElementName = qName;
            tmpAtrb = new HashMap ();
            for (int i = 0;
            i < attributes.getLength (); i ++) {
                String aname = attributes.getLocalName (i);
                String value = attributes.getValue (i);
                tmpAtrb.put (aname, value);
            }
        }@Override
        public void endElement (String uri, String localName, String qName) throws SAXException {
            if (tmpElementName.equals (qName)) {
                System.out.println ("Element Name :" + tmpElementName);
                for (Map.Entry < String, String > entrySet : tmpAtrb.entrySet ()) {
                    System.out.println ("Attribute Name :" + entrySet.getKey () + "Attribute Value :" + entrySet.getValue ());
                }
                System.out.println ("Element Value :" + tmpElementValue);
                xmlVal.put (tmpElementName, tmpElementValue);
                System.out.println (xmlVal);
                String getKeyValues = xmlVal.get (tmpElementName);
                System.out.println ("XmlTag:" + tmpElementName + ":::::" + "ValueFetchedFromTheMap:" + getKeyValues);
            }
        }@Override
        public void characters (char ch [], int start, int length) throws SAXException {
            tmpElementValue = new String (ch, start, length);
        }}
    ;
    saxParser.parse (new File ("D:/Test _ XML/file.xml"), handler);
}

}
