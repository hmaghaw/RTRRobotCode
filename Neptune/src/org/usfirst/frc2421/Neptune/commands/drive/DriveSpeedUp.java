package org.usfirst.frc2421.Neptune.commands.drive;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveSpeedUp extends Command {
    private boolean finished;

    public DriveSpeedUp() {
        // Use requires() here to declare subsystem dependencies
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
