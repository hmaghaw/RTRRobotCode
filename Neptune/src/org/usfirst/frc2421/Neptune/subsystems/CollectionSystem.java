package org.usfirst.frc2421.Neptune.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITable;
import org.usfirst.frc2421.Neptune.RobotMap;



/**
 * This subsystem is used to control the parts of the robot which pick up
 * frisbees, store them, and load them into the shooter
 */
public class CollectionSystem extends Subsystem {
    //This sensor detects if there is a frisbee in the loading bay
    DigitalInput opticalSensor = RobotMap.pickupSystemOpticalSensor;
    DigitalInput limitSwitch = RobotMap.pickupSystemLimitSwitch;
    DigitalInput limitSwitchTwo = RobotMap.pickupSystemLimitSwitch2;
    //This motor is used to bring the frisbee up to the loading bay
    CANJaguar beltMotor = RobotMap.pickupSystemBeltMotor;
    //This int shows how many frisbees are in the loading bay
    public int numOfFrisbees = 0;
    
    public CollectionSystem(){
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    // TODO These should be more than just getters and setters. Subsystems
    // functions provide ways of controlling the subsystem without letting
    // outside users do everything by hand, as it were.
    public boolean getSwitch(){
        return limitSwitch.get();
    }

    public boolean getSwitch2(){
        return limitSwitchTwo.get();
    }

    public void goMotor(){
        try {
            beltMotor.setX(.5);//enter actual motor speed here later
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    public void stopMotor(){
        try {
            beltMotor.setX(0);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    public void upFriz(){
        numOfFrisbees++;
    }
    
    public ITable getTable(){
        ITable table = super.getTable();
        
        return table;
    }
}

