package org.usfirst.frc2421.Neptune.commands.collection;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2421.Neptune.Robot;

/**
 *
 * @author Kal
 */
public class collect extends Command {

    public boolean on = false;

    public collect() {
        requires(Robot.collectionSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {

        if (Robot.collectionSystem.getSwitch() && !on) {
                Robot.collectionSystem.goMotor();
        } else if (Robot.collectionSystem.getSwitch2() && on) {
                Robot.collectionSystem.stopMotor();
                on = false;
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
