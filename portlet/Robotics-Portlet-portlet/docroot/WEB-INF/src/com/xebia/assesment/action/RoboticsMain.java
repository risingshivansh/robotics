package com.xebia.assesment.action;

import com.xebia.assesment.dto.impl.Robot;
import com.xebia.assesment.model.BatteryHealthManager;

/**
 * @author Shivansh Sharma 
 * This class to test the cases as standalone java application.
 */
public class RoboticsMain
{
    public static void main(String[] args)
    {
        // To test the case when Robot walks for 3.5 KM and carrying 0 KG weight
        BatteryHealthManager StrengthbatteryHealthManager = null;
        // To test the case when Robot walks for 2 KM and carrying 3 KG weight
        BatteryHealthManager EfficiencyBatteryHealthManager = null;
        // To test the case when Robot attempt to carrying 12 KG weight
        BatteryHealthManager LoadBatteryHealthManager = null;
        try
        {
            StrengthbatteryHealthManager = new BatteryHealthManager(3.5, 0.0);
            EfficiencyBatteryHealthManager = new BatteryHealthManager(2.0, 3.0);
            LoadBatteryHealthManager = new BatteryHealthManager(0.0, 12.0);
        }
        catch (Exception e)
        {
            System.out.println("Provided Inputs are not correct");
        }
        Robot robot = new Robot(100.0, 100.0, "");

        robot.registerObserver(StrengthbatteryHealthManager);
        robot.registerObserver(EfficiencyBatteryHealthManager);
        robot.registerObserver(LoadBatteryHealthManager);
        // kickoff to notifying messages on console for all the above mention 3 cases.
        // Per requirement increase the no of cases by simply registering the Observer.
        robot.consumption();

    }

}
