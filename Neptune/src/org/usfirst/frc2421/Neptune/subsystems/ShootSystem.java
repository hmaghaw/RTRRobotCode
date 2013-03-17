package org.usfirst.frc2421.Neptune.subsystems;

import com.sun.squawk.debugger.Log;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITable;
import org.usfirst.frc2421.Neptune.RobotMap;
import org.usfirst.frc2421.Neptune.utils.RobotUtils;

/**
 * TODO Description
 */
public class ShootSystem extends Subsystem {
    
    public static final double INITIAL_SPEED = .1; //starting speed for the motors
    public static final double MAX_POWER_OUTPUT = .8; //maximim speed of motors
    public static final double MIN_POWER_VALUE = 0; //minimum motors can travel
    public int direction = -1; // wether the motors spin forward (1) or backward (-1)
    public double speedSeparation = .15; //percent the front wheel spins faster than the back wheel 
    public double angle;    //current angle of the shooter Needs to be implemented
    //initialize shooter wheels
    public CANJaguar frontWheel = RobotMap.outerShooterWheel;
    public CANJaguar backWheel = RobotMap.innerShooterWheel;
    //angle manipulator/checker
    public CANJaguar angleOfFire = RobotMap.shootSystemAngleOfFire;
    public AnalogChannel measureAngleOfFire = RobotMap.shootSystemMeasureAngleOfFire;
    public boolean enabled = true;
    
    public ShootSystem(){
        enabled &= (frontWheel != null);
        enabled &= (backWheel != null);
        enabled &= (angleOfFire != null);
        enabled &= (measureAngleOfFire != null);
    }
    
    public void startShooter() {

        //initiates the engines to the robots INITIAL_SPEED and sets direction    
        try {
            backWheel.setX(direction * INITIAL_SPEED);
            frontWheel.setX(direction * INITIAL_SPEED + direction * speedSeparation);
        } catch (CANTimeoutException ex) {
            if (Log.debug()) {
                Log.log(ex.toString());
            }
        }
    }
    
    public void incrementSpeed(double increment) {
        //sets speed to an increment of the current speed
        try {
            double frontFutureSpeed = frontWheel.getX() + (increment * direction);
            double backFutureSpeed = backWheel.getX() + (increment * direction);

            //safety code, ensures that the power will not overload the maximum power output
            if (Math.abs(frontFutureSpeed) < MAX_POWER_OUTPUT && Math.abs(backFutureSpeed) < MAX_POWER_OUTPUT) {
                backWheel.setX(backFutureSpeed);
                frontWheel.setX(frontFutureSpeed);
            }
            
            
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    
    public void decrementSpeed(double increment) {
        //sets a target speed to a decrement of the current speed
        try {
            double frontFutureSpeed = frontWheel.getX() + (increment * -direction);
            double backFutureSpeed = backWheel.getX() + (increment * -direction);
            //checks the direction to determine wether power output should be grater or less than the minimum pwer
            if (Math.abs(frontFutureSpeed) < MAX_POWER_OUTPUT && Math.abs(backFutureSpeed) < MAX_POWER_OUTPUT) {
                if (direction < 0) {
                    //makes sure the target speed will not switch directions and reverse the motors
                    if (frontFutureSpeed < MIN_POWER_VALUE && backFutureSpeed < MIN_POWER_VALUE) {
                        backWheel.setX(backFutureSpeed);
                        frontWheel.setX(frontFutureSpeed);
                    } else if (direction > 0) {
                        if (frontFutureSpeed > MIN_POWER_VALUE && backFutureSpeed > MIN_POWER_VALUE) {
                            backWheel.setX(backFutureSpeed);
                            frontWheel.setX(frontFutureSpeed);
                        }
                    }
                }
            }
            
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    
    public void stopShooter() {
        //turns off shooter by setting power to 0 then coast to a stop

        try {
            backWheel.setX(0);
            frontWheel.setX(0);
        } catch (CANTimeoutException ex) {
            if (Log.debug()) {
                Log.log(ex.toString());
            }
        }
    }
    
    public void stopAngleMotor() {

        //stops the changing of the shooter angle
        try {
            angleOfFire.setX(MIN_POWER_VALUE);
        } catch (CANTimeoutException ex) {
            if (Log.debug());
            Log.log(ex.toString());
        }
    }
    
    public void shooterAngleIncrease(double speed) {
        
        try {
            angleOfFire.setX(speed); //change INITIAL_SPEED of motor here
        } catch (CANTimeoutException ex) {
            if (Log.debug()) {
                Log.log(ex.toString());
            }
        }
    }
    
    public void shooterAngleDecrease(double speed) {
        try {
            angleOfFire.setX(speed);
        } catch (CANTimeoutException ex) {
            if (Log.debug());
            Log.log(ex.toString());
        }
    }
    
    public double checkCurrentAngle() {
        //determies the angle of the motor.
        return measureAngleOfFire.getAverageVoltage() * 72;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void refreshData() {
        RobotUtils.tryPutData("Front Shooter Wheel ", frontWheel);
        RobotUtils.tryPutData("Back Shooter Wheel", backWheel);
        RobotUtils.tryPutData("Angle Motor", angleOfFire);
        RobotUtils.tryPutData("Angle Motor Encoder", checkCurrentAngle());
    }

}
