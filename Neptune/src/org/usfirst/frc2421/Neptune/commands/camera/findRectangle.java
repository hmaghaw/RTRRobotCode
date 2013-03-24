/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc2421.Neptune.commands.camera;

import com.sun.squawk.debugger.Log;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;
import org.usfirst.frc2421.Neptune.Robot;
import org.usfirst.frc2421.Neptune.utils.CameraUtilities;
import org.usfirst.frc2421.Neptune.utils.Scores;

/**
 *
 * @author Jack
 */
public class findRectangle extends Command{

    boolean end;
    
    public findRectangle() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        end = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (Robot.cameraSystem.camera.freshImage()) {
            try {
                /**
                 * Do the image capture with the camera and apply the algorithm
                 * described above. This sample will either get images from the
                 * camera or from an image file stored in the top level
                 * directory in the flash memory on the cRIO. The file name in
                 * this case is "testImage.jpg"
                 *
                 */
                ColorImage image = Robot.cameraSystem.camera.getImage();     // comment if using stored images
                BinaryImage thresholdImage = image.thresholdHSV(60, 150, 90, 255, 20, 255);   // keep only red objects
                BinaryImage convexHullImage = thresholdImage.convexHull(false);          // fill in occluded rectangles
                BinaryImage filteredImage = convexHullImage.particleFilter(Robot.cameraSystem.cc);           // filter out small particles

                //iterate through each particle and score to see if it is a target
                Scores scores[] = new Scores[filteredImage.getNumberParticles()];
                for (int i = 0; i < scores.length; i++) {
                    ParticleAnalysisReport report = filteredImage.getParticleAnalysisReport(i);
                    scores[i] = new Scores();

                    scores[i].rectangularity = CameraUtilities.scoreRectangularity(report);
                    scores[i].aspectRatioOuter = CameraUtilities.scoreAspectRatio(filteredImage, report, i, true);
                    scores[i].aspectRatioInner = CameraUtilities.scoreAspectRatio(filteredImage, report, i, false);
                    scores[i].xEdge = CameraUtilities.scoreXEdge(thresholdImage, report);
                    scores[i].yEdge = CameraUtilities.scoreYEdge(thresholdImage, report);

                    if (CameraUtilities.scoreCompare(scores[i], false)) {
                        Robot.cameraSystem.latestScores = scores[i];
                    } else if (CameraUtilities.scoreCompare(scores[i], true)) {
                        Robot.cameraSystem.latestScores = scores[i];
                    } else {
                        if (true) {//TODO change this back to log.verbose
                            Log.log("particle: " + i + "is not a goal  centerX: " + report.center_mass_x_normalized + "centerY: " + report.center_mass_y_normalized);
                        }
                    }
                    if (true) { //TODO change this back to log.verbose
                        Log.log(" rect: " + scores[i].rectangularity + "ARinner: " + scores[i].aspectRatioInner);
                        System.out.println(" ARouter: " + scores[i].aspectRatioOuter + " xEdge: " + scores[i].xEdge + " yEdge: " + scores[i].yEdge);
                    }
                }

                /**
                 * all images in Java must be freed after they are used since
                 * they are allocated out of C data structures. Not calling
                 * free() will cause the memory to accumulate over each pass of
                 * this loop.
                 */
                filteredImage.free();
                convexHullImage.free();
                thresholdImage.free();
                image.free();

            } catch (AxisCameraException ex) {        // this is needed if the camera.getImage() is called
                if (Log.debug()) {
                    Log.log(ex.toString());
                }
            } catch (NIVisionException ex) {
                if (Log.debug()) {
                    Log.log(ex.toString());
                }

            }
        }
        end = true;
    }
// Make this return true when this Command no longer needs to run execute()

    protected boolean isFinished() {
        return end;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
