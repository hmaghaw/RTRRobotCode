package org.usfirst.frc2421.Neptune.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.CriteriaCollection;
import edu.wpi.first.wpilibj.image.NIVision.MeasurementType;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;
import edu.wpi.first.wpilibj.tables.ITable;
import org.usfirst.frc2421.Neptune.RobotMap;
import org.usfirst.frc2421.Neptune.utils.RobotUtils;
import org.usfirst.frc2421.Neptune.utils.Scores;

/**
 * TODO Description
 */
public class CameraSystem extends Subsystem {

    public final AxisCamera camera;
    public final CriteriaCollection cc;
    public Scores latestScores;
    public Relay lightRelay;
    public ParticleAnalysisReport latestReport;
    
    public int goalNumber; //0 = no goal, 1 = middle goal, 2 = high goal
    public String goalString;

    public CameraSystem() {
        camera = RobotMap.camera;  // get an instance of the camera
        //camera = AxisCamera.getInstance("10.24.21.11");
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
    
    public double getScoresData(String query, Scores score){
        query = query.toUpperCase();
        
        if(query.equals("rectangularity".toUpperCase())){
            return score.rectangularity;
        }
        else if(query.equals("aspectRatioInner".toUpperCase())){
            return score.aspectRatioInner;
        }
        else if(query.equals("aspectRatioOuter".toUpperCase())){
            return score.aspectRatioOuter;
        }
        else if(query.equals("xEdge".toUpperCase())){
            return score.xEdge;
        }
        else if(query.equals("yEdge".toUpperCase())){
            return score.yEdge;
        }
        else{
            return 0.0;
        }
    }
    
    public String getGoal(int goalNum) {
        if (goalNum == 2) {
            goalString = "high";
        }
        else if (goalNum == 1) {
            goalString = "middle";
        }
        else {
            goalString = "not a goal";
        }
        return goalString;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void refreshData() {
        RobotUtils.tryPutData("Head Light", lightRelay);
        RobotUtils.tryPutData("Goal", getGoal(goalNumber));
        
    }

}
