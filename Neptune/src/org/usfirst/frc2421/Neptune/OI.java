package org.usfirst.frc2421.Neptune;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc2421.Neptune.commands.AutonomousCommand;
import org.usfirst.frc2421.Neptune.commands.collection.*;
import org.usfirst.frc2421.Neptune.commands.drive.*;
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

    public OI() {
        // Shooting Control Setup
        shooterStick = new Joystick(1);

        shooterAngleDecrease = new JoystickButton(shooterStick, 4);
        shooterAngleDecrease.whileHeld(new angleDecrease());
        
        shooterAngleIncrease = new JoystickButton(shooterStick, 3);
        shooterAngleIncrease.whileHeld(new angleIncrease());
        
        shootDeactivate = new JoystickButton(shooterStick, 2);
        shootDeactivate.whenPressed(new ShooterEnginesStop());
        
        shootActivate = new JoystickButton(shooterStick, 1);
        shootActivate.whenPressed(new ShooterEnginesGo());
        
        shootSpeedUp = new JoystickButton(shooterStick, 5);
        shootSpeedUp.whenPressed(new shooterSpeedUp());
        
        shootSpeedDown = new JoystickButton(shooterStick, 6);
        shootSpeedDown.whenPressed(new shooterSlowDown());
        
        loadDiskButton = new JoystickButton(shooterStick,7);
        loadDiskButton.whenPressed(new collect());
        
        // Drive Control Setup
        driveStick = new Joystick(2);

        speedToggle = new JoystickButton(driveStick, 1);
        speedToggle.whileHeld(new toggleSpeed());

        brake = new JoystickButton(driveStick, 1);


        // SmartDashboard Buttons. Each of these creates a button on the
        // smartdashboard which, when pressed, launches the command.
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("moveForward", new moveForward());
        SmartDashboard.putData("moveBack", new moveBack());
        SmartDashboard.putData("turnLeft", new turnLeft());
        SmartDashboard.putData("turnRight", new turnRight());
        SmartDashboard.putData("loadDisk", new loadDisk());
        SmartDashboard.putData("toggleSpeed", new toggleSpeed());

        SmartDashboard.putData("angleIncrease", new angleIncrease());
        SmartDashboard.putData("angleDecrease", new angleDecrease());
        SmartDashboard.putData("shooterEnginesStop", new ShooterEnginesStop());
        SmartDashboard.putData("shooterEnginesGo", new ShooterEnginesGo());
        SmartDashboard.putData("shooterSlowDown", new shooterSlowDown());
        SmartDashboard.putData("shooterSpeedUp", new shooterSpeedUp());
    }
}
