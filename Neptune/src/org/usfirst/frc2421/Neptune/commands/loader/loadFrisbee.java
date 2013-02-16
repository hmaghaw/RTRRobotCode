package org.usfirst.frc2421.Neptune.commands.loader;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2421.Neptune.Robot;

/**
 *
 * @author Kal
 */
public class loadFrisbee extends Command {

    public boolean isForward;
    public boolean end;

    public loadFrisbee() {
        requires(Robot.loaderSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        while (!Robot.loaderSystem.getRestSwitch()){
            Robot.loaderSystem.startLoaderArm(.5);
            isForward = true;
            end = false;
        }
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {

        if (isForward && !Robot.loaderSystem.getFiredSwitch()) {
            Robot.loaderSystem.startLoaderArm(-.5);
        }
        if (Robot.loaderSystem.getFiredSwitch() && isForward) {
            Robot.loaderSystem.stopMotor();
            isForward = false;
        }
        if (Robot.loaderSystem.getFiredSwitch() && !isForward) {
            Robot.loaderSystem.startLoaderArm(.5);
        }
        if (Robot.loaderSystem.getRestSwitch() && !isForward) {
            Robot.loaderSystem.stopMotor();        
        }
        end = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return end;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.loaderSystem.stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
