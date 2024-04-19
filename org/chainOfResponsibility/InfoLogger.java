package org.chainOfResponsibility;

public class InfoLogger extends Logger {

    InfoLogger(Logger nextLogger)
    {
        super(nextLogger);
    }
    public void doLog(LogType logType,String message)
    {
        if(logType == LogType.INFO)
            System.out.println("Warn "+ message);
        else
            super.doLog(logType,message);
    }
}
