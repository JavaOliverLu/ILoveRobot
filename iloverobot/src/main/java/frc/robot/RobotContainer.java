// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.ControlDrivetrain;
import frc.robot.subsystems.Hangair;
import frc.robot.subsystems.Hangmotor;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Sendball;
import frc.robot.subsystems.Shooottheball;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  Shooottheball ballball=new Shooottheball();
  Intake intake=new Intake();
  Hangair hangair=new Hangair();
  Sendball sendball=new Sendball();
  Hangmotor hangmotor=new Hangmotor();
  Joystick stick = new Joystick(1);
  XboxController xvideo=new XboxController(2);
 private ControlDrivetrain controlDrivetrain = new ControlDrivetrain();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    teleop();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
/*
      new JoystickButton(stick,Constants.Button.shootbutt)                  .whenHeld(new RunCommand(()->ballball.drivetheball(),ballball))
                                                                            .whenReleased(new InstantCommand(()->ballball.stoptheball(),ballball))
                                                                            .whenHeld(new RunCommand(()->sendball.sendshootball(),sendball))
                                                                            .whenReleased(new InstantCommand(()->sendball.sendshootballstop(),sendball))
                                                                            .whenHeld(new RunCommand(()->sendball.send(),sendball))
                                                                            .whenReleased(new InstantCommand(()->sendball.sendstop(),sendball));
     
      new JoystickButton(stick,Constants.Button.intakeinbutt)               .whenHeld(new InstantCommand(()->intake.intakego(),intake));

      new JoystickButton(stick,Constants.Button.intakeoutbutt)              .whenHeld(new InstantCommand(()->intake.intakeback(),intake));
      
      new JoystickButton(stick,Constants.Button.hangairoutbutt)             .whenHeld(new InstantCommand(()->hangair.hangairout(),hangair));

      new JoystickButton(stick,Constants.Button.hangairinbutt)              .whenHeld(new InstantCommand(()->hangair.hangairin(),hangair));

      new JoystickButton(stick,Constants.Button.hangaupbutt )               .whenHeld(new RunCommand(()->hangmotor.hangup(),hangmotor))
                                                                            .whenReleased(new InstantCommand(()->hangmotor.hangupstop(),hangmotor));
      
      new JoystickButton(stick,Constants.Button.hangdownbutt)               .whenHeld(new RunCommand(()->hangmotor.hangdown(),hangmotor))
                                                                            .whenReleased(new InstantCommand(()->hangmotor.hangdownstop(),hangmotor));
 */
                                                                          }
  public void teleop(){
    
    controlDrivetrain.setDefaultCommand(
      new RunCommand(()->
      controlDrivetrain.curvatureDrive(stick.getY() * 0.5, 
                                       stick.getZ() * 0.35, 
                                       stick.getTrigger(), 
                                       stick.getRawButton(4)),
        controlDrivetrain)
    );
  }
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  //public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
  
  //}
}
