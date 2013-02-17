package org.usfirst.frc2421.Neptune.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.CriteriaCollection;
import edu.wpi.first.wpilibj.image.NIVision.MeasurementType;
import edu.wpi.first.wpilibj.tables.ITable;
import org.usfirst.frc2421.Neptune.RobotMap;
import org.usfirst.frc2421.Neptune.utils.Scores;

/**
 * TODO Description
 */
public class CameraSystem extends Subsystem {

    public final AxisCamera camera;
    public final CriteriaCollection cc;
    public Scores latestScores;
    public Relay lightRelay;

    public CameraSystem() {
        camera = RobotMap.camera;  // get an instance of the camera
        lightRelay = RobotMap.lightRelay;
        cc = new CriteriaCollection();      // create the criteria for the particle filter
        cc.addCriteria(MeasurementType.IMAQ_MT_AREA, 500, 65535, false);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void toggleLight() {
        if (lightRelay.get() == Relay.Value.kOff) {
            lightRelay.set(Relay.Value.kOn);
        } else {
            lightRelay.set(Relay.Value.kOff);
        }

    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public ITable getTable() {
        ITable table = super.getTable();
        return table;
    }
}
