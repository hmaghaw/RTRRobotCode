// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.


package org.usfirst.frc2421.Neptune.subsystems;

import org.usfirst.frc2421.Neptune.RobotMap;
import org.usfirst.frc2421.Neptune.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.can.*;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Shooter extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    CANJaguar shooterEngine1 = RobotMap.shootershooterEngine1;
    CANJaguar shooterEngine2 = RobotMap.shootershooterEngine2;
    CANJaguar angleOfFire = RobotMap.shooterangleOfFire;
    AnalogChannel measureAngleOfFire = RobotMap.shootermeasureAngleOfFire;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void startShooter(double speed) throws CANTimeoutException{
        shooterEngine1.setX(speed);
        shooterEngine2.setX(speed);
    }
    public void stopShooter() throws Exception{
        shooterEngine1.setX(0);
        shooterEngine2.setX(0);
    }
    public void angleChange(double angle) throws Exception{
        //add angle checking
        //angleOfFire.setX(angle);
    }
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
