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
        while (!Robot.loaderSystem.getRestSwitch()) { // Add limit/timeout
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
            hasLoaded = false;
            
        } else if (Robot.loaderSystem.getRestSwitch() && hasLoaded) {
            Robot.loaderSystem.stopArm();
            finished = true;
        }
//        if (hasLoaded && !Robot.loaderSystem.getFiredSwitch()) {
//            Robot.loaderSystem.startLoaderArm(-.5);
//        }
//        if (Robot.loaderSystem.getFiredSwitch() && hasLoaded) {
//            Robot.loaderSystem.stopArm();
//            hasLoaded = false;
//        }
//        if (Robot.loaderSystem.getFiredSwitch() && !hasLoaded) {
//            Robot.loaderSystem.startLoaderArm(.5);
//        }
//        if (Robot.loaderSystem.getRestSwitch() && !hasLoaded) {
//            Robot.loaderSystem.stopArm();        
//            end = true;
    }
}
protected boolean isFinished() {
        return finished;
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
