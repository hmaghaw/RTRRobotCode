/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2421.Neptune.utils;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Kal
 */
public class RobotUtils {

    public static void tryPutData(String key, Sendable data) {
        try {
            SmartDashboard.putData(key, data);
        } catch (NullPointerException e) {
            SmartDashboard.putString(key, "Failed");
        }

    }

    public static void tryPutData(String key, double data) {
        try {
            SmartDashboard.putNumber(key, data);
        } catch (NullPointerException e) {
            SmartDashboard.putString(key, "Failed");
        }
    }
}
