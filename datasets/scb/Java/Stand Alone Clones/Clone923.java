public class Clone923 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:40105094
*  Stack Overflow answer #:40106979
*  And Stack Overflow answer#:40305146
*/
private void initData () {
    testData = new ArrayList < EventStatus > ();
    testData.add (new EventStatus ("Mach-1", 1476950160000L, 1));
    testData.add (new EventStatus ("Mach-1", 1476952200000L, 2));
    testData.add (new EventStatus ("Mach-1", 1476964800000L, 4));
    testData.add (new EventStatus ("Mach-1", 1476966600000L, 3));
    testData.add (new EventStatus ("Mach-2", 1476943200000L, 1));
    testData.add (new EventStatus ("Mach-2", 1476946800000L, 4));
    testData.add (new EventStatus ("Mach-2", 1476954000000L, 2));
    testData.add (new EventStatus ("Mach-2", 1476955800000L, 1));
    testData.add (new EventStatus ("Mach-2", 1476973800000L, 3));
    testData.add (new EventStatus ("Mach-3", 1476959400000L, 2));
    testData.add (new EventStatus ("Mach-3", 1476966600000L, 1));
    testData.add (new EventStatus ("Mach-3", 1476970200000L, 4));
    testData.add (new EventStatus ("Mach-3", 1476972000000L, 1));
    testData.add (new EventStatus ("Mach-3", 1476986400000L, 2));
}

private void initData () {
    testData = new ArrayList < EventStatus > ();
    testData.add (new EventStatus ("Mach-1", 1477468500000L, 1, 0));
    testData.add (new EventStatus ("Mach-1", 1477472100000L, 2, 0));
    testData.add (new EventStatus ("Mach-1", 1477474200000L, 5, 0));
    testData.add (new EventStatus ("Mach-1", 1477476000000L, 3, 0));
    testData.add (new EventStatus ("Mach-1", 1477479600000L, 4, 0));
    testData.add (new EventStatus ("Mach-1", 1477486800000L, 1, 0));
    testData.add (new EventStatus ("Mach-2", 1477465200000L, 3, 1));
    testData.add (new EventStatus ("Mach-2", 1477472400000L, 2, 1));
    testData.add (new EventStatus ("Mach-2", 1477474200000L, 5, 1));
    testData.add (new EventStatus ("Mach-2", 1477476000000L, 2, 1));
    testData.add (new EventStatus ("Mach-2", 1477479600000L, 3, 1));
    testData.add (new EventStatus ("Mach-2", 1477486800000L, 4, 1));
    ArrayList < String > list = new ArrayList < > ();
    for (EventStatus eventStatus : testData) {
        if (list.contains (eventStatus.getName ())) continue;
        else list.add (eventStatus.getName ());
    }
    catArray = new String [list.size ()];
    catArray = list.toArray (catArray);
}

}
