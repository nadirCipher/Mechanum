package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.Motor_Ports;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static java.lang.Math.sqrt;

public class DriveSubsystem extends SubsystemBase {
  //initiates this subsystem
    private final static DriveSubsystem instance = getInstance();
  //initiates the four mechanum motors
    public final CANSparkMax RF = new CANSparkMax(Motor_Ports.RFmotor, MotorType.kBrushless);
    public final CANSparkMax LF = new CANSparkMax(Motor_Ports.LFmotor, MotorType.kBrushless);
    public final CANSparkMax RB = new CANSparkMax(Motor_Ports.RBmotor, MotorType.kBrushless);
    public final CANSparkMax LB = new CANSparkMax(Motor_Ports.LBmotor, MotorType.kBrushless);

    public void Movment(double Lx, double Ly, double Rx){
    //the angle you are putting the left stick to
      double angle = Math.atan2(Lx, Ly);
      angle = Math.toDegrees(angle);
    //how far you are pressing the stick which will be used to effect the speed
      double magnitude = Math.sqrt(Lx*Lx + Ly*Ly);

    //calculating the speed needed for both motors
    //-as motors cap out at one/-one so the turn (Rx) and the omnidirectional movment (Math.sin(angle-((1/4)*(Math.PI))) are devided by 2 
      double LF_RB = (Math.sin(angle-((1/4)*(Math.PI))) * magnitude)/2 + Rx/2;
      double RF_LB = (Math.sin(angle+((1/4)*(Math.PI))) * magnitude)/2 + Rx/2;

      RF.set(RF_LB);
      LB.set(RF_LB);
      LF.set(LF_RB);
      RB.set(LF_RB);
    }

    public void Motor_Stop(){
      RF.set(0);
      LB.set(0);
      LF.set(0);
      RB.set(0);
    }

    public static DriveSubsystem getInstance() {
        if (instance == null) {
          return new DriveSubsystem();
        }
        return instance;
      }
}