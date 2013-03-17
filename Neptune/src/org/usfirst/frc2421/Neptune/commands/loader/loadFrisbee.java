package org.usfirst.frc2421.Neptune.commands.loader;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2421.Neptune.Robot;

// Make this return true when this Command no longer needs to run execute()
/**
 *
 * @author Kal
 */
public class loadFrisbee extends Command {

    public static final int DIRECTION = 1; //sets direction to forward(1) or backward(-1)
    public static final double SPEED = .5;
    private boolean finished;
    private boolean hasLoaded;

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
//        resetArm();

    }

// Called repeatedly when this Command is scheduled to run
    public void execute() {
        launchFrisbee();
        resetArm();
    }

    protected boolean isFinished() {
        return true;
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

    public void resetArm() {
        while (!Robot.loaderSystem.getRestSwitch()) {
            Robot.loaderSystem.startLoaderArm(-DIRECTION * SPEED);
        }
        Robot.loaderSystem.stopArm();
    }

    public void launchFrisbee() {
        while (!Robot.loaderSystem.getFiredSwitch()) {
            Robot.loaderSystem.startLoaderArm(DIRECTION * SPEED);
        }
        Robot.loaderSystem.stopArm();
    }
}
