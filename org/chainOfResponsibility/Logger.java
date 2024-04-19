package org.chainOfResponsibility;

// chain of responsibility design pattern
// user does not care who handles the request
public abstract class Logger {

    Logger nextLogger;

    Logger(Logger nextLogger)
    {
        this.nextLogger = nextLogger;
    }

    public void doLog(LogType logType,String message)
    {
        if(nextLogger!=null)
            nextLogger.doLog(logType,message);
    }
}
