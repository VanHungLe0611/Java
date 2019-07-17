package alarmSystem;

import java.util.ArrayList;

public class AlarmSystem {
	private boolean isOn = false;
	private boolean isAlarm = false;
	private String pinCodeString = "0000";
	private ArrayList<Sensor> sensors = new ArrayList<Sensor>();

	public boolean isOn() {
		return this.isOn;
	}

	public boolean isAlarm() {
		return this.isAlarm;
	}

	public ArrayList<Sensor> getSensors() {
		return this.sensors;
	}

	// pin change
	public boolean setPinCode(String oldCode, String newCode) {
		if (oldCode.equals(pinCodeString)) {
			pinCodeString = newCode;
			return true;
		}
		return false;
	}

	public void addSensor(Sensor sensor) {
		if (!sensors.contains(sensor)) {
			sensors.add(sensor);
		}

	}

	public void switchOn() {
		this.isOn = true;
	}

	public void switchOff(String pinCode) {
		if (pinCodeString.equals(pinCode)) {
			this.isOn = false;
			this.isAlarm = false;
		}

	}

	public void onSensorTriggered() {
		if (this.isOn) {
			this.isAlarm = true;
		}

	}

	public String toString() {
		return String.format("System state (on: %s, alarm: %s)", this.isOn, this.isAlarm);
	}

}
