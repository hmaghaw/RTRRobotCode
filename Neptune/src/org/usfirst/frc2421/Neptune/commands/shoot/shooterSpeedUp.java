package org.usfirst.frc2421.Neptune.commands.shoot;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2421.Neptune.Robot;

/**
 *
 */
public class  shooterSpeedUp extends Command {

    public shooterSpeedUp() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.shootSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
       // Robot.shootSystem.startShooter(1, 1.25);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.shootSystem.speed += .1;
        if(Robot.shootSystem.speed > .6){
           Robot.shootSystem.speed = .6;
       }
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
