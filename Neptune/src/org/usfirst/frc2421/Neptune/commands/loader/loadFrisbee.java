package org.usfirst.frc2421.Neptune.commands.loader;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2421.Neptune.Robot;

/**
 *
 * @author Kal
 */
public class loadFrisbee extends Command {

    public boolean loading;
    public boolean end;

    public loadFrisbee() {
        requires(Robot.loaderSystem);
        loading = true;
        end = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {

        if (loading && !Robot.loaderSystem.getFiredSwitch()) {
            Robot.loaderSystem.startLoaderArm(.5);
        } else if (Robot.loaderSystem.getFiredSwitch() && loading) {
            Robot.loaderSystem.stopMotor();
            loading = false;
        } else if (Robot.loaderSystem.getFiredSwitch() && !loading) {
            Robot.loaderSystem.startLoaderArm(-.5);
        } else if (Robot.loaderSystem.getRestSwitch() && !loading) {
            Robot.loaderSystem.stopMotor();        
            end = true;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return end;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
