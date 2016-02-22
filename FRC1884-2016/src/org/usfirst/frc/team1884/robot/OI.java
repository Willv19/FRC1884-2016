package org.usfirst.frc.team1884.robot;

import org.usfirst.frc.team1884.robot.commands.defense_manipulator.FlipperSequence;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick driveStick = NEXUS.DRIVESTICK, opStick = NEXUS.OPERATORSTICK;
	JoystickButton opButton1 = new JoystickButton(opStick, 1);
	
	public OI() {
		opButton1.whenPressed(new FlipperSequence());
	}
}