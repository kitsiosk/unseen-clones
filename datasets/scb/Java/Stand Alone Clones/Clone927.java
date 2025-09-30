public class Clone927 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:2680958
*  Stack Overflow answer #:15070889
*  And Stack Overflow answer#:2770163
*/
public void invoke (Request request, Response response) throws IOException, ServletException {
    getNext ().invoke (request, response);
    Session session = null;
    try {
        session = request.getSessionInternal ();
    } catch (Throwable e) {
        log.error (getInfo () + ": Unable to perform replication request.", e);
    }
    String context = request.getContext ().getName ();
    String task = request.getPathInfo ();
    if (task == null) {
        task = request.getRequestURI ();
    }
    if (session != null) {
        if (log.isDebugEnabled ()) {
            log.debug (getInfo () + ": [session=" + session.getId () + ", instanceof=" + session.getClass ().getName () + ", context=" + context + ", request=" + task + "]");
        }
        List < String > cycledNames = new LinkedList < String > ();
        HttpSession deltaSession = (HttpSession) session;
        for (Enumeration < String > names = deltaSession.getAttributeNames ();
        names.hasMoreElements ();) {
            String name = names.nextElement ();
            deltaSession.setAttribute (name, deltaSession.getAttribute (name));
            cycledNames.add (name);
        }
        if (log.isDebugEnabled ()) {
            log.debug (getInfo () + ": [session=" + session.getId () + ", context=" + context + ", request=" + task + "] cycled atrributes=" + cycledNames + "");
        }
    } else {
        String id = request.getRequestedSessionId ();
        log.warn (getInfo () + ": [session=" + id + ", context=" + context + ", request=" + task + "] Session not available, unable to send session over cluster.");
    }
}

public void invoke (Request request, Response response) throws IOException, ServletException {
    getNext ().invoke (request, response);
    Session session = null;
    try {
        session = request.getSessionInternal ();
    } catch (Throwable e) {
        log.error (getInfo () + ": Unable to perform replication request.", e);
    }
    String context = request.getContext ().getName ();
    String task = request.getPathInfo ();
    if (task == null) {
        task = request.getRequestURI ();
    }
    if (session != null) {
        if (log.isDebugEnabled ()) {
            log.debug (getInfo () + ": [session=" + session.getId () + ", instanceof=" + session.getClass ().getName () + ", context=" + context + ", request=" + task + "]");
        }
        if (session instanceof ReplicatedSession) {
            ((ReplicatedSession) session).setIsDirty (true);
            if (log.isDebugEnabled ()) {
                log.debug (getInfo () + ": [session=" + session.getId () + ", context=" + context + ", request=" + task + "] maked DIRTY");
            }
        } else {
            List cycledNames = new LinkedList ();
            HttpSession deltaSession = (HttpSession) session;
            for (Enumeration < String > names = deltaSession.getAttributeNames ();
            names.hasMoreElements ();) {
                String name = names.nextElement ();
                deltaSession.setAttribute (name, deltaSession.getAttribute (name));
                cycledNames.add (name);
            }
            if (log.isDebugEnabled ()) {
                log.debug (getInfo () + ": [session=" + session.getId () + ", context=" + context + ", request=" + task + "] cycled atrributes=" + cycledNames + "");
            }
        }
    } else {
        String id = request.getRequestedSessionId ();
        log.warn (getInfo () + ": [session=" + id + ", context=" + context + ", request=" + task + "] Session not available, unable to send session over cluster.");
    }
}

}
