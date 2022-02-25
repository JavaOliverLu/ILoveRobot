package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;




public class Sendball extends SubsystemBase {
    private VictorSPX  brushsmotor = new VictorSPX(Constants.brushmotorno);
    private VictorSPX  sendshootmotor = new VictorSPX(Constants.sendshootmotorno);

//sendsmoror=brush
    
    public Sendball(){
        sendshootmotor.configFactoryDefault();
        brushsmotor.configFactoryDefault();
    }

    public void  brushtheball(){
        brushsmotor.set(ControlMode.PercentOutput,0.7);

    }
    public void pullball(){
        sendshootmotor.set(ControlMode.PercentOutput,0);

    }
    public void brushstop(){
        brushsmotor.set(ControlMode.PercentOutput,0);
    }
    public void pullballstop(){
        sendshootmotor.set(ControlMode.PercentOutput,-0.6);

    }


  

}

