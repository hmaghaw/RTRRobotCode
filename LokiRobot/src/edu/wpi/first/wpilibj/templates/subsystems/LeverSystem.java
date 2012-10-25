
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

//~--- non-JDK imports --------------------------------------------------------

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Giang
 */
public class LeverSystem extends Subsystem {
    public DoubleSolenoid solenoid;    // COntrols whether to let air through to raise or lower the lever

    public LeverSystem() {
        solenoid = new DoubleSolenoid(RobotMap.forwardchannel, RobotMap.reversechannel);
    }

    public void initDefaultCommand() {

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    public void setDown() {
        solenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void setUp() {
        solenoid.set(DoubleSolenoid.Value.kReverse);
    }

    public void stopLever() {
        solenoid.set(DoubleSolenoid.Value.kOff);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
