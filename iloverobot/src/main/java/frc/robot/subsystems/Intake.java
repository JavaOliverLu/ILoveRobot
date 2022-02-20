package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Intake extends SubsystemBase {
    private static VictorSPX intakemotor=new VictorSPX(Constants.intakemotorno);
    private final DoubleSolenoid intakedoubleSolenoid =new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
    protected static Compressor intakecompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);


    public  Intake(){
        intakemotor.configFactoryDefault();
        intakecompressor.enableDigital();

    }

    public void intakego(){ 
          intakedoubleSolenoid.set(DoubleSolenoid.Value.kForward);
          intakemotor.set(ControlMode.PercentOutput, 0);
      }


        
    public void intakeback(){        
      intakedoubleSolenoid.set(DoubleSolenoid.Value.kReverse);
      intakemotor.set(ControlMode.PercentOutput,-0.7);
    }



    }





/**
 * This is a sample program showing the use of the solenoid classes during operator control. Three
 * buttons from a joystick will be used to control two solenoids: One button to control the position
 * of a single solenoid and the other two buttons to control a double solenoid. Single solenoids can
 * either be on or off, such that the air diverted through them goes through either one channel or
 * the other. Double solenoids have three states: Off, Forward, and Reverse. Forward and Reverse
 * divert the air through the two channels and correspond to the on and off of a single solenoid,
 * but a double solenoid can also be "off", where the solenoid will remain in its default power off
 * state. Additionally, double solenoids take up two channels on your PCM whereas single solenoids
 * only take a single channel.
 */
