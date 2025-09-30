public class Clone889 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:14617
*  Stack Overflow answer #:18975867
*  And Stack Overflow answer#:2690861
*/
public static void main (String [] args) {
    SendMyFiles sendMyFiles = new SendMyFiles ();
    if (args.length < 1) {
        System.err.println ("Usage: java " + sendMyFiles.getClass ().getName () + " Properties_file File_To_FTP ");
        System.exit (1);
    }
    String propertiesFile = args [0].trim ();
    String fileToFTP = args [1].trim ();
    sendMyFiles.startFTP (propertiesFile, fileToFTP);
}

public static void main (String args []) {
    JSch jsch = new JSch ();
    Session session = null;
    try {
        session = jsch.getSession ("username", "127.0.0.1", 22);
        session.setConfig ("StrictHostKeyChecking", "no");
        session.setPassword ("password");
        session.connect ();
        Channel channel = session.openChannel ("sftp");
        channel.connect ();
        ChannelSftp sftpChannel = (ChannelSftp) channel;
        sftpChannel.get ("remotefile.txt", "localfile.txt");
        sftpChannel.exit ();
        session.disconnect ();
    } catch (JSchException e) {
        e.printStackTrace ();
    } catch (SftpException e) {
        e.printStackTrace ();
    }
}

}
