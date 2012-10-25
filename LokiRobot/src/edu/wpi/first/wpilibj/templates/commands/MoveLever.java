
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Giang
 */
public class MoveLever extends CommandBase {

    private int moveFactor;

    public MoveLever(int factor) {

        // Use requires() here to declare subsystem dependencies
        requires(leverSubsystem);
        moveFactor = factor;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if (moveFactor == 1) {
            leverSubsystem.setDown();
        } else if (moveFactor == -1) {
            leverSubsystem.setUp();
        } else if (moveFactor == 0) {
            leverSubsystem.stopLever();
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
