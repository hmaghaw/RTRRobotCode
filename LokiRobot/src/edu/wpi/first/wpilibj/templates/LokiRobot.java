/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Watchdog;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.templates.commands.AutonomousCommand;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.MoveMass;
import edu.wpi.first.wpilibj.templates.commands.TeleDriveCommand;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class LokiRobot extends IterativeRobot {

    private static Command autonomousCommand;
    private static Watchdog watchdog = Watchdog.getInstance();
    public static boolean autonomous = true;
    //public Compressor compressor = new Compressor(RobotMap.pressureSwitch, RobotMap.pressureRelay);
    // private static pressureCommand pressurecommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        //Enable the watchdog
        watchdog.setExpiration(1);
        watchdog.setEnabled(false);
        // Instanciate the commands used for autonomous and teleop mode
        //teleDriveCommand = new teleopCommand();
        // Initialize the command base, which starts
        CommandBase.init();
        //pressurecommand = new pressureCommand();
        autonomousCommand = new AutonomousCommand();
        //watchdog.feed;
    }

    public void disabledInit() {
        //watchdog.feed;
    }

    public void autonomousInit() {

        //if (teleopCommand.isRunning()) {
        //teleopCommand.cancel();
        //}

        // schedule the autonomous command (example)
        //watchdog.feed;
        //autonomousCommand.start();
        Scheduler.getInstance().add(autonomousCommand);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        //watchdog.feed;
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        autonomous = false;
        if (autonomousCommand.isRunning()) {
            autonomousCommand.cancel();
        }

        Scheduler.getInstance().add(new TeleDriveCommand());
        Scheduler.getInstance().add(new MoveMass());
        //watchdog.feed;
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        //watchdog.feed;
    }
}
