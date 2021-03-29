package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.user.TrainUserImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainSensor sensor;
    TrainUser mockUser;
    TrainController mockController;

    @Before
    public void before() {
        mockUser = mock(TrainUser.class);
        mockController = mock(TrainController.class);
        sensor = new TrainSensorImpl(mockController, mockUser);
    }

    @Test
    public void NoAlarm(){
        Assert.assertFalse(mockUser.getAlarmFlag());
    }

    @Test
    public void AbsoluteMarginLow(){
        sensor.overrideSpeedLimit(-10);
        verify(mockUser, times(2)).setAlarmState(true);
    }

    @Test
    public void AbsoluteMarginHigh(){
        sensor.overrideSpeedLimit(501);
        verify(mockUser).setAlarmState(true);
    }

    @Test
    public void RelaitveMargin(){
        when(mockController.getReferenceSpeed()).thenReturn(150);
        sensor.overrideSpeedLimit(50);
        verify(mockUser).setAlarmState(true);
    }
}
