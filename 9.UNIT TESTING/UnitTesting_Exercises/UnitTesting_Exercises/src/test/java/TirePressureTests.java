import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import p06_TirePressureMonitoringSystem.Alarm;
import p06_TirePressureMonitoringSystem.Sensor;

import java.lang.reflect.Field;

public class TirePressureTests {

    @Test
    public void alarmIsOnWhenPressureIsOutOfLimit() throws NoSuchFieldException, IllegalAccessException {
        Alarm alarm = new Alarm();
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue())
                .thenReturn(16.0);
        Field sensorField = Alarm.class.getDeclaredField("sensor");
        sensorField.setAccessible(true);
        sensorField.set(alarm,sensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }
}
