package org.usfirst.frc2421.Neptune.utils;

import com.sun.squawk.VM;
import java.io.IOException;
import java.io.PrintStream;
import javax.microedition.io.Connector;

/**
 *
 * @author Driver
 */
public class RobotLog {

    private RobotLog() {
        level = readLogLevel();
        out = writeLogLevel(level);
    }
    public static final int NONE = 0;
    public static final int INFO = 1;
    public static final int WARNING = 2;
    public static final int VERBOSE = 3;
    public static final int DEBUG = 4;
    public final PrintStream out;
    public final int level;

    private int readLogLevel() {
        int newlevel = 0;
        String prop = System.getProperty("squawk.debugger.log.level");
        if (prop != null) {
            if (prop.equals("none")) {
                newlevel = 0;
            } else if (prop.equals("info")) {
                newlevel = 1;
            } else if (prop.equals("verbose")) {
                newlevel = 2;
            } else if (prop.equals("debug")) {
                if (VM.isHosted()) {
                    newlevel = 3;
                } else {
                    newlevel = 3;
                }
            } else {
                System.err.println("logging disabled - invalid log level in "
                        + "squawk.debugger.log.level system property: " + prop);
            }
        }
        return newlevel;
    }

    private PrintStream writeLogLevel(int level) {
        PrintStream newout = System.out;
        if (level != 0) {
            System.err.println("logging level: " + level);
            String prop = System.getProperty("squawk.debugger.log.url");
            if (prop != null) {
                try {
                    newout = new PrintStream(Connector.openOutputStream(prop));
                    System.err.println("logging to " + prop);
                } catch (IOException e) {
                    System.err.println("logging to System.out - exception while opening log stream: " + prop);
                    e.printStackTrace();
                }
            } else {
                System.err.println("logging to System.out");
            }
        }
        return newout;
    }

    public boolean info() {
        return level >= 1;
    }

    public boolean verbose() {
        return level >= 2;
    }

    public boolean debug() {
        return (VM.isHosted()) && (level >= 3);
    }

    public void log(String msg) {
        if (out != null) {
            String message = "[Thread " + Thread.currentThread().getName() + "] " + msg;
            out.println(message);
            out.flush();
        }
    }

    public static RobotLog getInstance() {
        return RobotLogHolder.INSTANCE;
    }

    private static class RobotLogHolder {
        private static final RobotLog INSTANCE = new RobotLog();
    }
}
