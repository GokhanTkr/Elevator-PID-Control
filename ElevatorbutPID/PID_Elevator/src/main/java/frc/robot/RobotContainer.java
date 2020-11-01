
package frc.robot;

import frc.robot.subsystems.DriveTrain;

public class RobotContainer {

  DriveTrain drive = new DriveTrain();

  


  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }


  private void configureButtonBindings() {
  }

  public void elevatorUp(){
    double distance = drive.getPose();
    double distanceP = distance / 220;
    double voltage = 1 - distanceP;
    drive.setOutput(voltage, voltage);
  }

  public void elevatorDown(){
    double distance = drive.getPose();
    double distanceP = distance / 220;
    double voltage = 1 - distanceP;
    drive.setOutput(-voltage, -voltage);
  }


}
