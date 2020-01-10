package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ColorSubsystem;

public class NumberRotation extends CommandBase{
    private final ColorSubsystem colSub;
    public NumberRotation(ColorSubsystem subsystem){
        colSub = subsystem;
        addRequirements(subsystem);
    }
    @Override
    public void initialize(){
        //colSub.numberrot(true);
    }
    @Override
    public void execute(){
        colSub.numberrot(true);
    }
    @Override
    public void end(boolean interrupted){

    }
    @Override
    public boolean isFinished(){
        return false;
    }
}