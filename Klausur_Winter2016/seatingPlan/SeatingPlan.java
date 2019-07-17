package seatingPlan;

import java.util.ArrayList;

public class SeatingPlan {

	private String aircraftName;
	private int numberSeats;
	private int seatsPerRow;
	private ArrayList<AircraftSeat> seats = new ArrayList<AircraftSeat>();

	public SeatingPlan(String aircraftName, int numberSeats, int seatsPerRow) {
		super();
		this.aircraftName = aircraftName;
		this.numberSeats = numberSeats;
		this.seatsPerRow = seatsPerRow;

		char position = 'A';
		int rowNumber = 1;
		int count = 0;
		for (int i = 0; i < numberSeats; i++) {
			seats.add(new AircraftSeat(rowNumber, position));
			position++;
			count++;
			if (count == seatsPerRow) {
				rowNumber++;
				position = 'A';
				count = 0;
			}

			if (rowNumber == 13) {
				rowNumber = 14;

			}

		}

	}

	public String getAircraftName() {
		return aircraftName;
	}

	public int getNumberSeats() {
		return numberSeats;
	}

	public int getSeatsPerRow() {
		return seatsPerRow;
	}

	public int getNumberSeatsReserved() {
		int count = 0;
		for (AircraftSeat aircraftSeat : seats) {
			if (aircraftSeat.isReserved()) {
				count++;
			}
		}
		return count;
	}

	public int getNumberSeatsVacant() {
		return numberSeats - getNumberSeatsReserved();
	}

	public AircraftSeat getSeat(int index) {
		return seats.get(index);
	}

	public void reserveSeat(String seatName) throws InvalidSeatException {
		boolean control = false;
		for (AircraftSeat aircraftSeat : seats) {
			if (seatName.equals(aircraftSeat.toString())) {
				aircraftSeat.reserve(true);
				control = true;
			}

		}
		if (control == false) {
			throw new InvalidSeatException(seatName);

		}

	}
	@Override
	public String toString() {
		String string = "Seating plan " + this.getAircraftName() + ":\n";
		int count = 1;
		int numberRow = 1;
		for (int i = 0; i < seats.size(); i++) {
			if (numberRow < 10) {
				if (seats.get(i).isReserved()) {
					string += " " + seats.get(i).toString() + "* ";
				} else {
					string += " " + seats.get(i).toString() + "  ";
				}
			} else {
				if (seats.get(i).isReserved()) {
					string += " " + seats.get(i).toString() + "*";
				} else {
					string += " " + seats.get(i).toString() + " ";
				}
			}
			if (count == getSeatsPerRow()) {
				string = string.substring(0, string.length() - 1) + "\n";
				count = 1;
				numberRow++;
			} else {
				count++;
			}

		}
		return string;

	}

}
