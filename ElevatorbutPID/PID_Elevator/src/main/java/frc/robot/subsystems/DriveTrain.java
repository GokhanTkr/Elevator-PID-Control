package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase{
    //Definitions
    PWMVictorSPX elevatorMotorLeft = new PWMVictorSPX(Constants.elevatorMotorPortLeft);
    PWMVictorSPX elevatorMotorRight = new PWMVictorSPX(Constants.elevatorMotorPortRight);

    DifferentialDrive Drive = new DifferentialDrive(elevatorMotorLeft,elevatorMotorRight);
    double pose;


    XboxController xboxController = new XboxController(Constants.XboxControllerPort);

    public Encoder elevatorEncoder = new Encoder(0,1);
    
    public PIDController pi_Controller = new PIDController(Constants.PID_kp,Constants.PID_ki,0);

    public void periodic(){
        pose = getEncoderReadings();
    }

    public double getPose(){
        return pose;
    }

    
    public double getEncoderReadings(){
        elevatorEncoder.setDistancePerPulse(2);
        return elevatorEncoder.getRate();
    }


    public void setOutput(double leftOutput, double rightOutput){
        elevatorMotorLeft.setVoltage(leftOutput);
        elevatorMotorRight.setVoltage(-rightOutput);
    }

    public DriveTrain(){
    }
    
}