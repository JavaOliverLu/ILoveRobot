package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;




public class Shooter extends SubsystemBase {
    private TalonFX shootermaster = new TalonFX(Constants.shootermasterno);
    private TalonFX shooterslaver = new TalonFX(Constants.shooterslaverno);
    private VictorSPX  sendshootmotor = new VictorSPX(Constants.sendshootmotorno);

    private SupplyCurrentLimitConfiguration currentLimit
             = new SupplyCurrentLimitConfiguration(true, 40, 50, 0.8);
    
    public  Shooter(){
        shootermaster.configFactoryDefault();
        sendshootmotor.configFactoryDefault();
        shooterslaver.follow(shootermaster);
        shooterslaver.setInverted(TalonFXInvertType.OpposeMaster);
        shootermaster.config_kF(0, 0.048);
        shootermaster.config_kP(0, 0.04);
        shootermaster.config_kD(0, 0.02);
        shootermaster.setInverted(true);
        shootermaster.setSensorPhase(true);
        shootermaster.configVoltageCompSaturation(9.8);
        shootermaster.configPeakOutputForward(1, 100);
        shootermaster.configPeakOutputReverse(0, 100);
        shootermaster.configPeakOutputForward(1, 100);
        shootermaster.configPeakOutputReverse(0, 100);
        shootermaster.configSupplyCurrentLimit(currentLimit);
        shootermaster.setNeutralMode(NeutralMode.Coast);
        shootermaster.configNeutralDeadband(0.03, 100);
    }

