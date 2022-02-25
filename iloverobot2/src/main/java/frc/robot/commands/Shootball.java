// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Sendball;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Tower;

public class Shootball extends CommandBase{
    private Shooter shooter;
    private Sendball      sendball;
    public Shootball(Shooter shooter,Sendball sendball) {
        this.shooter=shooter;
        this.sendball= sendball;
        addRequirements(shooter, sendball);
    }
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        shooter.shoot();
        
        sendball.brushtheball();
        sendball.pullball();
    }
        
        // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        sendball.brushstop();
        shooter.stop();
        sendball.pullballstop();
    }
        
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}