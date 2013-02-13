package org.usfirst.frc2421.Neptune;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    //TODO Clean up variable names
    //TODO Does the climb system still need to exist?
    public static CANJaguar driveSystemCANJaguarLeft;
    public static CANJaguar driveSystemCANJaguarRight;
    
    public static CANJaguar shootSystemWheel1;
    public static CANJaguar shootSystemWheel2;
    public static Servo shootSystemAngleMotor;
    
    public static CANJaguar climbSystemClimbMotor1;
    public static Ultrasonic climbSystemUltrasonic;
    public static CANJaguar climbSystemClimbMotor2;
    public static DigitalInput climbSystemBarSensor1;
    public static DigitalInput climbSystemBarSensor2;
    public static DigitalInput climbSystemBarSensor3;
    public static DigitalInput climbSystemBarSensor4;
    public static DigitalInput climbSystemBaseLimitSwitch;
    
    public static CANJaguar collectionSystemBrush1;
    
    public static Compressor tipSystemTipCompressor;
    public static Relay tipSystemTipperRelaySolenoid;
    
    public static DigitalInput pickupSystemLimitSwitch2;
    public static DigitalInput pickupSystemLimitSwitch;
    public static CANJaguar pickupSystemBeltMotor;

    public static void init() {
        try {
            driveSystemCANJaguarLeft = new CANJaguar(4);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace(); //We should really do better than just 
                                  //dumping this stuff into the console
        }

        try {
            driveSystemCANJaguarRight = new CANJaguar(2);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }

        try {
            shootSystemWheel1 = new CANJaguar(8);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }

        try {
            shootSystemWheel2 = new CANJaguar(5);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }


        shootSystemAngleMotor = new Servo(1, 1);
        LiveWindow.addActuator("ShootSystem", "Angle Motor", shootSystemAngleMotor);

        try {
            climbSystemClimbMotor1 = new CANJaguar(7);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }

        climbSystemUltrasonic = new Ultrasonic(1, 1, 1, 2);
        LiveWindow.addSensor("ClimbSystem", "Ultrasonic", climbSystemUltrasonic);

        try {
            climbSystemClimbMotor2 = new CANJaguar(7);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }

//        climbSystemBarSensor1 = new DigitalInput(1, 4);
//        LiveWindow.addSensor("ClimbSystem", "Bar Sensor 1", climbSystemBarSensor1);
//
//        climbSystemBarSensor2 = new DigitalInput(1, 5);
//        LiveWindow.addSensor("ClimbSystem", "Bar Sensor 2", climbSystemBarSensor2);
//
//        climbSystemBarSensor3 = new DigitalInput(1, 6);
//        LiveWindow.addSensor("ClimbSystem", "Bar Sensor 3", climbSystemBarSensor3);
//
//        climbSystemBarSensor4 = new DigitalInput(1, 7);
//        LiveWindow.addSensor("ClimbSystem", "Bar Sensor 4", climbSystemBarSensor4);
//
//        climbSystemBaseLimitSwitch = new DigitalInput(1, 8);
//        LiveWindow.addSensor("ClimbSystem", "Base Limit Switch", climbSystemBaseLimitSwitch);
       
        pickupSystemLimitSwitch = new DigitalInput(1,2);
        pickupSystemLimitSwitch2 = new DigitalInput(1,3);
        try {
            pickupSystemBeltMotor = new CANJaguar(6);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        


        tipSystemTipCompressor = new Compressor(1, 3, 1, 1);


        tipSystemTipperRelaySolenoid = new Relay(1, 2);
        LiveWindow.addActuator("TipSystem", "Tipper Relay Solenoid ", tipSystemTipperRelaySolenoid);

    }
}
