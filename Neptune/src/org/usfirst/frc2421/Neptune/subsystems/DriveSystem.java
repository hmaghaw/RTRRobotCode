package org.usfirst.frc2421.Neptune.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.tables.ITable;
import org.usfirst.frc2421.Neptune.RobotMap;
import org.usfirst.frc2421.Neptune.commands.drive.TeleDrive;


/**
 * This system is used to set and get the speeds of the drive motors
 * This is a constructor for the 2 CAN Jaguars used in the drive system
 */
public class DriveSystem extends Subsystem {

    public CANJaguar cANJaguarLeft = RobotMap.driveSystemCANJaguarLeft;
    public CANJaguar cANJaguarRight = RobotMap.driveSystemCANJaguarRight;

    public void initDefaultCommand() {
        setDefaultCommand(new TeleDrive()); //This might conflict with automode
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    /**
     * This method sets the speed of the drive motors based on the parameters
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
     * This method returns the speeds of the motors in the form of a double
     * array called speeds
     *
     * @return
     */
    public double[] getSpeeds() {
        double[] speeds = {0, 0}; // Initializes a double array of two zeroes
        try {
            speeds[0] = cANJaguarLeft.getX();
            speeds[1] = cANJaguarRight.getX();
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        return speeds;
    }
    
    public ITable getTable(){
        ITable table = super.getTable();
        
        
        
        return table;
    }
}
