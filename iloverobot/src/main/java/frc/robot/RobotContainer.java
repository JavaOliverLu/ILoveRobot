// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.ControlDrivetrain;
import frc.robot.subsystems.Hangair;
import frc.robot.subsystems.Hangmotor;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Sendball;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Tower;
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
  Shooter shooter=new Shooter();
  Intake intake=new Intake();
  Hangair hangair=new Hangair();
  Sendball sendball=new Sendball();
  Hangmotor hangmotor=new Hangmotor();
  Joystick stick = new Joystick(1);
  Tower tower=new Tower();
  XboxController xvideo=new XboxController(2);
private final SendableChooser<Command> chooser = new SendableChooser<Command>();
 private ControlDrivetrain controlDrivetrain = new ControlDrivetrain();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    Status();
    teleop();
    chooser();
   // Compressor();
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  public void chooser(){
    //chooser.setDefaultOption("LeftUp", new LeftUp(controlDrivetrain, trajectoryDrivetrain, 
  //                                         m_Racker, m_tower, m_Intake, 
    //                                       m_Wing, m_Shooter, m_Conveyor, m_arm));
    //chooser.addOption("Move", new Move(controlDrivetrain));
    chooser.addOption("Null", null);
    // chooser.addOption("one", TrajectoryCommand.build(TrajectoryFactory.getTrajectory("output/test.wpilib.json"), trajectoryDrivetrain, TrajectoryCommand.OutputMode.VOLTAGE, trajectoryDrivetrain));
    SmartDashboard.putData(chooser);
  }
  private void configureButtonBindings() {
     // new JoystickButton(stick,1)                  .whenHeld(new RunCommand(()->controlDrivetrain.gogogo(),controlDrivetrain))
       //                                            .whenReleased(new InstantCommand(()->controlDrivetrain.gogogo(),controlDrivetrain));
    





      new JoystickButton(xvideo,1)                                         .whenHeld(new RunCommand(()->shooter.shoot(),shooter))
                                                                           .whenHeld(new RunCommand(()->sendball.brushtheball(),sendball))
                                                                          .whenReleased(new InstantCommand(()->shooter.stop(),shooter))
                                                                          .whenReleased(new InstantCommand(()->sendball.brushstop(),sendball));
     
     new JoystickButton(xvideo,Constants.Button.intakeinbutt)              .whenHeld(new InstantCommand(()->intake.intakego(),intake))
                                                                           .whenHeld(new RunCommand(()->sendball.brushtheball(),sendball));
                                                                                                                                          

     new JoystickButton(xvideo,Constants.Button.intakeoutbutt)             .whenHeld(new InstantCommand(()->intake.intakeback(),intake))
                                                                           .whenHeld(new RunCommand(()->sendball.brushstop(),sendball));

     new JoystickButton(xvideo,Constants.Button.hangairoutbutt)            .whenHeld(new InstantCommand(()->hangair.hangairout(),hangair));

      new JoystickButton(xvideo,Constants.Button.hangairinbutt)            .whenHeld(new InstantCommand(()->hangair.hangairin(),hangair));

      new JoystickButton(xvideo,Constants.Button.hangaupbutt )             .whenHeld(new RunCommand(()->hangmotor.hangup(),hangmotor))
                                                                           .whenReleased(new InstantCommand(()->hangmotor.hangupstop(),hangmotor));
      
      new JoystickButton(xvideo,Constants.Button.hangdownbutt)            .whenHeld(new RunCommand(()->hangmotor.hangdown(),hangmotor))
                                                                           .whenReleased(new InstantCommand(()->hangmotor.hangdownstop(),hangmotor));

     new JoystickButton(xvideo,Constants.Button.hangdownbutt)             .whenHeld(new RunCommand(()->tower.towerForward(),tower))
                                                                           .whenReleased(new InstantCommand(()->tower.towerStop(),tower));

     new JoystickButton(xvideo,Constants.Button.hangdownbutt)              .whenHeld(new RunCommand(()->tower.towerReverse(),hangmotor))
                                                                           .whenReleased(new InstantCommand(()->tower.towerStop(),tower));

  }
  public void teleop(){
  /*
    controlDrivetrain.setDefaultCommand(
      new RunCommand(()->
      controlDrivetrain.curvatureDrive(stick.getY() * 0.7, 
                                       stick.getZ() * 0.3, 
                                       stick.getTrigger(), 
                                       stick.getRawButton(1)),
        controlDrivetrain)
    );
*/
  }
  public void Status(){

  }
 // public void Compressor() {
   // hangair.enable();
  //}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  //public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
  
  //}
}
