package org.chainOfResponsibility;

public class Client {

    public static void main(String[] args) {
        Logger logger_  = new ErrorLogger(new InfoLogger(new WarnLogger(null)));
        logger_.doLog(LogType.WARN,"bhai warn aagya");
    }

}
