package org.usfirst.frc2421.Neptune;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc2421.Neptune.commands.AutonomousCommand;
import org.usfirst.frc2421.Neptune.commands.TeleopCommand;
import org.usfirst.frc2421.Neptune.subsystems.CameraSystem;
import org.usfirst.frc2421.Neptune.subsystems.DriveSystem;
import org.usfirst.frc2421.Neptune.subsystems.LoaderSystem;
import org.usfirst.frc2421.Neptune.subsystems.ShootSystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Command autonomousCommand;
    Command teleopCommand;
    public static OI oi;
    public static DriveSystem driveSystem;
    public static CameraSystem cameraSystem;
    public static ShootSystem shootSystem;
    public static LoaderSystem loaderSystem;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        RobotMap.init();

        driveSystem = new DriveSystem();
        cameraSystem = new CameraSystem();
        shootSystem = new ShootSystem();
        loaderSystem = new LoaderSystem();

        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // instantiate the command used for the autonomous period
        autonomousCommand = new AutonomousCommand();
        teleopCommand = new TeleopCommand();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (teleopCommand != null) {
            teleopCommand.cancel();
        }

        if (autonomousCommand != null) {
            autonomousCommand.start();
        }
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running.
        if (autonomousCommand != null) {
            autonomousCommand.cancel();
        }

        if (teleopCommand != null) {
            teleopCommand.start();
        }
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        //SmartDashboard.putData("Drive System", driveSystem);
        SmartDashboard.putData("Shoot System", shootSystem);
        SmartDashboard.putData("Load System", loaderSystem);
        //SmartDashboard.putData("Camera System", cameraSystem);
    }

    /**
     * This function called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
