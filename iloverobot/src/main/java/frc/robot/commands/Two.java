// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ControlDrivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Sendball;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Tower;
import frc.robot.subsystems.trajectory.TrajectorySystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Two extends SequentialCommandGroup {
  /** Creates a new AutoAim. */
  public Two(ControlDrivetrain base, TrajectorySystem drivetrain,Tower tower,Intake intake,Shooter shooter ,Sendball sendball) {
    addCommands(new RunCommand(()->intake.intakego(), intake).withTimeout(30));
    addCommands(new RunCommand(()->sendball. brushtheball(), intake).withTimeout(30));
    addCommands(new RunCommand(()->tower.aimming(), tower).withTimeout(0.8));
    addCommands(new InstantCommand(()->tower.towerStop(), tower));
    addCommands(new RunCommand(()->shooter.shoot(), shooter).withTimeout(30));
  }
}