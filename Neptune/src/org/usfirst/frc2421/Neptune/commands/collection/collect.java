package org.usfirst.frc2421.Neptune.commands.collection;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2421.Neptune.Robot;

/**
 *
 * @author Kal
 */
public class collect extends Command {

    
    public boolean loading;
    public boolean end;

    public collect() {
        requires(Robot.collectionSystem);
        loading = true;
        end = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {

        if (loading == true && Robot.collectionSystem.getSwitch2() == false) {
            Robot.collectionSystem.goMotor(.5);
        }
        
        else if (Robot.collectionSystem.getSwitch2() == true ) {
            Robot.collectionSystem.stopMotor();
            loading = false;
        }    
        
                
        else if (Robot.collectionSystem.getSwitch2() && !loading) {
                Robot.collectionSystem.goMotor(-.5);
            }
        else if (!Robot.collectionSystem.getSwitch() && !loading)
            Robot.collectionSystem.stopMotor();
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
