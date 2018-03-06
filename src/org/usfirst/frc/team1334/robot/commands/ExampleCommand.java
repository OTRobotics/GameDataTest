/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1334.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1334.robot.Robot;

public class ExampleCommand extends Command {
	private String gameData;
	public ExampleCommand() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.m_subsystem);
		
		// This will return either null or an empty string, depending on your WPIlib version.
		this.gameData = DriverStation.getInstance().getGameSpecificMessage(); 
		// You want to check for the gamedata when you know it's available. Depending on when you instantiate the command
		// you may or may not have gamedata, causing problems down the road.
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
		char switchSide = gameData.charAt(0);
		char scaleSide = gameData.charAt(1);
		// Handle autonomous here
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}
