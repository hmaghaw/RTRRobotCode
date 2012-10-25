package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    //Victors slots #...turn
    public static final int frontrightWheelTurn = 6,
            frontleftWheelTurn = 7,
            backleftWheelTurn = 8,
            backrightWheelTurn = 9;
    //Canjaguar slots #...drive
    public static final int frontrightWheelDrive = 3,
            frontleftWheelDrive = 2,
            backleftWheelDrive = 5,
            backrightWheelDrive = 4;
    //Encoder analog channels #...
    public static final int frPot = 5, //2,
            flPot = 4, //1,
            blPot = 7, //4,
            brPot = 6; //3;
    public static final int massSlot = 10;
    public static final int forwardchannel = 1;
    public static final int reversechannel = 2;
    public static final int pressureRelay = 4;
    public static final int pressureSwitch = 1;
}
