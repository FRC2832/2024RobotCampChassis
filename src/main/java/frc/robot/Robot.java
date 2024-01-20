// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DataLogManager;
import edu.wpi.first.wpilibj.DriverStation;
// import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
// import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs
 * the motors with
 * tank steering.
 */
public class Robot extends TimedRobot {
    
    private final WPI_TalonSRX leftFrontMotor = new WPI_TalonSRX(1);
    private final WPI_TalonSRX rightFrontMotor = new WPI_TalonSRX(2);
    private final WPI_TalonSRX leftRearMotor = new WPI_TalonSRX(3);
    private final WPI_TalonSRX rightRearMotor = new WPI_TalonSRX(4);
    // private final MotorControllerGroup leftMotors = new MotorControllerGroup(leftFrontMotor, leftRearMotor);
    // private final MotorControllerGroup rightMotors = new MotorControllerGroup(rightFrontMotor, rightRearMotor);
    private DifferentialDrive robotDrive;
    //private final Joystick leftStick = new Joystick(0);
    //private final Joystick rightStick = new Joystick(1);

    private final XboxController driverController = new XboxController(0);

    @Override
    public void robotInit() {
       

        // We need to invert one side of the drivetrain so that positive voltages
        // result in both sides moving forward. Depending on how your robot's
        // gearbox is constructed, you might have to invert the left side instead.
        rightRearMotor.follow(rightFrontMotor);
        leftRearMotor.follow(leftFrontMotor);
        rightRearMotor.setInverted(InvertType.FollowMaster);
        leftRearMotor.setInverted(InvertType.FollowMaster);
        rightFrontMotor.setInverted(true);
        leftFrontMotor.setInverted(false);
        // rightMotors.setInverted(true);
        robotDrive = new DifferentialDrive(leftFrontMotor, rightFrontMotor);
    }

    @Override
    public void teleopInit() {
         // Starts recording to data log
         DataLogManager.start();
        
         
         // Record both DS control and joystick data
         DriverStation.startDataLog(DataLogManager.getLog());
    }

    @Override
    public void teleopPeriodic() {
        // Drive with tank drive.
        // That means that the Y axis of the left and right sticks control their
        // respective sides of the robot.
        // robotDrive.tankDrive(-leftStick.getY(), -rightStick.getY());
        if (driverController.getRightTriggerAxis() > 0.4) {
            robotDrive.tankDrive(-driverController.getLeftY()*0.8, -driverController.getRightY()*0.8);
        }
        else {
            robotDrive.tankDrive(-driverController.getLeftY()*0.4, -driverController.getRightY()*0.4);
        }
        

    }
}