    public void shoot(){/*
      if(Limelight.getdistances()<=80){
        if(DriverStation.getAlliance() == Alliance.Blue){
          shootermaster.config_kF(0, 0.05);
          shooterslaver.config_kF(0, 0.05);
          shootermaster.set(ControlMode.Velocity, 8000);
          if(shootermaster.getSelectedSensorVelocity()==8000){
            sendshootmotor.set(ControlMode.PercentOutput,1);
          }
        }
        else if(DriverStation.getAlliance() == Alliance.Red){
          shootermaster.set(ControlMode.Velocity, 2000);
          sendshootmotor.set(ControlMode.PercentOutput,1);
        }
      }

      else if(Limelight.getdistances()<=80){
        if(DriverStation.getAlliance() == Alliance.Blue){
          shootermaster.config_kF(0, 0.05);
          shooterslaver.config_kF(0, 0.05);
          shootermaster.set(ControlMode.Velocity, 8000);
          if(shootermaster.getSelectedSensorVelocity()==8000){
            sendshootmotor.set(ControlMode.PercentOutput,1);
          }
        }
        else if(DriverStation.getAlliance() == Alliance.Red){
          shootermaster.set(ControlMode.Velocity, 2000);
          sendshootmotor.set(ControlMode.PercentOutput,1);
        }
      }

      else if(Limelight.getdistances()<=80){
        if(DriverStation.getAlliance() == Alliance.Blue){
          shootermaster.config_kF(0, 0.05);
          shooterslaver.config_kF(0, 0.05);
          shootermaster.set(ControlMode.Velocity, 8000);
          if(shootermaster.getSelectedSensorVelocity()==8000){
            sendshootmotor.set(ControlMode.PercentOutput,1);
          }
        }
        else if(DriverStation.getAlliance() == Alliance.Red){
          shootermaster.set(ControlMode.Velocity, 2000);
          sendshootmotor.set(ControlMode.PercentOutput,1);
        }
      }

      else if(Limelight.getdistances()<=80){
        if(DriverStation.getAlliance() == Alliance.Blue){
          shootermaster.config_kF(0, 0.05);
          shooterslaver.config_kF(0, 0.05);
          shootermaster.set(ControlMode.Velocity, 8000);
          if(shootermaster.getSelectedSensorVelocity()==8000){
            sendshootmotor.set(ControlMode.PercentOutput,1);
          }
        }
        else if(DriverStation.getAlliance() == Alliance.Red){
          shootermaster.set(ControlMode.Velocity, 2000);
          sendshootmotor.set(ControlMode.PercentOutput,1);
        }
      }

      else if(Limelight.getdistances()<=80){
        if(DriverStation.getAlliance() == Alliance.Blue){
          shootermaster.config_kF(0, 0.05);
          shooterslaver.config_kF(0, 0.05);
          shootermaster.set(ControlMode.Velocity, 8000);
          if(shootermaster.getSelectedSensorVelocity()==8000){
            sendshootmotor.set(ControlMode.PercentOutput,1);
          }
        }
        else if(DriverStation.getAlliance() == Alliance.Red){
          shootermaster.set(ControlMode.Velocity, 2000);
          sendshootmotor.set(ControlMode.PercentOutput,1);
        }
      }

      else if(Limelight.getdistances()<=80){
        if(DriverStation.getAlliance() == Alliance.Blue){
          shootermaster.config_kF(0, 0.05);
          shooterslaver.config_kF(0, 0.05);
          shootermaster.set(ControlMode.Velocity, 8000);
          if(shootermaster.getSelectedSensorVelocity()==8000){
            sendshootmotor.set(ControlMode.PercentOutput,1);
          }
        }
        else if(DriverStation.getAlliance() == Alliance.Red){
          shootermaster.set(ControlMode.Velocity, 2000);
          sendshootmotor.set(ControlMode.PercentOutput,1);
        }
      }

      else if(Limelight.getdistances()<=80){
        if(DriverStation.getAlliance() == Alliance.Blue){
          shootermaster.config_kF(0, 0.05);
          shooterslaver.config_kF(0, 0.05);
          shootermaster.set(ControlMode.Velocity, 8000);
          if(shootermaster.getSelectedSensorVelocity()==8000){
            sendshootmotor.set(ControlMode.PercentOutput,1);
          }
        }
        else if(DriverStation.getAlliance() == Alliance.Red){
          shootermaster.set(ControlMode.Velocity, 2000);
          sendshootmotor.set(ControlMode.PercentOutput,1);
        }
      }

      else if(Limelight.getdistances()<=80){
        if(DriverStation.getAlliance() == Alliance.Blue){
          shootermaster.config_kF(0, 0.05);
          shooterslaver.config_kF(0, 0.05);
          shootermaster.set(ControlMode.Velocity, 8000);
          if(shootermaster.getSelectedSensorVelocity()==8000){
            sendshootmotor.set(ControlMode.PercentOutput,1);
          }
        }
        else if(DriverStation.getAlliance() == Alliance.Red){
          shootermaster.set(ControlMode.Velocity, 2000);
          sendshootmotor.set(ControlMode.PercentOutput,1);
        }
      }

      else if(Limelight.getdistances()<=80){
        if(DriverStation.getAlliance() == Alliance.Blue){
          shootermaster.config_kF(0, 0.05);
          shooterslaver.config_kF(0, 0.05);
          shootermaster.set(ControlMode.Velocity, 8000);
          if(shootermaster.getSelectedSensorVelocity()==8000){
            sendshootmotor.set(ControlMode.PercentOutput,1);
          }
        }
        else if(DriverStation.getAlliance() == Alliance.Red){
          shootermaster.set(ControlMode.Velocity, 2000);
          sendshootmotor.set(ControlMode.PercentOutput,1);
        }
      }

      else if(Limelight.getdistances()<=80){
        if(DriverStation.getAlliance() == Alliance.Blue){
          shootermaster.config_kF(0, 0.05);
          shooterslaver.config_kF(0, 0.05);
          shootermaster.set(ControlMode.Velocity, 8000);
          if(shootermaster.getSelectedSensorVelocity()==8000){
            sendshootmotor.set(ControlMode.PercentOutput,1);
          }
        }
        else if(DriverStation.getAlliance() == Alliance.Red){
          shootermaster.set(ControlMode.Velocity, 2000);
          sendshootmotor.set(ControlMode.PercentOutput,1);
        }
      }

*/
shootermaster.set(ControlMode.Velocity, 2000);

    }

    public void stop(){
        shootermaster.set(ControlMode.PercentOutput, 0);

    }
    @Override
    public void periodic() {
      SmartDashboard.putNumber("flyvel", shootermaster.getSelectedSensorVelocity(0));
      if(Limelight.getdistances() < 80&&7700<shootermaster.getSelectedSensorVelocity()&&9200>shootermaster.getSelectedSensorVelocity()){
        SmartDashboard.putBoolean("YouCanShoot", true);
      }else if (Limelight.getdistances() < 130&&9500<shootermaster.getSelectedSensorVelocity()&&12000>shootermaster.getSelectedSensorVelocity()){
        SmartDashboard.putBoolean("YouCanShoot", true);
      }else if (Limelight.getdistances() > 130&&10200<shootermaster.getSelectedSensorVelocity()&&13200>shootermaster.getSelectedSensorVelocity()){
        SmartDashboard.putBoolean("YouCanShoot", true);
      }else {
        SmartDashboard.putBoolean("YouCanShoot", false);
      }
    }

}