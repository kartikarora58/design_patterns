package org.chainOfResponsibility;

public class WarnLogger extends Logger{
    WarnLogger(Logger nextLogger) {
        super(nextLogger);
    }

    public void doLog(LogType logType,String message)
    {
        if(logType == LogType.WARN)
            System.out.println("Warn "+ message);
        else
            super.doLog(logType,message);
    }
}
