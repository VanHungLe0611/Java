package alarmSystem;

public abstract class Sensor {

	protected AlarmSystem system = new AlarmSystem();

	public Sensor(AlarmSystem system) {
		super();
		this.system = system;
		system.addSensor(this);
	}

	public abstract void trigger();

}
