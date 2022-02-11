package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.Value;




public class Shooottheball extends SubsystemBase {
    private static TalonFX shootballleftmotor = new TalonFX(16);
    private static TalonFX shootballrightmotor = new TalonFX(16);
    private SupplyCurrentLimitConfiguration supplyCurrentLimitConfiguration = new SupplyCurrentLimitConfiguration(true, 40, 50, 0.8);

    public  Shooottheball(){
        shootballleftmotor.configFactoryDefault();
        shootballrightmotor.configFactoryDefault();
        
        //set sensor
        shootballleftmotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor,0,Constants.kTimesOut);
        shootballrightmotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, Constants.kTimesOut);
        
        //adjust kP
        shootballleftmotor.config_kP(0,Value.fly_kp);
        shootballrightmotor.config_kP(0,Value.fly_kp);
        shootballleftmotor.config_kD(0, Value.fly_kD);
        shootballrightmotor.config_kD(0, Value.fly_kD);
        //PeakOutput , CurrentLimit , NeutralDeadband 
        shootballleftmotor.configPeakOutputForward(1, Constants.kTimesOut);
        shootballleftmotor.configPeakOutputReverse(0, Constants.kTimesOut);
        shootballrightmotor.configPeakOutputForward(1, Constants.kTimesOut);
        shootballrightmotor.configPeakOutputReverse(0, Constants.kTimesOut);
        shootballleftmotor.configSupplyCurrentLimit(supplyCurrentLimitConfiguration);
        shootballrightmotor.configSupplyCurrentLimit(supplyCurrentLimitConfiguration);
        //shootballleftmotor.configNominalOutputForward(0,10);
        //shootballrightmotor.configNominalOutputForward(0,10);
        shootballleftmotor.setNeutralMode(NeutralMode.Coast);
        shootballrightmotor.setNeutralMode(NeutralMode.Coast);
        shootballleftmotor.configNeutralDeadband(0.005,Constants.kTimesOut);
        shootballrightmotor.configNeutralDeadband(0.005,Constants.kTimesOut);
        
        //Closedloop,Openedloop
        shootballleftmotor.configClosedloopRamp(1, Constants.kTimesOut);
        shootballrightmotor.configClosedloopRamp(1, Constants.kTimesOut);
        
        //InvertType
        shootballrightmotor.follow(shootballleftmotor);
        shootballleftmotor.setInverted(false);
        shootballrightmotor.setInverted(InvertType.OpposeMaster);
    
        //test mode
        //shootballleftmotor.configVoltageCompSaturation(11);
        //shootballrightmotor.configVoltageCompSaturation(11);
        shootballleftmotor.configVoltageMeasurementFilter(11);
        shootballrightmotor.configVoltageMeasurementFilter(11);
        
        //shootballleftmotor.enableVoltageCompensation(false);
        //shootballrightmotor.enableVoltageCompensation(false);
    
    }
    public void drivetheball(){
        shootballrightmotor.follow(shootballleftmotor);

        //測距離
        if(Limelight.getdistances()<=80){
          shootballleftmotor.config_kF(0, 0.05);
          shootballrightmotor.config_kF(0, 0.05);
          shootballleftmotor.set(ControlMode.Velocity, 8000);
        }
        else if(Limelight.getdistances() <= 119) {
          shootballleftmotor.config_kF(0, Constants.Value.fly_kFCLOSE);
          shootballrightmotor.config_kF(0, Constants.Value.fly_kFCLOSE);
          shootballleftmotor.set(ControlMode.Velocity, Constants.Value.fly_speedCLOSE);
        }else if(Limelight.getdistances() <=140){
          shootballleftmotor.config_kF(0, Constants.Value.fly_kFAR);
          shootballrightmotor.config_kF(0, Constants.Value.fly_kFAR);
          shootballleftmotor.set(ControlMode.Velocity, Constants.Value.fly_speedFAR);
        }
    }// }else{
        //   shootballleftmotor.config_kF(0, Constants.Value.fly_kFAR);
        //   shootballrightmotor.config_kF(0, Constants.Value.fly_kFAR);
        //   shootballleftmotor.set(ControlMode.Velocity, 12500);
        // }
          //else{
        //   shootballleftmotor.config_kF(0, 0.05);
        //   shootballrightmotor.config_kF(0, 0.05);
        //   shootballleftmotor.set(ControlMode.Velocity, 11800);
        // }    }
    public void stoptheball(){
        shootballleftmotor.set(ControlMode.PercentOutput,0);
        shootballrightmotor.set(ControlMode.PercentOutput,0);

    }

}
//4m  0.55
//m
//m