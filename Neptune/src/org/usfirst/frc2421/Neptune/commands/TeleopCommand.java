/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2421.Neptune.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.usfirst.frc2421.Neptune.commands.drive.TeleDrive;

/**
 *
 * @author Driver
 */
public class TeleopCommand extends Command {

    boolean finished;

    public TeleopCommand() {
        finished = false;
    }

    protected void initialize() {
    }

    protected void execute() {
        if (!finished) {
            Scheduler.getInstance().add(new TeleDrive());
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
