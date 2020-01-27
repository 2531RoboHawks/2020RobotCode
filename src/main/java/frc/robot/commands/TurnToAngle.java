/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class TurnToAngle extends Command {
  double deg;
  /**
   * Creates a new TurnToAngle.
   */
  public TurnToAngle(double deg) {
    this.deg = deg;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double angle = RobotMap.gyro.getAngle();
    
    if(angle - deg > 5 || angle - deg < -5) {
    if( angle >= deg) {
      Robot.m_subsystem.coast(-0.75, 0);
    }
    if(RobotMap.gyro.getAngle() <= deg) {
      Robot.m_subsystem.coast(0.75, 0);
    }
  }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end() {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
