package com.learn.spring.mongo.springmongodbdemo.designpattern;

import lombok.extern.slf4j.Slf4j;

public class ChainOfResponsibility {
    public static void main(String[] args) {
        AbstractLogger logger = LoggerChain.getLoggingChain();
        logger.logMessage(LogginLevel.INFO);
    }
}

class LoggerChain {
    private LoggerChain() {}

    public static AbstractLogger getLoggingChain() {
        AbstractLogger errorLogging = new ErrorLogger(LogginLevel.ERROR);
        AbstractLogger debugLogging = new DebugLogging(LogginLevel.DEBUG);
        AbstractLogger infoLogging = new InfoLogging(LogginLevel.INFO);
        errorLogging.nextLogger(debugLogging);
        debugLogging.nextLogger(infoLogging);
        return errorLogging;
    }
}

abstract class AbstractLogger {
    private AbstractLogger nextLogger;
    protected int level;

    public void nextLogger(AbstractLogger logger) {
        this.nextLogger = logger;
    }

    public void logMessage(LogginLevel logginLevel) {
        if (logginLevel.getogLevel() <= this.level) {
            write();
        }
        if (null != nextLogger) nextLogger.logMessage(logginLevel);
    }

    protected abstract void write();

}

@Slf4j
class FileLogger extends AbstractLogger {

    public FileLogger(LogginLevel level) {
        this.level = level.getogLevel();
    }

    @Override
    protected void write() {
        log.info("Info level logging");
    }
}

@Slf4j
class ErrorLogger extends AbstractLogger {
    
    
    
    public ErrorLogger(LogginLevel level) {
        this.level = level.getogLevel();
    }

    @Override
    protected void write() {
        log.error("Error Level logging");
    }

}

@Slf4j
class DebugLogging extends AbstractLogger {
    
    public DebugLogging(LogginLevel level) {
        this.level = level.getogLevel();
    }

    @Override
    protected void write() {
        log.debug("Debug Level logging");
        
    } 
    
}

@Slf4j
class InfoLogging extends AbstractLogger {
    
    public InfoLogging(LogginLevel level) {
        this.level = level.getogLevel();
    }

    @Override
    protected void write() {
        log.debug("Info Level logging");
        
    } 
    
}

enum LogginLevel {
    INFO(1), DEBUG(2), ERROR(3);

    private int level;

    private LogginLevel(int level) {
        this.level = level;
    }

    public int getogLevel() {
        return this.level;
    }

}