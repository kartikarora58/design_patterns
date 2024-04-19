package org.chainOfResponsibility;

public class ErrorLogger extends Logger{
    ErrorLogger(Logger nextLogger) {
        super(nextLogger);
    }

    public void doLog(LogType logType,String message)
    {
        if(logType == LogType.ERROR)
            System.out.println("ERROR "+ message);
        else
            super.doLog(logType,message);
    }
}
