// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.


package org.usfirst.frc2421.Neptune.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2421.Neptune.RobotMap;
import org.usfirst.frc2421.Neptune.commands.TeleDrive;


/**
 * TODO Description
 */
public class DriveSystem extends Subsystem {

    CANJaguar cANJaguarLeft = RobotMap.driveSystemCANJaguarLeft;
    CANJaguar cANJaguarRight = RobotMap.driveSystemCANJaguarRight;

    public void initDefaultCommand() {
        setDefaultCommand(new TeleDrive()); //This might conflict with automode

        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    /**
     * TODO Description
     * @param leftSpeed
     * @param rightSpeed 
     */
    public void runMotors(double leftSpeed, double rightSpeed) {
        try {
            cANJaguarLeft.setX(leftSpeed);
            cANJaguarRight.setX(rightSpeed);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }

    }

    public void turnLeft(double speed) {
        runMotors(speed, 0);
    }

    public void turnRight(double speed) {
        runMotors(0, speed);
    }
    
    /**
     * TODO Description
     * @return 
     */
    public double[] getSpeeds(){
        double[] speeds = {0,0}; // Initializes a double array of two zeroes
        try {
            speeds[0] = cANJaguarLeft.getX();
            speeds[1] = cANJaguarRight.getX();
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        } finally {
            return speeds;
        }
