/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Driver
 */
public class CompressorSystem extends Subsystem {

    public Compressor compressor; //Only used in pit, to compress air canisters

    public CompressorSystem() {
        compressor = new Compressor(RobotMap.pressureSwitch, RobotMap.pressureRelay);
        compressor.start();
    }

    protected void initDefaultCommand() {
    }
}
