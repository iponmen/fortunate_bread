package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorSubsystem;

public class ColorRotation extends CommandBase{
    private final ColorSubsystem colSub;
    public ColorRotation(ColorSubsystem subsystem){
        colSub = subsystem;
        addRequirements(subsystem);
    }
    @Override
    public void initialize(){
    }
    @Override
    public void execute(){
        colSub.colorrot(true);
    }
    @Override
    public void end(boolean interrupted){

    }
    @Override
    public boolean isFinished(){
        return false;
    }
}