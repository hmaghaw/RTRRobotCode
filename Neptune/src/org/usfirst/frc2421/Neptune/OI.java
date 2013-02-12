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
    public Joystick driveStick;
    public JoystickButton brake, speedToggle;
    
    public Joystick shooterStick;
    public JoystickButton halt, loadFrisbee, shoot;

    public OI() {
        // Shooting Control Setup
        shooterStick = new Joystick(2);
        
        shoot = new JoystickButton(shooterStick, 1);
        shoot.whileHeld(new shootDisk());
        
        loadFrisbee = new JoystickButton(shooterStick, 1);
        loadFrisbee.whileHeld(new brushToggle());
        
        halt = new JoystickButton(shooterStick, 1);
        halt.whileHeld(new brushToggle());
        
        // Drive Control Setup
        driveStick = new Joystick(1);

        speedToggle = new JoystickButton(driveStick, 1);
        speedToggle.whileHeld(new toggleSpeed());
        
        brake = new JoystickButton(driveStick, 1);
        brake.whenPressed(new drive());
        
        countDecrement = new JoystickButton(shooterStick, 4);
        countDecrement.whenPressed(new decreaseCount());
        getFrisbee = new JoystickButton(shooterStick, 5);
        getFrisbee.whenPressed(new collect());


        // SmartDashboard Buttons
        // TODO Verify what data actually needs to be sent
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("shootDisk", new shootDisk());
        SmartDashboard.putData("shooterAngleUp", new shooterAngleUp());
        SmartDashboard.putData("shooterAngleDown", new shooterAngleDown());
        SmartDashboard.putData("moveForward", new moveForward());
        SmartDashboard.putData("moveBack", new moveBack());
        SmartDashboard.putData("turnLeft", new turnLeft());
        SmartDashboard.putData("turnRight", new turnRight());
        SmartDashboard.putData("loadDisk", new loadDisk());
        SmartDashboard.putData("drive", new drive());
        SmartDashboard.putData("climbToggle", new climbToggle());
        SmartDashboard.putData("toggleSpeed", new toggleSpeed());
    }

    public Joystick getDriveStick() {
        return driveStick;
    }

    public Joystick getShooterStick() {
        return shooterStick;
    }
}
