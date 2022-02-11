package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;




public class Sendball extends SubsystemBase {
    VictorSPX  sendshootmotor = new VictorSPX(Constants.sendshootmotorno);
    VictorSPX  sendsmotor = new VictorSPX(Constants.sendmotorno);

    
    public Sendball(){
        sendshootmotor.configFactoryDefault();
        sendsmotor.configFactoryDefault();
    }
    public void Sendshootball(){
        sendshootmotor.set(ControlMode.PercentOutput,1);

    }
    public  void Sendshootballstop(){
        sendshootmotor.set(ControlMode.PercentOutput,0);
    }
    public void  send(){
        sendsmotor.set(ControlMode.PercentOutput,1);

    }

    public void sendstop(){
        sendsmotor.set(ControlMode.PercentOutput,0);

    }
    


  

}

