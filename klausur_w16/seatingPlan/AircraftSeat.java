package seatingPlan;

public class AircraftSeat implements Reservable {
	private int rowNumber;
	private char position;
	private boolean isReserved = false;

	public AircraftSeat(int rowNumber, char position) {
		super();
		this.rowNumber = rowNumber;
		this.position = position;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public char getPosition() {
		return position;
	}

	public void reserve(boolean isReserved) {
		this.isReserved = isReserved;
	}

	public boolean isReserved() {
		return isReserved;
	}

	public String toString() {
		if (this.rowNumber < 10) {
			return String.format("%d%c", this.rowNumber, this.position);
		} else {
			return String.format("%2d%c", this.rowNumber, this.position);

		}
	}
}
