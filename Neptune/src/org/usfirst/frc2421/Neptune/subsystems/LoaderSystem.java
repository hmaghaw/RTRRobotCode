package org.usfirst.frc2421.Neptune.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.tables.ITable;
import org.usfirst.frc2421.Neptune.RobotMap;



/**
 * This subsystem is used to control the parts of the robot which pick up
 * frisbees, store them, and load them into the shooter
 */
public class LoaderSystem extends Subsystem {
    //This sensor detects if there is a frisbee in the loading bay
    DigitalInput opticalSensor = RobotMap.loaderOpticalSensor;
    DigitalInput restLimitSwitch = RobotMap.loaderRestSwitch;
    DigitalInput firedLimitSwitch = RobotMap.loaderFiredSwitch;
    //This motor is used to bring the frisbee up to the loading bay
    CANJaguar loaderMotor = RobotMap.loaderMotor;
    //This int shows how many frisbees are in the loading bay
    public int numOfFrisbees = 0;
    
    public LoaderSystem(){
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    // TODO These should be more than just getters and setters. Subsystems
    // functions provide ways of controlling the subsystem without letting
    // outside users do everything by hand, as it were.
    public boolean getRestSwitch(){
        return restLimitSwitch.get();
    }

    public boolean getFiredSwitch(){
        return firedLimitSwitch.get();
    }

    public void startLoaderArm(double speed){
        try {
            loaderMotor.setX(speed);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    public void stopMotor(){
        try {
            loaderMotor.setX(0);
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

