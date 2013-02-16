package org.usfirst.frc2421.Neptune.subsystems;

import com.sun.squawk.debugger.Log;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.tables.ITable;
import org.usfirst.frc2421.Neptune.RobotMap;


/**
 * TODO Description
 */
public class ShootSystem extends Subsystem {
    public double speed;
    public double angle;    
    
    public CANJaguar frontWheel = RobotMap.frontShooterWheel;
    public CANJaguar backWheel = RobotMap.backShooterWheel;
    public CANJaguar angleOfFire = RobotMap.shootSystemAngleOfFire;
    public AnalogChannel measureAngleOfFire = RobotMap.shootSystemMeasureAngleOfFire;

         public void startShooter(double speed){
        try {
            frontWheel.setX(-speed);
            backWheel.setX(-speed-.15);
        } catch (CANTimeoutException ex) {
            if (Log.debug())       {
                Log.log(ex.toString());
            }
        }
         }
         
    public void stopShooter(){
        try {
            frontWheel.setX(0);
            backWheel.setX(0);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    
    public void stopAngleMotor() {
        try {
            angleOfFire.setX(0);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    
    public void shooterAngleIncrease() {
        try {
            angleOfFire.setX(-.5); //change speed of motor here
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    
    public void shooterAngleDecrease() {
        try {
            angleOfFire.setX(.5);
        } catch (CANTimeoutException ex) {
            if(Log.debug());
            Log.log(ex.toString());
        }
    }
    public double checkCurrentAngle(){
        return measureAngleOfFire.getAverageVoltage() * 72;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public ITable getTable(){
        ITable table = super.getTable();
        table.putValue("Front Shooter Wheel ", frontWheel);
        table.putValue("Back Shooter Wheel", backWheel);
        table.putValue("Angle Motor", angleOfFire);
        table.putValue("Angle Motor Encoder", measureAngleOfFire);
        
        
        return table;
    }
}

