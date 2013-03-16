package org.usfirst.frc2421.Neptune.commands.loader;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2421.Neptune.Robot;

// Make this return true when this Command no longer needs to run execute()
/**
 *
 * @author Kal
 */
public class loadFrisbee extends Command {

    public boolean hasLoaded;
    private boolean finished;

    public loadFrisbee() {
        requires(Robot.loaderSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        finished = false;
        hasLoaded = false;
        for (int i = 0; i > 50; i++) {
            if (!Robot.loaderSystem.getRestSwitch()) { // Add limit/timeout
                Robot.loaderSystem.startLoaderArm(-.5);
            }
        }
        Robot.loaderSystem.stopArm();
    }

// Called repeatedly when this Command is scheduled to run
    public void execute() {

        if (!hasLoaded && !Robot.loaderSystem.getFiredSwitch()) {
            Robot.loaderSystem.startLoaderArm(.5);
        } else if (Robot.loaderSystem.getFiredSwitch() && !hasLoaded) {
            Robot.loaderSystem.startLoaderArm(-.5);
            hasLoaded = true;

        } else if (Robot.loaderSystem.getRestSwitch() && hasLoaded) {
            Robot.loaderSystem.stopArm();
            finished = true;
        }
    }

    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.loaderSystem.stopArm();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        while (!Robot.loaderSystem.getRestSwitch()) { // Add limit/timeout
            Robot.loaderSystem.startLoaderArm(.5);
        }
    }
}
