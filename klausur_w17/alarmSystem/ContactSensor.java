package alarmSystem;

public class ContactSensor extends Sensor {
	private boolean isOpen = false;

	public ContactSensor(AlarmSystem system) {
		super(system);
	}

	boolean isOpen() {
		return this.isOpen;
	}

	public void trigger() {
		this.isOpen = !this.isOpen;
		if (isOpen == true) {
			system.onSensorTriggered();

		}
	}

}
