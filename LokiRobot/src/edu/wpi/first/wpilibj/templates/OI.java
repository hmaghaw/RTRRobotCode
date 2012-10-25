package edu.wpi.first.wpilibj.templates;

//~--- non-JDK imports --------------------------------------------------------

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.ModifyDriveSpeed;
import edu.wpi.first.wpilibj.templates.commands.MoveLever;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * Note: instantiations are done during construction in order for debugging to
 * work, should something go wrong declaring variables
 */
public class OI {
    private static OI instance;
    public Joystick   coPilotStick;
    public Joystick   driveStick;
    private Button    halfSpeedButton;
    private Button    leverDownButton;
    private Button    quadSpeedButton;
    private Button    leverUpButton;
    private Button    stopLeverButton;
    private Button    stopWheelButton;

    protected OI() {

        // Joysticks
        driveStick   = new Joystick(1);
        coPilotStick = new Joystick(2);

        // Buttons
        stopWheelButton = new JoystickButton(driveStick, 6);
        halfSpeedButton = new JoystickButton(driveStick, 7);
        quadSpeedButton=new JoystickButton(driveStick, 4);
        leverDownButton = new JoystickButton(coPilotStick, 6);
        leverUpButton   = new JoystickButton(coPilotStick, 7);
        stopLeverButton = new JoystickButton(coPilotStick, 8);

        // Hooksx
        quadSpeedButton.whenPressed(new ModifyDriveSpeed(.25, 1));
        halfSpeedButton.whenPressed(new ModifyDriveSpeed(.5, 1));
        stopWheelButton.whenPressed(new ModifyDriveSpeed(0, 0));
  
        leverDownButton.whenPressed(new MoveLever(1));
        leverUpButton.whenPressed(new MoveLever(-1));
        stopLeverButton.whenPressed(new MoveLever(0));
    }

    public static synchronized OI getInstance() {
        if (instance == null) {
            instance = new OI();
        }

        return instance;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
