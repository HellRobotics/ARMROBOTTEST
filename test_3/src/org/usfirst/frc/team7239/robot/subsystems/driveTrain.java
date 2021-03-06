package org.usfirst.frc.team7239.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team7239.robot.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
/**
 *
 */
public class driveTrain extends Subsystem {
	
	double limitFactor = 0.5;
	double slowFactor = 0.35;
	
	WPI_TalonSRX left1 = new WPI_TalonSRX(RobotMap.LEFTMOTOR1);
	WPI_TalonSRX left2 = new WPI_TalonSRX(RobotMap.LEFTMOTOR2);
	WPI_TalonSRX right1 = new WPI_TalonSRX(RobotMap.RIGHTMOTOR1);
	WPI_TalonSRX right2 = new WPI_TalonSRX(RobotMap.RIGHTMOTOR2);
	RobotDrive Drive = new RobotDrive(left1, left2, right1, right2);
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private static driveTrain m_instance;
	public static synchronized driveTrain getInstance() {
		if (m_instance == null){
			m_instance = new driveTrain();
		}
		return m_instance;
		
	}
	
	private driveTrain() {
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	public void Arcade(double moveValue, double rotateValue, double maxSpeed) {
		double move = moveValue * maxSpeed;
		double turn = rotateValue * maxSpeed;
		
		/*if(!boost) {
			move = moveValue * limitFactor;
			turn = rotateValue * limitFactor;
		}
		if (slow) {
			move = moveValue * slowFactor;
			turn = rotateValue * slowFactor;
		}*/
		
		Drive.arcadeDrive(move, turn * -1, true);
		
	}
}

