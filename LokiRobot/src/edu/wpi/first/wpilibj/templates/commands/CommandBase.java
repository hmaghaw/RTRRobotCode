package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.subsystems.CompressorSystem;
import edu.wpi.first.wpilibj.templates.subsystems.DriveSystem;
import edu.wpi.first.wpilibj.templates.subsystems.LeverSystem;
import edu.wpi.first.wpilibj.templates.subsystems.MassSystem;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use
 * CommandBase.exampleSubsystem
 *
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystem
        public static final CompressorSystem compressorSystem = new CompressorSystem();
    public static final DriveSystem driveSubsystem = new DriveSystem();
    public static final LeverSystem leverSubsystem = new LeverSystem();
    public static final MassSystem massSubSystem = new MassSystem();

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = OI.getInstance();
        new Thread() {

            public void run() {
                while (true) {
                    SmartDashboard.putDouble("Average Wheel Speed",
                            averageOfArray(CommandBase.driveSubsystem.magnitude));
                    SmartDashboard.putDouble("Drive Gyro",
                            CommandBase.driveSubsystem.driveGyro.getAngle());
                    SmartDashboard.putData("Mass Gyro",
                            CommandBase.massSubSystem.massGyro);

                    Timer.delay(.2);

                    SmartDashboard.putDouble("Front Right Angle",
                            CommandBase.driveSubsystem.currentAngle[0]);
                    SmartDashboard.putDouble("Front Left Angle",
                            CommandBase.driveSubsystem.currentAngle[1]);
                    SmartDashboard.putDouble("Back Left Angle",
                            CommandBase.driveSubsystem.currentAngle[2]);
                    SmartDashboard.putDouble("Back Right Angle",
                            CommandBase.driveSubsystem.currentAngle[3]);

                    Timer.delay(.2);

                    SmartDashboard.putInt("Drive Speed Percentage",
                            (int) (CommandBase.driveSubsystem.driveFactor * 100));
                    //SmartDashboard.putInt("Lever Speed Percentage",
                    //(int) (CommandBase.leverSubsystem.leverVictor.getSpeed() * 100));
                    SmartDashboard.putInt("Mass Speed Percentage",
                            (int) (CommandBase.massSubSystem.getMassSpeed() * 100));
                    Timer.delay(.2);
                    SmartDashboard.putDouble("Raw Angle", driveSubsystem.driveGyro.getAngle());
                    SmartDashboard.putDouble("Delta", driveSubsystem.delta);
                    SmartDashboard.putDouble("Last Angle", driveSubsystem.lastangle);
                }
            }
        }.start();
    }

    private static double averageOfArray(final double[] dubarray) {
        double finalResult = 0;
        for (int i = 0; i < dubarray.length; i++) {
            finalResult += dubarray[i];
        }
        if (finalResult == 0 || dubarray.length == 0) {
            return 0;
        } else {
            return finalResult / dubarray.length;

        }
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
