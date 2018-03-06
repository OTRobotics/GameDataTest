/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1334.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1334.robot.commands.ExampleCommand;
import org.usfirst.frc.team1334.robot.commands.PlaceHolderCommand;
import org.usfirst.frc.team1334.robot.subsystems.ExampleSubsystem;

public class Robot extends TimedRobot {
	public static ExampleSubsystem m_subsystem = new ExampleSubsystem();
	public static OI m_oi;

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * THIS IS ***NOT*** A VALID PLACE TO CHECK FOR GAMEDATA.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
		
		/** Many teams get caught up here, as they are instantiating their desired autonomous command in robotInit.
		 *  This is a problem because many teams also check for gamedata in the constructor of their command.
		 *  It effectively checks for gameData when the robot is first turned on. 
		 */
		m_chooser.addDefault("Default Auto", new ExampleCommand());
		
		m_chooser.addObject("Auto1", new PlaceHolderCommand());
		m_chooser.addObject("Auto2", new PlaceHolderCommand());
		m_chooser.addObject("Auto3", new PlaceHolderCommand());
		SmartDashboard.putData("Auto Selector", m_chooser);
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * THIS IS A VALID PLACE TO CHECK FOR GAMEDATA
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();

		/*
		 * This is a valid way to check for gamedata/set your auto. Instead of passing in an object reference to your command
		 * pass just a string reference. This way, your auto is never actually instantiated until autonomousInit, where you can
		 * check for gamedata correctly.
		 * 
		  String autoSelected = SmartDashboard.getString("Auto Selector", "Default Auto");
		  switch(autoSelected)
		  { 
		  case "My Auto": 
			  m_autonomousCommand = new MyAutoCommand();
			  break;
		  case "Default Auto":
	      default:
	    	  m_autonomousCommand = new ExampleCommand();
	    	  break;
	      }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}


	/**
	 * THIS IS A VALID PLACE TO CHECK FOR GAMEDATA!
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
	
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
	}
}
