package org.usfirst.frc2421.Neptune;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc2421.Neptune.commands.AutonomousCommand;
import org.usfirst.frc2421.Neptune.commands.drive.*;
import org.usfirst.frc2421.Neptune.commands.loader.loadFrisbee;
import org.usfirst.frc2421.Neptune.commands.shoot.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    // Driving Control Objects
    public Joystick driveStick;
    public JoystickButton brake, speedToggle;
    //Shooting Control Objects
    public Joystick shooterStick;
    public JoystickButton shootActivate, shootDeactivate, shooterAngleIncrease, shooterAngleDecrease, shootSpeedUp, shootSpeedDown;
    public JoystickButton loadDiskButton;
    private final JoystickButton turnLightOff;
    private final JoystickButton turnLightOn;

    public OI() {
        // Shooting Control Setup
        shooterStick = new Joystick(1);

        shooterAngleDecrease = new JoystickButton(shooterStick, 10);
        shooterAngleDecrease.whileHeld(new AngleDecrease());

        shooterAngleIncrease = new JoystickButton(shooterStick, 11);
        shooterAngleIncrease.whileHeld(new AngleIncrease());

        shootDeactivate = new JoystickButton(shooterStick, 2);
        shootDeactivate.whenPressed(new ShooterEnginesStop());

        shootActivate = new JoystickButton(shooterStick, 3);
        shootActivate.whenPressed(new ShooterEnginesGo());

        shootSpeedUp = new JoystickButton(shooterStick, 5);
        shootSpeedUp.whenPressed(new ShooterSpeedUp());

        shootSpeedDown = new JoystickButton(shooterStick, 4);
        shootSpeedDown.whenPressed(new ShooterSlowDown());

        loadDiskButton = new JoystickButton(shooterStick, 1);
        loadDiskButton.whenPressed(new loadFrisbee());

        // Drive Control Setup
        driveStick = new Joystick(2);

        speedToggle = new JoystickButton(driveStick, 1);
        speedToggle.whileHeld(new DriveSpeedUp());

        brake = new JoystickButton(driveStick, 1);

        // Camera Control Setup
        turnLightOn = new JoystickButton(shooterStick, 6);
        turnLightOff = new JoystickButton(shooterStick, 7);

        // SmartDashboard Buttons. Each of these creates a button on the
        // smartdashboard which, when pressed, launches the command.
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("moveForward", new MoveForward());
        SmartDashboard.putData("moveBack", new MoveBackward());
        SmartDashboard.putData("turnLeft", new TurnLeft());
        SmartDashboard.putData("turnRight", new TurnRight());
        SmartDashboard.putData("toggleSpeed", new DriveSpeedUp());
        SmartDashboard.putData("loadFrisbee", new loadFrisbee());
        SmartDashboard.putData("angleIncrease", new AngleIncrease());
        SmartDashboard.putData("angleDecrease", new AngleDecrease());
        SmartDashboard.putData("shooterEnginesStop", new ShooterEnginesStop());
        SmartDashboard.putData("shooterEnginesGo", new ShooterEnginesGo());
        SmartDashboard.putData("shooterSlowDown", new ShooterSlowDown());
        SmartDashboard.putData("shooterSpeedUp", new ShooterSpeedUp());
        SmartDashboard.putData("AngleManipulation", new AngleManipulation());
    }
}
