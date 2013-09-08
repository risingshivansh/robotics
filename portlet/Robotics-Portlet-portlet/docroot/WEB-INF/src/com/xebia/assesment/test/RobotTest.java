package com.xebia.assesment.test;

import static org.junit.Assert.assertEquals;

import com.xebia.assesment.dto.Observer;
import com.xebia.assesment.dto.impl.Robot;
import com.xebia.assesment.model.BatteryHealthManager;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.api.easymock.annotation.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@PrepareForTest(BatteryHealthManager.class)
@RunWith(PowerMockRunner.class)
public class RobotTest
{
    @Mock
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    @Before
    public void setUp() throws Exception
    {

        BatteryHealthManager StrengthbatteryHealthManager = new BatteryHealthManager(3.5, 0.0);

    }

    @Test
    public final void testCorrectInput() throws Exception
    {

        BatteryHealthManager bhm = new BatteryHealthManager(3.5, 2.0);
        PowerMock.replayAll();
        assertEquals(3.5, bhm.getDistanceInput(), 0);
        assertEquals(2.0, bhm.getWeightInput(), 0);
        PowerMock.verifyAll();

    }

    @Test
    public final void testIncorrectInputException()
    {
        try
        {
            BatteryHealthManager bhm = new BatteryHealthManager(Double.valueOf("abc"), 2.0);
        }
        catch (Exception e)
        {
            new AssertionError("Not a Number");
        }

    }

    @Test
    public final void testMessagesForLowBattery() throws Exception
    {
        BatteryHealthManager bhm = new BatteryHealthManager(5.0, 3.0);

        Robot robot = PowerMock.createPartialMock(Robot.class, "notifyObservers");
        robot.registerObserver(bhm);
        PowerMock.replayAll();
        String msg = robot.notifyObservers(robot.getObservers().get(0), "10.0", true, false);
        PowerMock.verifyAll();
        assertEquals("LOW_BATTERY", msg);
    }
}
