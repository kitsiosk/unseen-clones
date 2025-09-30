public class Clone744 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:7585699
*  Stack Overflow answer #:40766409
*  And Stack Overflow answer#:7616206
*/
public static void main (String args []) throws Exception {
    out.println ("****************************************");
    out.println ("DATE INFO");
    printCurrentTime ();
    out.println ("");
    out.println ("****************************************");
    out.println ("JVM COMMAND LINE ARGUMENTS");
    printCommandLineArguments ();
    out.println ("");
    out.println ("****************************************");
    out.println ("ENVIRONMENT");
    printSystemEnvironment ();
    out.println ("");
    out.println ("****************************************");
    out.println ("SYSTEM PROPERTIES");
    printSystemProperties ();
    out.println ("");
    out.println ("****************************************");
    out.println ("CLASS LOADER");
    printClassLoaderInfo ();
    out.println ("");
    out.println ("****************************************");
    out.println ("OPERATING SYSTEM");
    printOSInfo ();
    out.println ("");
    out.println ("****************************************");
    out.println ("MEMORY");
    printRuntimeMemory ();
    out.println ("");
    out.println ("****************************************");
    out.println ("CPU");
    printCPUUsage ();
    out.println ("");
    out.println ("****************************************");
    out.println ("DISK");
    printDiskInfo ();
    out.println ("");
    out.println ("****************************************");
    out.println ("NETWORK");
    printNetworkInfo ();
    out.println ("");
    out.println ("****************************************");
    out.println ("SECURITY");
    printSecurityInfo ();
    out.println ("");
    out.println ("");
    out.println ("****************************************");
    out.println ("LOG");
    printLoggingInfo ();
    out.println ("");
    out.println ("****************************************");
    out.println ("KEY MANAGER");
    printKeyManagerInfo ();
    out.println ("");
    out.println ("****************************************");
    out.println ("DISPLAY DEVICES");
    printDisplayInfo ();
    out.println ("");
    out.println ("****************************************");
    out.println ("FONTS");
    printFontsInfo ();
    out.println ("");
    out.println ("****************************************");
    out.println ("LOCALES");
    printLocaleInfo ();
}

public static void main (String [] args) {
    Runnable r = () -> {
        MediaTypes mediaTypes = new MediaTypes ();
        JPanel p = new JPanel ();
        mediaTypes.createGui (p);
        JOptionPane.showMessageDialog (null, p);
    };
    SwingUtilities.invokeLater (r);
}

}
