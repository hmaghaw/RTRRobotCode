/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableGyro;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Giang
 */
public class DriveSystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public double driveFactor = 1;
    public double accumulator = 0;
    public double turnFactor = 1;
    public boolean factorMode = false;
    public double lower = 0;
    public double upper = 0;
    CANJaguar frTurn;
    CANJaguar flTurn;
    CANJaguar blTurn;
    CANJaguar brTurn;
    CANJaguar frCan;
    CANJaguar flCan;
    CANJaguar blCan;
    CANJaguar brCan;
    public double lastangle = 0;
    public int fcalls = 0;
    final AnalogChannel frPot = new AnalogChannel(RobotMap.frPot); //2
    final AnalogChannel flPot = new AnalogChannel(RobotMap.flPot); //1
    final AnalogChannel blPot = new AnalogChannel(RobotMap.blPot); //4
    final AnalogChannel brPot = new AnalogChannel(RobotMap.brPot); //3
    public double[] magnitude = new double[4]; //desired speed
    public double[] steering = new double[4];//steering speed
    public double[] angle = new double[4]; //desired angle
    public double[] currentAngle = new double[4]; //self-explanatory
    double wheelbase = 28; //wheelbase
    double trackwidth = 28.0; //track-width
    double R = Math.sqrt(MathUtils.pow(wheelbase, 2.0) + MathUtils.pow(trackwidth, 2.0));
    public SendableGyro driveGyro;
    public double Y, X, Twist;
    public double delta = 0;

    public DriveSystem() {
        boolean caughtexeption = true;
        while (caughtexeption) {
            try {
                if (frTurn == null) {
                    frTurn = new CANJaguar(RobotMap.frontrightWheelTurn, CANJaguar.ControlMode.kPercentVbus);
                    frTurn.enableControl();
                };
                if (flTurn == null) {
                    flTurn = new CANJaguar(RobotMap.frontleftWheelTurn, CANJaguar.ControlMode.kPercentVbus);
                    flTurn.enableControl();
                };
                if (blTurn == null) {
                    blTurn = new CANJaguar(RobotMap.backleftWheelTurn, CANJaguar.ControlMode.kPercentVbus);
                    blTurn.enableControl();
                };
                if (brTurn == null) {
                    brTurn = new CANJaguar(RobotMap.backrightWheelTurn, CANJaguar.ControlMode.kPercentVbus);
                    brTurn.enableControl();
                };
                if (frCan == null) {
                    frCan = new CANJaguar(RobotMap.frontrightWheelDrive, CANJaguar.ControlMode.kPercentVbus);
                    frCan.enableControl();

                };
                if (flCan == null) {
                    flCan = new CANJaguar(RobotMap.frontleftWheelDrive, CANJaguar.ControlMode.kPercentVbus);
                    flCan.enableControl();
                };
                if (blCan == null) {
                    blCan = new CANJaguar(RobotMap.backleftWheelDrive, CANJaguar.ControlMode.kPercentVbus);
                    blCan.enableControl();
                };
                if (brCan == null) {
                    brCan = new CANJaguar(RobotMap.backrightWheelDrive, CANJaguar.ControlMode.kPercentVbus);
                    brCan.enableControl();
                };
                caughtexeption = false;
            } catch (CANTimeoutException a) {
            }
        }
        driveGyro = new SendableGyro(1);
        driveGyro.reset();
    }
