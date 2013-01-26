// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.


package org.usfirst.frc2421.Neptune;

import org.usfirst.frc2421.Neptune.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton brake;
    public JoystickButton speedToggle;
    public Joystick driveStick;
    public JoystickButton halt;
    public JoystickButton loadFrisbee;
    public JoystickButton shoot;
    public Joystick shooterStick;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        shooterStick = new Joystick(2);
        
        shoot = new JoystickButton(shooterStick, 1);
        shoot.whileHeld(new shootDisk());
        loadFrisbee = new JoystickButton(shooterStick, 1);
        loadFrisbee.whileHeld(new brushToggle());
        halt = new JoystickButton(shooterStick, 1);
        halt.whileHeld(new brushToggle());
        driveStick = new Joystick(1);
        
        speedToggle = new JoystickButton(driveStick, 1);
        speedToggle.whileHeld(new toggleSpeed());
        brake = new JoystickButton(driveStick, 1);
        brake.whenPressed(new drive());

	    
        // SmartDashboard Buttons
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

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getDriveStick() {
        return driveStick;
    }

    public Joystick getShooterStick() {
        return shooterStick;
    }

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

