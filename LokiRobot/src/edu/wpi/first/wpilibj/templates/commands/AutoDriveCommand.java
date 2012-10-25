
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Driver
 */
public class AutoDriveCommand extends CommandBase {
    private double speed;

    public AutoDriveCommand(double speed) {
        requires(driveSubsystem);
        this.speed=speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
            driveSubsystem.driveForward(speed);
}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isCanceled();
    }

    // Called once after isFinished returns true
    protected void end() {
        driveSubsystem.stopWheel();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        driveSubsystem.stopWheel();
    }
}
