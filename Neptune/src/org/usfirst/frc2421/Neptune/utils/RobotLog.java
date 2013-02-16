/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2421.Neptune.utils;

/**
 *
 * @author Driver
 */
public class RobotLog {
    
    private RobotLog() {
    }
    
    public static RobotLog getInstance() {
        return RobotLoggerHolder.INSTANCE;
    }
    
    private static class RobotLoggerHolder {

        private static final RobotLog INSTANCE = new RobotLog();
    }
}
