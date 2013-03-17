<<<<<<< HEAD
// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.


package org.usfirst.frc2421.Neptune;
    
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.can.*;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import java.util.Vector;
=======
package org.usfirst.frc2421.Neptune;

import com.sun.squawk.debugger.Log;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
>>>>>>> origin/temp-master

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
<<<<<<< HEAD
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static CANJaguar driveSystemCANJaguarLeft;
    public static CANJaguar driveSystemCANJaguarRight;
//    public static RobotDrive driveSystemRobotDrive;
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
    public static CANJaguar collectionSystemHarold;
    public static DigitalInput collectionSystemOpticalSensor;
    public static Compressor tipSystemTipCompressor;
    public static Relay tipSystemTipperRelaySolenoid;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        try { 
            driveSystemCANJaguarLeft = new CANJaguar(3);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
	
        
        try { 
            driveSystemCANJaguarRight = new CANJaguar(2);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
	
        
//        driveSystemRobotDrive = new RobotDrive(driveSystemCANJaguarLeft, driveSystemCANJaguarRight);
//	
//        driveSystemRobotDrive.setSafetyEnabled(true);
//        driveSystemRobotDrive.setExpiration(0.1);
//        driveSystemRobotDrive.setSensitivity(0.5);
//        driveSystemRobotDrive.setMaxOutput(1.0);
        

        try { 
            shootSystemWheel1 = new CANJaguar(4);
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
            climbSystemClimbMotor1 = new CANJaguar(6);
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
	
        
        climbSystemBarSensor1 = new DigitalInput(1, 4);
	LiveWindow.addSensor("ClimbSystem", "Bar Sensor 1", climbSystemBarSensor1);
        
        climbSystemBarSensor2 = new DigitalInput(1, 5);
	LiveWindow.addSensor("ClimbSystem", "Bar Sensor 2", climbSystemBarSensor2);
        
        climbSystemBarSensor3 = new DigitalInput(1, 6);
	LiveWindow.addSensor("ClimbSystem", "Bar Sensor 3", climbSystemBarSensor3);
        
        climbSystemBarSensor4 = new DigitalInput(1, 7);
	LiveWindow.addSensor("ClimbSystem", "Bar Sensor 4", climbSystemBarSensor4);
        
        climbSystemBaseLimitSwitch = new DigitalInput(1, 8);
	LiveWindow.addSensor("ClimbSystem", "Base Limit Switch", climbSystemBaseLimitSwitch);
        
        try { 
            collectionSystemHarold = new CANJaguar(8);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
	
        
        tipSystemTipCompressor = new Compressor(1, 3, 1, 1);
	
        
        tipSystemTipperRelaySolenoid = new Relay(1, 2);
	LiveWindow.addActuator("TipSystem", "Tipper Relay Solenoid ", tipSystemTipperRelaySolenoid);
        
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
=======
    //TODO Clean up variable names
    //TODO Does the climb system still need to exist?
    //Camera System Components

    public static Relay lightRelay;
    public static AxisCamera camera;
    // Driving System Components

    public static CANJaguar driveSystemCANJaguarLeft;
    public static CANJaguar driveSystemCANJaguarRight;
    // Shooting System Components
    public static CANJaguar outerShooterWheel;
    public static CANJaguar innerShooterWheel;
    public static CANJaguar shootSystemAngleOfFire;
    public static AnalogChannel shootSystemMeasureAngleOfFire;
    // Collection System Components
    public static CANJaguar collectionSystemBrush1;
    public static DigitalInput loaderFiredSwitch;
    public static DigitalInput loaderRestSwitch;
    public static CANJaguar loaderMotor;
    public static DigitalInput loaderOpticalSensor;

    public static void init() {
        // Camera System Components
        camera = AxisCamera.getInstance();
        lightRelay = new Relay(1);


        // Drive System Components
        try {
            driveSystemCANJaguarLeft = new CANJaguar(7);
        } catch (CANTimeoutException ex) {
            if (Log.debug()) {
                Log.log(ex.toString());
            }
        }

        try {
            driveSystemCANJaguarRight = new CANJaguar(3);
        } catch (CANTimeoutException ex) {
            if (Log.debug()) {
                Log.log(ex.toString());
            }
        }

        // Shoot System Components
        try {
            outerShooterWheel = new CANJaguar(9);
        } catch (CANTimeoutException ex) {
            if (Log.debug()) {
                Log.log(ex.toString());
            }
        }

        try {
            innerShooterWheel = new CANJaguar(10);
        } catch (CANTimeoutException ex) {
            if (Log.debug()) {
                Log.log(ex.toString());
            }
        }

        try {
            shootSystemAngleOfFire = new CANJaguar(6);//temperarily changed: CHANGE BACK TO 5 
        } catch (CANTimeoutException ex) {
            if (Log.debug()) {
                Log.log(ex.toString());
            }
        }

        shootSystemMeasureAngleOfFire = new AnalogChannel(1);
        LiveWindow.addActuator("ShootSystem", "Angle Motor", shootSystemMeasureAngleOfFire);

        // Loader System Components

        loaderRestSwitch = new DigitalInput(1, 1);
        loaderFiredSwitch = new DigitalInput(1, 2);

        try {
            loaderMotor = new CANJaguar(4);
        } catch (CANTimeoutException ex) {
            if (Log.debug()) {
                Log.log(ex.toString());
            }
        }
>>>>>>> origin/temp-master
    }
}
