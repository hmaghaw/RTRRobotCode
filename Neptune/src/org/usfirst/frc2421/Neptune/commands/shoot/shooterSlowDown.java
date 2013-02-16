package org.usfirst.frc2421.Neptune.commands.shoot;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2421.Neptune.Robot;

/**
 *
 */
public class  shooterSlowDown extends Command {
    private boolean finished;
    
    public shooterSlowDown() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.shootSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.shootSystem.backSpeed -= .1;
        Robot.shootSystem.frontSpeed -= .1;
        if (Robot.shootSystem.backSpeed < 0) {
            Robot.shootSystem.backSpeed = 0;
        }
        if (Robot.shootSystem.frontSpeed < 0) {
            Robot.shootSystem.frontSpeed = 0;
        }
        finished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
