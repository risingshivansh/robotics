package com.xebia.assesment.action;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.xebia.assesment.dto.impl.Robot;
import com.xebia.assesment.model.BatteryHealthManager;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/**
 * Portlet implementation class RoboticsPortlet
 */
public class RoboticsPortlet extends MVCPortlet
{

    @Override
    public void serveResource(ResourceRequest aResourceRequest, ResourceResponse aResourceResponse)
            throws IOException, PortletException
    {
        System.out.println("Method serveResource");

        JSONObject jsonObj = null;
        String distance = null;
        String weight = null;
        String reqParams = aResourceRequest.getParameter("postKey");
        try
        {
            jsonObj = JSONFactoryUtil.createJSONObject(reqParams);
            distance = jsonObj.getString("distance");
            weight = jsonObj.getString("weight");
        }

        catch (JSONException e)
        {

            e.printStackTrace();
        }

        try
        {
            BatteryHealthManager batteryHealthManager = new BatteryHealthManager(Double.valueOf(distance),
                    Double.valueOf(weight));
            System.out.println("Access the control");

            Robot robot = new Robot(100.0, 100.0, "");

            robot.registerObserver(batteryHealthManager);
            robot.consumption();
            aResourceResponse.getWriter().write(batteryHealthManager.getMsgPortlet());
            System.out.println("Operation Completed");
        }
        catch (NumberFormatException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
