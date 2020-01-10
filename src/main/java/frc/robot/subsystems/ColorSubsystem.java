package frc.robot.subsystems;

import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Constants;
import frc.robot.Robot;

public class ColorSubsystem extends SubsystemBase {
  String gameData = Robot.gameData;
  private boolean x=true;
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);
  //PWM colorWheel = new PWM(0);
  PWM colorWheel = new PWM(Constants.SPINNING_WHEEL_MOTOR_ID);

  public ColorSubsystem() {
  }

  public void numberrot(Boolean placeholder){
    x=true;
    double fixed = Timer.getMatchTime();
    SmartDashboard.putNumber("fixed", fixed);
    while (x){
      while(Timer.getMatchTime()>=(fixed-5.9)){
        colorWheel.setSpeed(0.5);
      }
      x = false;
      colorWheel.setSpeed(0);
    }
  }
  public void colorrot(Boolean placeholder){
    gameData = DriverStation.getInstance().getGameSpecificMessage();
    SmartDashboard.putNumber("length", gameData.length());
    SmartDashboard.updateValues();
    Color color = colorSensor.getColor();
    SmartDashboard.updateValues();
    SmartDashboard.putNumber("rColor", color.red);
    SmartDashboard.putNumber("gColor", color.green);
    SmartDashboard.putNumber("bColor", color.blue);
    SmartDashboard.putNumber("timerthing", Timer.getMatchTime());
    SmartDashboard.updateValues();
    if(gameData.length() > 0){
      SmartDashboard.putString("getting", gameData);
      switch (gameData.charAt(0)) {
      case 'B':
      if(gameData.charAt(0) == 'B'){ 
        // Blue case code
        if (color.blue > .4 && color.green > .4) {
          SmartDashboard.putString("Color", "blue");
          colorWheel.setSpeed(0);
        }else{
          colorWheel.setSpeed(.5);
        }
        break;
      }
      case 'G':
      if(gameData.charAt(0) == 'G'){ 
        // Green case code
        if (color.red < .3 && color.blue < .3 && color.green > .5) {
          SmartDashboard.putString("Color", "green");
          colorWheel.setSpeed(0);
        }else{
          colorWheel.setSpeed(.5);
        }
        break;
      }
      case 'R':
      if(gameData.charAt(0) == 'B'){ 
        // Red case code
        if (color.red > .5 && color.blue < .5 && color.green < .5) {
          SmartDashboard.putString("Color", "red");
          colorWheel.setSpeed(.0);
        }else{
          colorWheel.setSpeed(.5);
        }
        break;
      }
      case 'Y':
      if (gameData.charAt(0) == 'B'){ 
        // Yellow case code
        if (color.red > .3 && color.blue < .3 && color.green > .5) {
          SmartDashboard.putString("Color", "yellow");
          colorWheel.setSpeed(0);
        } else{
          colorWheel.setSpeed(.5);
        }
        break;
      }
      default:
      }
    }else{
    }
  }
  /*public void color(Boolean placeholder) {
    Color color = colorSensor.getColor();
    SmartDashboard.updateValues();
    SmartDashboard.putNumber("rColor", color.red);
    SmartDashboard.putNumber("gColor", color.green);
    SmartDashboard.putNumber("bColor", color.blue);
    SmartDashboard.putNumber("timerthing", Timer.getMatchTime());
    SmartDashboard.updateValues();
    //gameData= " ";
    if(gameData.length() > 0){
      SmartDashboard.putString("getting", gameData);
      switch (gameData.charAt(0)) {
      case 'B':
      if(gameData.charAt(0) == 'B'){ 
        // Blue case code
        if (color.blue > .4 && color.green > .4) {
          SmartDashboard.putString("Color", "cyan");
          colorWheel.setSpeed(0);
        }else{
          colorWheel.setSpeed(.5);
        }
        break;
      }
      case 'G':
      if(gameData.charAt(0) == 'G'){ 
        // Green case code
        if (color.red < .3 && color.blue < .3 && color.green > .5) {
          SmartDashboard.putString("Color", "green");
          colorWheel.setSpeed(0);
        }else{
          colorWheel.setSpeed(.5);
        }
        break;
      }
      case 'R':
      if(gameData.charAt(0) == 'B'){ 
        // Red case code
        if (color.red > .5 && color.blue < .5 && color.green < .5) {
          SmartDashboard.putString("Color", "red");
          colorWheel.setSpeed(.0);
        }else{
          colorWheel.setSpeed(.5);
        }
        break;
      }
      case 'Y':
      if (gameData.charAt(0) == 'B'){ 
        // Yellow case code
        if (color.red > .3 && color.blue < .3 && color.green > .5) {
          SmartDashboard.putString("Color", "yellow");
          colorWheel.setSpeed(0);
        } else{
          colorWheel.setSpeed(.5);
        }
        break;
      }
      default:
      }
    }else{
      if (placeholder) {
        x=true;
        double fixed = Timer.getMatchTime();
        SmartDashboard.putNumber("fixed", fixed);
        while (x){
          while(Timer.getMatchTime()>=(fixed-5.9)){
          colorWheel.setSpeed(0.5);
          }
          x = false;
          colorWheel.setSpeed(0);
        }
      } else{
        colorWheel.setSpeed(0);
      }
    }
  }*/
  
  public void periodic(){
    
  }
}