package org.usfirst.frc.team1884.robot;

import edu.wpi.first.wpilibj.DigitalInput;

public class FiveBitSwitch {
	
	public static FiveBitSwitch fiveBitSwitch = new FiveBitSwitch();
	
	byte fieldObstacleID;
	byte fieldPositionID;
	
	FieldObstacle fieldObstacle;
	FieldPosition fieldPosition;
	
	DigitalInput port0, port1, port2, port3, port4;
	
	private FiveBitSwitch() {
		port0 = new DigitalInput(0);
		port1 = new DigitalInput(1);
		port2 = new DigitalInput(2);
		port3 = new DigitalInput(3);
		port4 = new DigitalInput(4);
	}
	
	public FieldObstacle getFieldObstacle() {
		fieldObstacleID = (byte) (port0.get() ? 0 : 1);
		fieldObstacleID *= 2;
		fieldObstacleID += (byte) (port1.get() ? 0 : 1);
		fieldObstacleID *= 2;
		fieldObstacleID += (byte) (port2.get() ? 0 : 1);
		
		switch(fieldObstacleID) {
			case 0: fieldObstacle = FieldObstacle.Portcullis; break;
			case 1: fieldObstacle = FieldObstacle.ChevalDeFrise; break;
			case 2: fieldObstacle = FieldObstacle.Moat; break;
			case 3: fieldObstacle = FieldObstacle.Ramparts; break;
			case 4: fieldObstacle = FieldObstacle.Drawbridge; break;
			case 5: fieldObstacle = FieldObstacle.SallyPort; break;
			case 6: fieldObstacle = FieldObstacle.RockWall; break;
			case 7: fieldObstacle = FieldObstacle.RoughTerrain; break;
		}
		
		return fieldObstacle;
	}
	
	public FieldPosition getFieldPosition() {
		fieldPositionID = (byte) (port3.get() ? 0 : 1);
		fieldPositionID *= 2;
		fieldPositionID += (byte) (port4.get() ? 0 : 1);
		
		switch(fieldPositionID) {
			case 0: fieldPosition = FieldPosition.pos1; break;
			case 1: fieldPosition = FieldPosition.pos2; break;
			case 2: fieldPosition = FieldPosition.pos3; break;
			case 3: fieldPosition = FieldPosition.pos4; break;
			default: fieldPosition = FieldPosition.pos2; break;
		}
		
		return fieldPosition;
	}
}
