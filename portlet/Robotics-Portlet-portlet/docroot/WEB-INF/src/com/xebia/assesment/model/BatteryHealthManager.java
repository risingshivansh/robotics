package com.xebia.assesment.model;

import com.xebia.assesment.dto.Observer;
import com.xebia.assesment.utils.RobotConstants;

/**
 * @author Shivansh Sharma 
 * This class is responsible for handling & alerting the battery health status of
 * robot
 */
public class BatteryHealthManager implements Observer
{

    Double distanceInput;
    Double weightInput;
    String msgPortlet;

    public BatteryHealthManager(Double aDistanceInput, Double aWeightInput) throws Exception
    {
        super();
        distanceInput = aDistanceInput;
        weightInput = aWeightInput;
    }

    /**
     * @return the distanceInput
     */
    public Double getDistanceInput()
    {
        return distanceInput;
    }

    /**
     * @param aDistanceInput the distanceInput to set
     */
    public void setDistanceInput(Double aDistanceInput)
    {
        distanceInput = aDistanceInput;
    }

    /**
     * @return the weightInput
     */
    public Double getWeightInput()
    {
        return weightInput;
    }

    /**
     * @param aWeightInput the weightInput to set
     */
    public void setWeightInput(Double aWeightInput)
    {
        weightInput = aWeightInput;
    }

    /**
     * @return the msgPortlet
     */
    public String getMsgPortlet()
    {
        return msgPortlet;
    }

    /**
     * @param aMsgPortlet the msgPortlet to set
     */
    public void setMsgPortlet(String aMsgPortlet)
    {
        msgPortlet = aMsgPortlet;
    }

    /**
     * displaying the messages or alerts based on the msg attributes retrieve from the notifier subject
     * 
     * @param String msg
     */
    public String getMessages(String msg)
    {
        if (msg.equalsIgnoreCase(RobotConstants.LOW_BATTERY))
        {
            System.out.println(RobotConstants.LOW_BATTERY_MSG);
            setMsgPortlet(RobotConstants.LOW_BATTERY_MSG);
        }
        if (msg.equalsIgnoreCase(RobotConstants.OVER_WEIGHT))
        {
            System.out.println(RobotConstants.OVER_WEIGHT_MSG);
            setMsgPortlet(RobotConstants.OVER_WEIGHT_MSG);
        }

        if (!msg.equalsIgnoreCase(RobotConstants.LOW_BATTERY)
                && !msg.equalsIgnoreCase(RobotConstants.OVER_WEIGHT))
        {
            System.out.println(RobotConstants.DISTANCE_KEY + distanceInput + RobotConstants.WEIGHT_KEY
                    + weightInput + RobotConstants.APPLIED_KEY + msg + RobotConstants.REST_PART_MSG_KEY);
            setMsgPortlet(RobotConstants.DISTANCE_KEY + distanceInput + RobotConstants.WEIGHT_KEY
                    + weightInput + RobotConstants.APPLIED_KEY + msg + RobotConstants.REST_PART_MSG_KEY);
        }
        return msg;
    }
}
