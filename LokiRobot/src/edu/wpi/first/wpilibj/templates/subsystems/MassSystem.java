/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableGyro;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Giang
 */
public class MassSystem extends Subsystem {

    CANJaguar massJaguar;
    public SendableGyro massGyro;

    public MassSystem() {
        boolean caughtException = true;
        while (caughtException) {
            try {
                massJaguar = new CANJaguar(RobotMap.massSlot);
                massJaguar.setExpiration(Double.MAX_VALUE);
                caughtException = false;
            } catch (CANTimeoutException ex) {
            }
        }
        massGyro = new SendableGyro(2);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void moveMass(double speed) {
        try {
            massJaguar.setX(speed);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    public void massForward() {
        try {
            massJaguar.setX(0.25);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    public void massBackward() {
        try {
            massJaguar.setX(-0.25);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    public void stopMass() {
        try {
            massJaguar.setX(0);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    public double getMassSpeed() {
        try {
            return massJaguar.getSpeed();
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
            return 0;
        }
    }
}
