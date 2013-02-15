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
    // Driving System Components
    public static CANJaguar driveSystemCANJaguarLeft;
    public static CANJaguar driveSystemCANJaguarRight;
    
    // Shooting System Components
    public static CANJaguar shootSystemWheel1;
    public static CANJaguar shootSystemWheel2;
    public static CANJaguar shootSystemAngleOfFire;
    public static AnalogChannel shootSystemMeasureAngleOfFire;

    // Collection System Components
    public static CANJaguar collectionSystemBrush1;
    public static DigitalInput loaderFiredSwitch;
    public static DigitalInput loaderRestSwitch;
    public static CANJaguar loaderMotor;
    public static DigitalInput loaderOpticalSensor;

    public static void init() {
        try {
            driveSystemCANJaguarLeft = new CANJaguar(3);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace(); //We should really do better than just 
        }

        try {
            driveSystemCANJaguarRight = new CANJaguar(2);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }

        try {
            shootSystemWheel1 = new CANJaguar(4);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }

        try {
            shootSystemWheel2 = new CANJaguar(6);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        
        try { 
            shootSystemAngleOfFire = new CANJaguar(7);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }

        shootSystemMeasureAngleOfFire = new AnalogChannel(10);
        LiveWindow.addActuator("ShootSystem", "Angle Motor", shootSystemMeasureAngleOfFire);
       
        loaderRestSwitch = new DigitalInput(1,1);
        loaderFiredSwitch = new DigitalInput(1,2);
        
        try {
            loaderMotor = new CANJaguar(3);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
}
