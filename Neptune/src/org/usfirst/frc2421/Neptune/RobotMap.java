package org.usfirst.frc2421.Neptune;

import com.sun.squawk.debugger.Log;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.camera.AxisCamera;
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
    //Camera System Components

    public static Relay lightRelay;
    public static AxisCamera camera;
    // Driving System Components
    public static CANJaguar driveSystemCANJaguarLeft;
    public static CANJaguar driveSystemCANJaguarRight;
    // Shooting System Components
    public static CANJaguar frontShooterWheel;
    public static CANJaguar backShooterWheel;
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
            driveSystemCANJaguarLeft = new CANJaguar(16);
        } catch (CANTimeoutException ex) {
            if (Log.debug()) {
                Log.log(ex.toString());
            }
        }

        try {
            driveSystemCANJaguarRight = new CANJaguar(16);
        } catch (CANTimeoutException ex) {
            if (Log.debug()) {
                Log.log(ex.toString());
            }
        }

        // Shoot System Components
        try {
            frontShooterWheel = new CANJaguar(3);
        } catch (CANTimeoutException ex) {
            if (Log.debug()) {
                Log.log(ex.toString());
            }
        }

        try {
            backShooterWheel = new CANJaguar(4);
        } catch (CANTimeoutException ex) {
            if (Log.debug()) {
                Log.log(ex.toString());
            }
        }

        try {
            shootSystemAngleOfFire = new CANJaguar(7);
        } catch (CANTimeoutException ex) {
            if (Log.debug()) {
                Log.log(ex.toString());
            }
        }

        shootSystemMeasureAngleOfFire = new AnalogChannel(10);
        LiveWindow.addActuator("ShootSystem", "Angle Motor", shootSystemMeasureAngleOfFire);

        // Loader System Components
        loaderRestSwitch = new DigitalInput(1, 1);
        loaderFiredSwitch = new DigitalInput(1, 2);

        try {
            loaderMotor = new CANJaguar(6);
        } catch (CANTimeoutException ex) {
            if (Log.debug()) {
                Log.log(ex.toString());
            }
        }
    }
}
