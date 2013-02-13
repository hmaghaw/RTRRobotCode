package org.usfirst.frc2421.Neptune.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2421.Neptune.RobotMap;



/**
 * This subsystem is used to control the parts of the robot which pick up 
 * frisbees, store them, and load them into the shooter
 */
public class CollectionSystem extends Subsystem {
    //This sensor detects if there is a frisbee in the loading bay
    DigitalInput opticalSensor = RobotMap.pickupSystemOpticalSensor;
    //This sensor has no identified purpose
    DigitalInput limitSwitch = RobotMap.pickupSystemLimitSwitch;
    //This motor is used to bring the frisbee up to the loading bay
    CANJaguar beltMotor = RobotMap.pickupSystemBeltMotor;
    //This int shows how many frisbees are in the loading bay
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

