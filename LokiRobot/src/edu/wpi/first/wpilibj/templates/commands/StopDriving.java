
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

//~--- non-JDK imports --------------------------------------------------------
import edu.wpi.first.wpilibj.templates.LokiRobot;

/**
 *
 * @author Driver
 */
public class StopDriving extends CommandBase {

    public StopDriving() {

        // Use requires() here to declare subsystem dependencies
        requires(driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (LokiRobot.autonomous) {
            driveSubsystem.stopWheel();
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


//~ Formatted by Jindent --- http://www.jindent.com
