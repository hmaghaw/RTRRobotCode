package org.usfirst.frc2421.Neptune.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2421.Neptune.RobotMap;



/**
 * TODO Description
 */
public class CollectionSystem extends Subsystem {
    DigitalInput limitSwitch2 = RobotMap.pickupSystemLimitSwitch2;
    DigitalInput limitSwitch = RobotMap.pickupSystemLimitSwitch;
    CANJaguar beltMotor = RobotMap.pickupSystemBeltMotor;
    public int numOfFrisbees = 0;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    // TODO These should be more than just getters and setters. Subsystems 
    // functions provide ways of controlling the subsystem without letting 
    // outside users do everything by hand, as it were.
    public boolean getSwitch()
    {
        return limitSwitch.get();
    }
    
    public boolean getSwitch2()
    {
        return limitSwitch2.get();
    }
    
    public void goMotor() throws CANTimeoutException
    {
        beltMotor.setX(.5);//enter actual motor speed here later
    }
    
    public void stopMotor() throws CANTimeoutException
    {
       beltMotor.setX(0);
    }
    
    public void upFriz()
    {
        numOfFrisbees ++;
    }
    
}

