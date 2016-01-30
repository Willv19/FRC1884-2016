
package org.usfirst.frc.team1884.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	CANTalon frontRight, backRight;
	DigitalInput clicker;
	Joystick joystick;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	frontRight = new CANTalon(2);
    	backRight = new CANTalon(0);
    	clicker = new DigitalInput(0);
    	joystick = new Joystick(0);
    }
    
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
    public void autonomousInit() {
    	frontRight.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	System.out.println("Position: " + frontRight.getEncPosition());
    	System.out.println("Velocity: " + frontRight.getEncVelocity());
    	if (clicker.get()){
    		frontRight.set(joystick.getY());
    		backRight.set(-joystick.getY());
    		
    	} else {
    		if (joystick.getRawButton(8)){
    			frontRight.set(joystick.getY());
        		backRight.set(-joystick.getY());
    		}
    		else {
    			frontRight.set(0);
        		//backRight.set(0);
    		}

    	}
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
