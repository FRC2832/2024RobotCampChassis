// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import frc.robot.Constants;

import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cscore.VideoMode;
import edu.wpi.first.cscore.VideoSource.ConnectionStrategy;
import edu.wpi.first.util.PixelFormat;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class DriveCamera extends SubsystemBase {
  public final UsbCamera driveCamera; 
  /** Creates a new DriveCamera. */
  public DriveCamera() {
    driveCamera = new UsbCamera("USB Camera 0", 0);

    // driveCamera.setFPS(30);
    // driveCamera.setPixelFormat(Constants.DRIVE_CAMERERA_PIXEL_FORMAT);
    // driveCamera.setResolution(320, 240);
  
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
