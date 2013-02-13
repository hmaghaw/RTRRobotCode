package org.usfirst.frc2421.Neptune.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2421.Neptune.RobotMap;


/**
 * TODO Delete
 */
public class ClimbSystem extends Subsystem {
    CANJaguar climbMotor1 = RobotMap.climbSystemClimbMotor1;
    Ultrasonic ultrasonic = RobotMap.climbSystemUltrasonic;
    CANJaguar climbMotor2 = RobotMap.climbSystemClimbMotor2;
    DigitalInput barSensor1 = RobotMap.climbSystemBarSensor1;
    DigitalInput barSensor2 = RobotMap.climbSystemBarSensor2;
    DigitalInput barSensor3 = RobotMap.climbSystemBarSensor3;
    DigitalInput barSensor4 = RobotMap.climbSystemBarSensor4;
    DigitalInput baseLimitSwitch = RobotMap.climbSystemBaseLimitSwitch;

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public void initDefaultCommand() {
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

