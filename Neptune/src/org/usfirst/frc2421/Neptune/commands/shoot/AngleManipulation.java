package org.usfirst.frc2421.Neptune.commands.shoot;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2421.Neptune.Robot;

/**
 *
 */
public class AngleManipulation extends Command {

    private double angle;
    private double joystickValue;
    private double lowerLimit, upperLimit;
    private boolean end;

    public AngleManipulation() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);	
        requires(Robot.shootSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.shootSystem.angle = Robot.shootSystem.measureAngleOfFire.getAverageValue() * 72;
        lowerLimit = Robot.shootSystem.lowerLimit;
        upperLimit = Robot.shootSystem.upperLimit;
        end = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
        if (angle > lowerLimit && angle < upperLimit) {
            if (joystickValue > .2) {
                Robot.shootSystem.shooterAngleIncrease(joystickValue);
            } else if (joystickValue < -.2) {
                Robot.shootSystem.shooterAngleDecrease(joystickValue);
            } else {
                Robot.shootSystem.stopAngleMotor();
                end = true;
            }
        } else {
            Robot.shootSystem.stopAngleMotor();
            end = true;
        }
    }

    protected boolean isFinished() {
        return end;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
