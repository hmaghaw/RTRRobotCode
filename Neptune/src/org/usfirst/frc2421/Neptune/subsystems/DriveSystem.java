package org.usfirst.frc2421.Neptune.subsystems;

import com.sun.squawk.debugger.Log;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITable;
import org.usfirst.frc2421.Neptune.RobotMap;
import org.usfirst.frc2421.Neptune.commands.drive.TeleDrive;

/**
 * This system is used to set and get the speeds of the drive motors This is a
 * constructor for the 2 CAN Jaguars used in the drive system
 */
public class DriveSystem extends Subsystem {

    public CANJaguar leftDriveMotor = RobotMap.driveSystemCANJaguarLeft;
    public CANJaguar rightDriveMotor = RobotMap.driveSystemCANJaguarRight;
    public boolean enabled = true;
    
    public DriveSystem(){
    enabled &= (leftDriveMotor != null);
    enabled &= (rightDriveMotor != null);
}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    /**
     * This method sets the speed of the drive motors based on the parameters
     *
     * @param leftSpeed
     * @param rightSpeed
     */
    public void runMotors(double leftSpeed, double rightSpeed) {
        try {
            leftDriveMotor.setX(leftSpeed);
            rightDriveMotor.setX(rightSpeed);
        } catch (CANTimeoutException ex) {
            if (Log.debug()) {
                Log.log(ex.toString());
            }
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
            speeds[0] = leftDriveMotor.getX();
            speeds[1] = rightDriveMotor.getX();
        } catch (CANTimeoutException ex) {
            if (Log.debug()) {
                Log.log(ex.toString());
            }
        }
        return speeds;

    }

    public void refreshData() {
        ITable table = super.getTable();
        SmartDashboard.putData("Left Drive Motor", leftDriveMotor);
        SmartDashboard.putData("Right Drive Motor", rightDriveMotor);
    }
}
