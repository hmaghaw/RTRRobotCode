package org.usfirst.frc2421.Neptune.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc2421.Neptune.Robot;

/**
 *
 */
public class  TeleDrive extends Command {
    
    public TeleDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.driveSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double xValue = Robot.oi.driveStick.getY();
        double yValue = Robot.oi.driveStick.getX();

        double lMotor = 0.0;
        double rMotor = 0.0;
        
        /**
         * 
         * Following code translates the X and Y values received from the
         * joystick into values for the left and right motors.
         * It is broken into octants (8 slices, like a pizza).
         * X and Y range from -1 to 1.
         * 
         *   \ | /    Here's a visual for you.
         *  -- + --
         *   / | \    Looks a bit like an "X" and a "+" crossed paths.
         * 
         * This octant method is used because the "X" separates the modifiers
         * (Y value for the top and bottom, and the X value for the left and
         * right sections), while the "+" separates the positive and
         * negative values.
         */ 
        
        if (yValue >= Math.abs(xValue)) {
            // if the ordered pair (op) is in the upper "\/" :
            if (xValue >= 0) {
                // right half
                lMotor = yValue;
                rMotor = yValue - xValue;
            } else {
                // left half
                lMotor = yValue + xValue;
                rMotor = yValue;
            }
        } else if (xValue >= Math.abs(yValue)) {
            // if the op is in the right-facing "<" :
            if (yValue >= 0) {
                // upper half
                lMotor = xValue;
                rMotor = yValue - xValue;
            } else {
                // lower half
                lMotor = -xValue;
                rMotor = -xValue - yValue;
            }
        } else if (yValue <= -Math.abs(xValue)) {
            // if the op is in the lower, upside-down "\/" :
            if (xValue >= 0) {
                // right half
                lMotor = yValue;
                rMotor = yValue + xValue;
            } else {
                // left half
                lMotor = yValue - xValue;
                rMotor = yValue;
            }
        } else {
            // if the op is in the remaining, left-facing ">" :
            if (yValue >= 0) {
                // upper half
                lMotor = xValue + yValue;
                rMotor = -xValue;
            } else {
                // lower half
                lMotor = xValue;
                rMotor = yValue - xValue;
            }
        }
        
        Robot.driveSystem.runMotors(lMotor, rMotor);
        SmartDashboard.putNumber("Left Motor", lMotor);
        SmartDashboard.putNumber("Right Motor", rMotor);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
