package org.usfirst.frc2421.Neptune.commands.shoot;

import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2421.Neptune.Robot;

/**
 *
 */
public class ShooterEnginesGo extends Command {
    //public double INITIAL_SPEED;

    public ShooterEnginesGo() {
        //speed = 0;
        requires(Robot.shootSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.shootSystem.startShooter();
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
        /*      try {
         Robot.shooter.stopShooter();
         } catch (Exception ex) {
         }*/
    }
}
