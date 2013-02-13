package org.usfirst.frc2421.Neptune;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc2421.Neptune.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public Joystick driveStick; //what these do, i dont know
    public JoystickButton brake, speedToggle;
    
    public Joystick shooterStick = new Joystick(2);
    public JoystickButton shootActivate, shootDeactivate, shooterAngleIncrease, shooterAngleDecrease;
    
    private int shooterPowerUpButton = 4;
    private int shooterPowerDownButton = 3;
    
    public OI() {
        // Shooting Control Setup
        shooterStick = new Joystick(2);
        
        shooterAngleDecrease = new JoystickButton(shooterStick, 4);
        shooterAngleDecrease.whileHeld(new angleDecrease());
        shooterAngleIncrease = new JoystickButton(shooterStick, 3);
        shooterAngleIncrease.whileHeld(new angleIncrease());
        shootDeactivate = new JoystickButton(shooterStick, 2);
        shootDeactivate.whenPressed(new ShooterEnginesStop());
        shootActivate = new JoystickButton(shooterStick, 1);
        shootActivate.whenPressed(new ShooterEnginesGo());
        
        // Drive Control Setup
        driveStick = new Joystick(1);

        speedToggle = new JoystickButton(driveStick, 1);
        speedToggle.whileHeld(new toggleSpeed());
        
        brake = new JoystickButton(driveStick, 1);
        brake.whenPressed(new drive());


        // SmartDashboard Buttons
        // TODO Verify what data actually needs to be sent
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("moveForward", new moveForward());
        SmartDashboard.putData("moveBack", new moveBack());
        SmartDashboard.putData("turnLeft", new turnLeft());
        SmartDashboard.putData("turnRight", new turnRight());
        SmartDashboard.putData("loadDisk", new loadDisk());
        SmartDashboard.putData("drive", new drive());
        SmartDashboard.putData("climbToggle", new climbToggle());
        SmartDashboard.putData("toggleSpeed", new toggleSpeed());
        
        SmartDashboard.putData("angleIncrease", new angleIncrease());
        SmartDashboard.putData("angleDecrease", new angleDecrease());
        SmartDashboard.putData("shooterEnginesStop", new ShooterEnginesStop());
        SmartDashboard.putData("shooterEnginesGo", new ShooterEnginesGo());
        SmartDashboard.putData("shooterSlowDown", new shooterSlowDown());
        SmartDashboard.putData("shooterSpeedUp", new shooterSpeedUp());
    }

    public Joystick getDriveStick() {
        return driveStick;
    }

    public Joystick getShooterStick() {
        return shooterStick;
    }
}
