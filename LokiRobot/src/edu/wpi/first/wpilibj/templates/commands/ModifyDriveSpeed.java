
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Giang
 */
public class ModifyDriveSpeed extends CommandBase {

    private double driveFactor;
    private double turnFactor;

    public ModifyDriveSpeed(double drivefactor, double turnfactor) {
        driveFactor = drivefactor;
        turnFactor = turnfactor;

        // Use requires() here to declare subsystem dependencies
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (driveSubsystem.driveFactor != driveFactor && driveSubsystem.turnFactor != turnFactor) {
            driveSubsystem.factorMode = true;
            driveSubsystem.driveFactor = driveFactor;
            driveSubsystem.turnFactor = turnFactor;
        } else {
            driveSubsystem.factorMode = false;
            driveSubsystem.driveFactor = 1;
            driveSubsystem.turnFactor = 1;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
