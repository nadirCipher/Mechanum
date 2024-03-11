package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class driveCommand extends Command{
    public final DriveSubsystem driveSubsystem = DriveSubsystem.getInstance();
    private double xbox1_rX, xbox1_lY, xbox1_lX;


    public driveCommand(double Lx, double Ly, double Rx){
        addRequirements(driveSubsystem);

        this.xbox1_rX = Rx;
        this.xbox1_lY = Ly;
        this.xbox1_lX = Lx;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        driveSubsystem.Motor_Stop();
    }

    // Called every time the scheduler runs while the command is scheduled.
     @Override
     public void execute() {
        driveSubsystem.Movment(xbox1_lX, xbox1_lY, xbox1_rX);
     }

     // Called once the command ends or is interrupted.
     @Override
     public void end(boolean interrupted) {}

     // Returns true when the command should end.
     @Override
     public boolean isFinished() {
        return false;
    }
}
