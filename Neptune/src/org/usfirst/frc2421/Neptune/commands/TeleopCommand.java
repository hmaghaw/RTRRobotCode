/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2421.Neptune.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.usfirst.frc2421.Neptune.Robot;
import org.usfirst.frc2421.Neptune.commands.drive.TeleDrive;
import org.usfirst.frc2421.Neptune.commands.shoot.AngleManipulation;

/**
 *
 * @author Driver
 */
public class TeleopCommand extends Command {

    boolean finished;
    Command shootCommand;

    public TeleopCommand() {
    }

    protected void initialize() {
        if (!Robot.loaderSystem.getRestSwitch() && Robot.loaderSystem.enabled) {
            Robot.loaderSystem.startLoaderArm(-.5);
        }
    }

    protected void execute() {
        if (Robot.driveSystem.enabled) {
            Scheduler.getInstance().add(new TeleDrive());
        }
        if (Robot.shootSystem.enabled) {
            Scheduler.getInstance().add(new AngleManipulation());
        }
        finished = true;
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
