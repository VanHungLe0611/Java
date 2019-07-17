package seatingPlan;

public class AircraftSeat implements Reservable {

	private int rowNumber;
	private char position;
	private boolean isReverved;

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

	@Override
	public void reserve(boolean isReverved) {
		this.isReverved = isReverved;

	}

	@Override
	public boolean isReserved() {
		return isReverved;
	}

	@Override
	public String toString() {
		if (this.rowNumber < 10) {
			return String.format("%d%c", rowNumber, position);
		} else
			return String.format("%2d%c", rowNumber, position);
	}

}