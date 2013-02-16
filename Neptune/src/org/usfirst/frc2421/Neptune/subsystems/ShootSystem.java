package org.usfirst.frc2421.Neptune.subsystems;

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
    public double backSpeed, frontSpeed;
    public double angle;    
    
    public CANJaguar backwheel = RobotMap.shootSystemWheel1;
    public CANJaguar frontwheel = RobotMap.shootSystemWheel2;
    public CANJaguar angleOfFire = RobotMap.shootSystemAngleOfFire;
    public AnalogChannel measureAngleOfFire = RobotMap.shootSystemMeasureAngleOfFire;

         public void startShooter(){
        try {
            backwheel.setX(-backSpeed);
            frontwheel.setX(-frontSpeed);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
         
    public void stopShooter(){
        try {
            backwheel.setX(0);
            frontwheel.setX(0);
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
            ex.printStackTrace();
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
        return table;
    }
}

