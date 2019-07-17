package alarmSystem;

public class MotionSensor extends Sensor {

	public MotionSensor(AlarmSystem system) {
		super(system);
	}

	@Override
	public void trigger() {
		this.system.onSensorTriggered();

	}

}
