/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2421.Neptune.commands.shoot;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2421.Neptune.Robot;

/**
 *
 * @author Kal
 */
public class AutoAim extends Command {

    public double desiredCenterY;
    public double currentCenterY;
    private double upperYLimit = desiredCenterY + .1;
    private double lowerYLimit = desiredCenterY - .1;
    private double motorSpeed = .2;
    private boolean end;
    public double upperAngleLimit, lowerAngleLimit, currentAngle;

    public AutoAim() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.shootSystem);

        desiredCenterY = 0.0;
        upperYLimit = desiredCenterY + .1;
        lowerYLimit = desiredCenterY - .1;
        upperAngleLimit = Robot.shootSystem.upperLimit;
        lowerAngleLimit = Robot.shootSystem.lowerLimit;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        end = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

        currentAngle = Robot.shootSystem.getCurrentAngle();
        currentCenterY = Robot.cameraSystem.latestReport.center_mass_y_normalized;// states the current distance from the center of Y axis in computer

        if (currentAngle > lowerAngleLimit && currentAngle < upperAngleLimit) {
            if (currentCenterY > upperYLimit) {// decides to make it go up or down
                Robot.shootSystem.shooterAngleDecrease(motorSpeed);//moves the angle motor down
            } else if (currentCenterY < lowerYLimit) {
                Robot.shootSystem.shooterAngleIncrease(motorSpeed);//moves the angle motor up
            } else {
                Robot.shootSystem.stopAngleMotor();// if no maniplulation needed stop the motor
                end = true;
            }
        } else {
            Robot.shootSystem.stopAngleMotor();
            end = true;
        }
    }
// Make this return true when this Command no longer needs to run execute()

    protected boolean isFinished() {
        return end;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        Robot.shootSystem.stopAngleMotor();
    }
}
