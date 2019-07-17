package alarmSystem;

public class ContactSensor extends Sensor {

	private boolean isOpen = false;

	public ContactSensor(AlarmSystem system) {
		super(system);

	}

	public boolean isOpen() {
		return isOpen;
	}

	@Override
	public void trigger() {
		this.isOpen = !this.isOpen;
		if (isOpen) {
			this.system.onSensorTriggered();

		}

	}

}
