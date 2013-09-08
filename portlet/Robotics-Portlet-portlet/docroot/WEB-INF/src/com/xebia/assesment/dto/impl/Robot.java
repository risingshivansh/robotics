package com.xebia.assesment.dto.impl;

import com.xebia.assesment.dto.Observer;
import com.xebia.assesment.dto.Subject;
import com.xebia.assesment.utils.RobotConstants;

import java.util.ArrayList;

/**
 * @author Shivansh Sharma 
 * This class is responsible for managing the operation/events performed by robots
 */
public class Robot implements Subject
{
    // Predefined max strength of robot
    private static final Double MAX_ROBOT_STRENGTH = 5.0;
    // Predefined max load threshold attain by robot
    private static final Double MAX_ROBOT_LOAD_THRESHOLD = 10.0;
    private static boolean OVERWEIGHT_INDICATOR = false;
    private static boolean LOW_BATTERY = false;

    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private Double strength;
    private Double load;
    String consumptionMsg;

    public Robot(Double aStrength, Double aLoad, String aConsumptionMsg)
    {
        super();
        strength = aStrength;
        load = aLoad;
        consumptionMsg = aConsumptionMsg;

    }

    /**
     * Calculate the Capacity & efficiency of the robot based on the activity performed by it.
     */
    public void consumption()
    {
        try
        {
            double unitPercentileStrength = strength / MAX_ROBOT_STRENGTH;
            for (Observer ob : observers)
            {
                // System.out.println("Distance " + ob.getDistanceInput());
                // System.out.println("Weight " + ob.getWeightInput());

                double distance = ob.getDistanceInput();
                double weight = ob.getWeightInput();

                if (null != ob.getDistanceInput() && null != ob.getWeightInput())
                {
                    if (distance != 0.0)
                    {
                        double result = unitPercentileStrength * distance;
                        strength = strength - result;
                        if (strength <= 15.0)
                        {
                            LOW_BATTERY = true;

                        }
                    }
                    if (weight > 10.0 && !LOW_BATTERY)
                    {
                        OVERWEIGHT_INDICATOR = true;

                    }
                    else
                    {
                        strength = strength - (2 * weight);
                    }

                    notifyObservers(ob, strength.toString(), LOW_BATTERY, OVERWEIGHT_INDICATOR);

                    // System.out.println("Result" + strength);

                }

                // ob.getMessages(this.consumptionMsg);
                strength = 100.0;
                LOW_BATTERY = false;
                OVERWEIGHT_INDICATOR = false;
            }

        }
        catch (Exception e)
        {
            System.out.println(RobotConstants.INPUT_NAN_KEY);
        }

    }

    /**
     * @return the observers
     */
    public ArrayList<Observer> getObservers()
    {
        return observers;
    }

    /**
     * @param aObservers the observers to set
     */
    public void setObservers(ArrayList<Observer> aObservers)
    {
        observers = aObservers;
    }

    /**
     * @return the strength
     */
    public Double getStrength()
    {
        return strength;
    }

    /**
     * @param aStrength the strength to set
     */
    public void setStrength(Double aStrength)
    {
        strength = aStrength;
    }

    /**
     * @return the load
     */
    public Double getLoad()
    {
        return load;
    }

    /**
     * @param aLoad the load to set
     */
    public void setLoad(Double aLoad)
    {
        load = aLoad;
    }

    /**
     * @return the consumptionMsg
     */
    public String getConsumptionMsg()
    {
        return consumptionMsg;
    }

    /**
     * @param aConsumptionMsg the consumptionMsg to set
     */
    public void setConsumptionMsg(String aConsumptionMsg)
    {
        consumptionMsg = aConsumptionMsg;
        // notifyObservers();
    }

    @Override
    public void registerObserver(Observer aObserver)
    {
        observers.add(aObserver);

    }

    @Override
    public void removeObserver(Observer aObserver)
    {
        observers.remove(aObserver);

    }

    /**
     * Notifying to all the subscribers and publish the messages
     */
    @Override
    public String notifyObservers(Observer ob, String msg, boolean lb, boolean ow)
    {

        if (lb)
        {
            ob.getMessages(RobotConstants.LOW_BATTERY);
        }
        if (ow)
        {
            ob.getMessages(RobotConstants.OVER_WEIGHT);
        }

        if (!lb && !ow)
        {
            ob.getMessages(msg);
        }
        
        return msg;

    }
}
