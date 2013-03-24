package org.usfirst.frc2421.Neptune.commands.shoot;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2421.Neptune.Robot;

/**
 *
 */
public class AngleManipulation extends Command {

    public AngleManipulation() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);	
        requires(Robot.shootSystem);
    }
    private double angle;
    private double joystickValue;
    private double lowerLimit, upperLimit;
    
    // Called just before this Command runs the first time
    protected void initialize() {
        angle = Robot.shootSystem.getCurrentAngle();
        upperLimit = 70;
        lowerLimit = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        // 'angle' recieves the angle from getCurrentAngle
        //the first statement decides if the angle is within the limits of the elevation of the shooter.
        //the second makes the angle of the shooter increase if you move the joystick forward
        //the elseif makes the angle of the shooter decrease if you move the joystick backward
        angle = Robot.shootSystem.getCurrentAngle();
        /*double currentAngle = Robot.shooter.checkGyroAngle();
        double targetAngle = 0;
        double angleSeparation = targetAngle - currentAngle;
        double acceptableDifference = .75;
        if(angleSeparation > acceptableDifference){
            try {
                Robot.shooter.shooterAngleIncrease();
            } catch (Exception ex) {
            }
            }
       else if(angleSeparation < acceptableDifference){
            try {
                Robot.shooter.shooterAngleDecrease();
            } catch (CANTimeoutException ex) {
            }
       }
       else{
            try {
                Robot.shooter.stopAngleMotor();
            } catch (Exception ex) {
            }
       }*/
       //Robot.shootSystem.angle = Robot.shootSystem.measureAngleOfFire.getAverageValue() * 72;
        joystickValue = Robot.oi.shooterStick.getY();
       if (angle > lowerLimit && angle < upperLimit) 
       {
        if(joystickValue > .2){
            Robot.shootSystem.shooterAngleIncrease(joystickValue);
        }
        else if(joystickValue < -.2){
            Robot.shootSystem.shooterAngleDecrease(joystickValue);
        }
            else {
                Robot.shootSystem.stopAngleMotor();
            }
        } else {
            Robot.shootSystem.stopAngleMotor();
        }
    }
        
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
