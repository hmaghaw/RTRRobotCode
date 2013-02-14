package org.usfirst.frc2421.Neptune.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.tables.ITable;


/**
 * TODO Description
 */
public class CameraSystem extends Subsystem {

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {

        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public ITable getTable(){
        ITable table = super.getTable();
        return table;
    }
}

