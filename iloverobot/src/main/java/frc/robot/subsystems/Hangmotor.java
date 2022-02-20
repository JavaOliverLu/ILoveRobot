package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Hangmotor extends SubsystemBase {
    TalonFX hangleftmotor=new TalonFX(Constants.hangleftmotorno);
    TalonFX hangrightmotor=new TalonFX(Constants.hangrightmotorno);

    public  Hangmotor(){
        hangleftmotor.configFactoryDefault();
        hangrightmotor.configFactoryDefault();
        hangrightmotor.follow(hangleftmotor);
    }

    
    public void  hangup(){
        hangleftmotor.set(ControlMode.PercentOutput,1);
    }

    public void  hangupstop(){
        hangleftmotor.set(ControlMode.PercentOutput,0);

    }

    public void  hangdown(){
        hangleftmotor.set(ControlMode.PercentOutput,-1);

    }

    public void  hangdownstop(){
        hangleftmotor.set(ControlMode.PercentOutput,0);

    }
}
//4m  0.55
//m
//m