// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.One;
import frc.robot.commands.Three;
import frc.robot.commands.TrajectoryCommand;
import frc.robot.commands.Two;
import frc.robot.subsystems.ControlDrivetrain;
import frc.robot.subsystems.Hangair;
import frc.robot.subsystems.Hangmotor;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Sendball;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Tower;
import frc.robot.subsystems.trajectory.TrajectoryDrivetrain;
import frc.robot.subsystems.trajectory.TrajectoryFactory;
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
  private Shooter shooter=new Shooter();
  private Intake intake=new Intake();
  private Hangair hangair=new Hangair();
  private Sendball sendball=new Sendball();
  private Hangmotor hangmotor=new Hangmotor();
  private Joystick stick = new Joystick(1);
  private Tower tower=new Tower();
  private XboxController xvideo=new XboxController(2);
  private final SendableChooser<Command> chooser = new SendableChooser<Command>();
  private ControlDrivetrain controlDrivetrain = new ControlDrivetrain();
  private TrajectoryDrivetrain trajectoryDrivetrain = new TrajectoryDrivetrain();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    Status();
    teleop();
    chooser();
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  public void chooser(){
    chooser.setDefaultOption("One", new One( controlDrivetrain, trajectoryDrivetrain,
                                               tower, intake, shooter , sendball));
    chooser.addOption("two", new Two( controlDrivetrain, trajectoryDrivetrain,
                                               tower, intake, shooter , sendball));
    chooser.addOption("three", new Three( controlDrivetrain, trajectoryDrivetrain,
                                               tower, intake, shooter , sendball));
  
    chooser.addOption("Null", null);
    //chooser.addOption("one", TrajectoryCommand.build(TrajectoryFactory.getTrajectory("output/test.wpilib.json"), trajectoryDrivetrain, TrajectoryCommand.OutputMode.VOLTAGE, trajectoryDrivetrain));
    SmartDashboard.putData(chooser);
  }
  private void configureButtonBindings() {
     // new JoystickButton(stick,1)                  .whenHeld(new RunCommand(()->controlDrivetrain.gogogo(),controlDrivetrain))
       //                                            .whenReleased(new InstantCommand(()->controlDrivetrain.gogogo(),controlDrivetrain));
    





    new JoystickButton(stick,1)           
                                                                          .whenHeld(new RunCommand(()->sendball.brushtheball(),sendball))                             
                                                                          .whenHeld(new RunCommand(()->shooter.shoot(),shooter))
                                                                          .whenReleased(new InstantCommand(()->shooter.stop(),shooter))
                                                                          .whenReleased(new InstantCommand(()->sendball.brushstop(),sendball));
    
    new JoystickButton(xvideo,Constants.Xbox.intakeinbutt)                .whenHeld(new InstantCommand(()->intake.intakego(),intake))
                                                                          .whenHeld(new InstantCommand(()->sendball.brushtheball(),sendball));
                                                                                                                                          

    new JoystickButton(xvideo,Constants.Xbox.intakeoutbutt)               .whenHeld(new InstantCommand(()->intake.intakeback(),intake))
                                                                          .whenHeld(new InstantCommand(()->sendball.brushstop(),sendball));

    new JoystickButton(xvideo,Constants.Xbox.hangairoutbutt)              .whenHeld(new InstantCommand(()->hangair.hangairout(),hangair));

    new JoystickButton(xvideo,Constants.Xbox.hangairinbutt)               .whenHeld(new InstantCommand(()->hangair.hangairin(),hangair));

    new JoystickButton(xvideo,Constants.Xbox.hangaupbutt )                .whenHeld(new RunCommand(()->hangmotor.hangup(),hangmotor))
                                                                          .whenReleased(new InstantCommand(()->hangmotor.hangupstop(),hangmotor));
      
    new JoystickButton(xvideo,Constants.Xbox.hangdownbutt)                .whenHeld(new RunCommand(()->hangmotor.hangdown(),hangmotor))
                                                                          .whenReleased(new InstantCommand(()->hangmotor.hangdownstop(),hangmotor));

    new JoystickButton(xvideo,8)                                          .whenHeld(new RunCommand(()->tower.towerForward(),tower))
                                                                          .whenReleased(new InstantCommand(()->tower.towerStop(),tower));

    new JoystickButton(xvideo,9)                                          .whenHeld(new RunCommand(()->tower.towerReverse(),hangmotor))
                                                                          .whenReleased(new InstantCommand(()->tower.towerStop(),tower));

  }
  public void teleop(){
  
    controlDrivetrain.setDefaultCommand(
      new RunCommand(()->
      controlDrivetrain.curvatureDrive(stick.getY() * 0.7, 
                                       stick.getZ() * 0.3, 
                                       stick.getTrigger(), 
                                       stick.getRawButton(2)),
        controlDrivetrain)
    );

  }
  public void Status(){

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
