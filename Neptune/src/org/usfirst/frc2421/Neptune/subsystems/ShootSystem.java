package org.usfirst.frc2421.Neptune.subsystems;

import com.sun.squawk.debugger.Log;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITable;
import org.usfirst.frc2421.Neptune.RobotMap;


/**
 * TODO Description
 */
public class ShootSystem extends Subsystem {
    public double backSpeed, frontSpeed;
    public double angle;    
    
    public CANJaguar frontWheel = RobotMap.frontShooterWheel;
    public CANJaguar backWheel = RobotMap.backShooterWheel;
    public CANJaguar angleOfFire = RobotMap.shootSystemAngleOfFire;
    public AnalogChannel measureAngleOfFire = RobotMap.shootSystemMeasureAngleOfFire;

         public void startShooter(){
        try {
            backWheel.setX(-backSpeed);
            frontWheel.setX(-frontSpeed);
        } catch (CANTimeoutException ex) {
            if (Log.debug())       {
                Log.log(ex.toString());
            }
        }
         }
         
    public void stopShooter(){
        try {
            backWheel.setX(0);
            frontWheel.setX(0);
        } catch (CANTimeoutException ex) {
            if (Log.debug())
                Log.log(ex.toString());
        }
    }
    
    public void stopAngleMotor() {
        try {
            angleOfFire.setX(0);
        } catch (CANTimeoutException ex) {
            if (Log.debug());
            Log.log(ex.toString());
        }
    }
    
    public void shooterAngleIncrease() {
        try {
            angleOfFire.setX(-.5); //change speed of motor here
        } catch (CANTimeoutException ex) {
            if (Log.debug())
                Log.log(ex.toString());
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
        SmartDashboard.putData("Front Shooter Wheel ", frontWheel);
        SmartDashboard.putData("Back Shooter Wheel", backWheel);
        SmartDashboard.putData("Angle Motor", angleOfFire);
        SmartDashboard.putData("Angle Motor Encoder", measureAngleOfFire);
        
        
        return table;
    }
}

