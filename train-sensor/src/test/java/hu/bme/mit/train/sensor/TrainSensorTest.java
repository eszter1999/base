package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainSensor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainSensor sensor;

    @Before
    public void before() {
        sensor = new TrainSensorImpl(null, null);
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        Assert.assertEquals(sensor.getSpeedLimit(), 2);
    }
}
