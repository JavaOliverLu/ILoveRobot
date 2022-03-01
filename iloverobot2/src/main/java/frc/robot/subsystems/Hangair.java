package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;




public class Hangair extends SubsystemBase {
    //protected static Compressor intakecompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
    private final DoubleSolenoid hangdoubleSolenoid =new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
    public  Hangair(){
      Intake.enablecompressor();
    }

    public void hangairout(){ 
          hangdoubleSolenoid.set(DoubleSolenoid.Value.kForward);
      }

      public void enable(){
        //intakecompressor.setClosedLoopControl(true);
      }

        
    public void hangairin(){        
      hangdoubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    }


}
//4m  0.55
//m
//m