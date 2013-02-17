/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2421.Neptune.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
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
        finished = false;
    }

    protected void initialize() {
        Scheduler.getInstance().add(new AngleManipulation());
    }

    protected void execute() {
        if (!finished) {
            //Scheduler.getInstance().add(new TeleDrive());
            finished = true;
        }
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