//to stop all wheel when on bridge

    public void stopWheel() {

        try {
            frTurn.setX(0);
            flTurn.setX(0);
            blTurn.setX(0);
            brTurn.setX(0);
            frCan.setX(0);
            flCan.setX(0);
            blCan.setX(0);
            brCan.setX(0);

        } catch (CANTimeoutException ex) {
        }
    }

    public void driveForward(double speed) {

        try {
            frTurn.setX(0);
            flTurn.setX(0);
            blTurn.setX(0);
            brTurn.setX(0);
            frCan.setX(speed);
            flCan.setX(speed);
            blCan.setX(speed);
            brCan.setX(speed);

        } catch (CANTimeoutException ex) {
            int b = 3;
        }
    }

    public void setWheel(double Y, double X, double RotationCW) {
        Y *= -1;
        //Cablibrate joystick.
        if (X > -0.1 && X < 0.1) {
            X = 0.0;
        }
        if (Y > -0.1 && Y < 0.1) {
            Y = 0.0;
        }
        if (RotationCW > -0.2 && RotationCW < 0.2) {
            RotationCW = 0.0;
        }
        // convert to field-centric...
        //accumulator = accumulator + delta;
//        double tempang = driveGyro.getAngle();
//        delta = tempang - lastangle;
//        if (-0.05 < delta && delta < 0.05) {
//            driveGyro.resetToAngle(lastangle);
//        } else {
//            lastangle = tempang;
//        }

//        double temp = FWD * Math.cos(lastangle) + STR * Math.sin(lastangle);
//        STR = -FWD * Math.sin(lastangle) + STR * Math.cos(lastangle);
//        FWD = temp;
        // Step A
        double A = X - RotationCW * (wheelbase / R); // Each of these determines
        double B = X + RotationCW * (wheelbase / R); //the x and y velocity of a
        double C = Y - RotationCW * (trackwidth / R); //wheel on the robot
        double D = Y + RotationCW * (trackwidth / R); // Because 2 wheels are in different positions around the robot
        // Determines velocity magnitude for each wheel
        // Step B
        magnitude[0] = Math.sqrt(MathUtils.pow(B, 2.0) + MathUtils.pow(C, 2.0)); //frontright
        magnitude[1] = Math.sqrt(MathUtils.pow(B, 2.0) + MathUtils.pow(D, 2.0)); //frontleft
        magnitude[2] = Math.sqrt(MathUtils.pow(A, 2.0) + MathUtils.pow(D, 2.0)); //backleft
        magnitude[3] = Math.sqrt(MathUtils.pow(A, 2.0) + MathUtils.pow(C, 2.0)); //backright
        // Turns the resolved x and y vectors for each wheel into an angle
        // Step C
        angle[0] = MathUtils.atan2(B, C) * 180 / Math.PI; //frontright
        angle[1] = MathUtils.atan2(B, D) * 180 / Math.PI; //frontleft
        angle[2] = MathUtils.atan2(A, D) * 180 / Math.PI; //backleft
        angle[3] = MathUtils.atan2(A, C) * 180 / Math.PI; //backright

        //convert -180 to 180 angle to 360 angle
        for (int f = 0; f < 4; f++) {
            if (angle[f] < 0) {
                angle[f] = angle[f] + 360;
            }
        }
        // Scales the wheel velocity
        double max = magnitude[0];
        if (magnitude[1] > max) {
            max = magnitude[1];
        }
        if (magnitude[2] > max) {
            max = magnitude[2];
        }
        if (magnitude[3] > max) {
            max = magnitude[3];
        }
        if (max > 1) {
            magnitude[0] /= max;
            magnitude[1] /= max;
            magnitude[2] /= max;
            magnitude[3] /= max;
        }
        // Minimizes wheel transition eg, a wheel at 45 angle going forward is 
        // the same a wheel going 125 backward
        for (int i = 0; i < 4; i++) {
            if (angle[i] > 90 && angle[i] < 180) {
                angle[i] = angle[i] + 180;
                magnitude[i] = magnitude[i] * -1;

            } else if (angle[i] >= 180 && angle[i] < 270) {
                angle[i] = angle[i] - 180;
                magnitude[i] = magnitude[i] * -1;
            }

        }
        // Grabs the encoder angles
        currentAngle[0] = (int) (frPot.getAverageVoltage() * 72);
        currentAngle[1] = (int) (flPot.getAverageVoltage() * 72);
        currentAngle[2] = (int) (blPot.getAverageVoltage() * 72);
        currentAngle[3] = (int) (brPot.getAverageVoltage() * 72);

        steering[0] = swerveTurn(currentAngle[0], angle[0]) * turnFactor;
        steering[1] = swerveTurn(currentAngle[1], angle[1]) * turnFactor;
        steering[2] = swerveTurn(currentAngle[2], angle[2]) * turnFactor;
        steering[3] = swerveTurn(currentAngle[3], angle[3]) * turnFactor;
        try {

            frTurn.setX(steering[0]);
            flTurn.setX(steering[1]);
            blTurn.setX(steering[2]);
            brTurn.setX(steering[3]);

        } catch (CANTimeoutException ex) {
            System.out.println("CANTimeOut!");
        }
        if (Math.abs(steering[0]) <= .25 && Math.abs(steering[1]) <= .25 && Math.abs(steering[2]) <= .25 && Math.abs(steering[3]) <= .25) {
            try {

                frCan.setX(magnitude[0] * driveFactor);
                flCan.setX(magnitude[1] * driveFactor);
                blCan.setX(magnitude[2] * driveFactor);
                brCan.setX(magnitude[3] * driveFactor);

            } catch (CANTimeoutException ex) {
            }
        } else {
            try {

                frCan.setX(0);
                flCan.setX(0);
                blCan.setX(0);
                brCan.setX(0);

            } catch (CANTimeoutException ex) {
            }
        }

    }
// returns the power needed to move from the wheels current angle to the target angle 
    public double swerveTurn(double currentAngle, double targetAngle) {
        double angleDifference = targetAngle - currentAngle;
        int reverseSpeed = 1;
        if (angleDifference > 180 || angleDifference < -180) {
            angleDifference = (360 - Math.abs(angleDifference)) * (angleDifference / Math.abs(angleDifference));
            reverseSpeed = -1;
        }

        if (angleDifference > 0) { //Scales speed?
            if (angleDifference > 30) {
                return 1 * reverseSpeed;
            } else if ((angleDifference < 30) && (angleDifference > 20)) {
                return 0.5 * reverseSpeed;
            } else if ((angleDifference < 20) && (angleDifference > 5)) {
                return 0.25 * reverseSpeed;
            } else {
                return 0;
            }
        } else {
            angleDifference = angleDifference * -1;
            if (angleDifference > 30) {
                return -1 * reverseSpeed;
            } else if ((angleDifference < 30) && (angleDifference > 20)) {
                return -0.5 * reverseSpeed;
            } else if ((angleDifference < 20) && (angleDifference > 5)) {
                return -0.25 * reverseSpeed;
            } else {
                return -0;
            }
        }

    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here. Something that sends current motor speeds to the dashboard?
        //setDefaultCommand(new MySpecialCommand());
    }
}
