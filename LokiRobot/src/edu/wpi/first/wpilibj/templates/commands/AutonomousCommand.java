/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Giang
 */
public class AutonomousCommand extends CommandGroup {
    public AutonomousCommand() {
        addSequential(new MoveLever(-1),1);
        addSequential(new AutoDriveCommand(.25) , 6);
        addSequential(new AutoDriveCommand(0),2);
    }
}

