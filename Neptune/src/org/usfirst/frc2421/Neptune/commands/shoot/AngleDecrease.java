package org.usfirst.frc2421.Neptune.commands.shoot;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2421.Neptune.Robot;

/**
 *
 */
public class  angleDecrease extends Command {
    
    double angle;
    double angleTarget;
    boolean end = false;

    public angleDecrease() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.shootSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        angle = Robot.shootSystem.checkCurrentAngle();
        angleTarget = angle - .1;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        while(angle > angleTarget){
            Robot.shootSystem.shooterAngleIncrease();
            angle = Robot.shootSystem.checkCurrentAngle();
        }
        end = true;
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
    }
}
