package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;




public class Sendball extends SubsystemBase {
    VictorSPX  brushsmotor = new VictorSPX(Constants.brushmotorno);
//sendsmoror=brush
    
    public Sendball(){
        brushsmotor.configFactoryDefault();
    }

    public void  brushtheball(){
        brushsmotor.set(ControlMode.PercentOutput,1);

    }

    public void brushstop(){
        brushsmotor.set(ControlMode.PercentOutput,0);
    }
    


  

}

