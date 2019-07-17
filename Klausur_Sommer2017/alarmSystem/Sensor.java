package alarmSystem;

public abstract class Sensor {
	protected AlarmSystem system;

	public Sensor(AlarmSystem system) {
		super();
		this.system = system;
		this.system.addSensor(this);
	}

	public abstract void trigger();

}
