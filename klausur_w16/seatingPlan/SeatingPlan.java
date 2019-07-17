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

		int count = 1, numberRow = 1;
		char position = 'A';
		for (int i = 0; i < getNumberSeats(); i++) {
			seats.add(new AircraftSeat(numberRow, position));
			if (count == getSeatsPerRow()) {
				count = 1;
				numberRow++;
				position = 'A';
			} else {
				count++;
				position++;
			}

			if (numberRow == 13) {
				numberRow = 14;
			}

		}

	}

	public ArrayList<AircraftSeat> getSeats() {
		return seats;
	}

	public String getAircraftName() {
		return aircraftName;
	}

	public int getNumberSeats() {
		return numberSeats;
	}

	public int getNumberSeatsReserved() {
		int i = 0;
		for (int j = 0; j < seats.size(); j++) {
			if (seats.get(j).isReserved()) {
				i++;
			}
		}
		return i;
	}

	public int getSeatsPerRow() {
		return seatsPerRow;
	}

	public int getNumberSeatsVacant() {
		return (getNumberSeats() - getNumberSeatsReserved());
	}

	public AircraftSeat getSeat(int index) {
		return seats.get(index);
	}

	public void reserveSeat(String seatName) throws InvalidSeatException {
		int count = 0;
		for (int i = 0; i < this.seats.size(); i++) {
			if (seatName.equals(seats.get(i).toString())) {
				seats.get(i).reserve(true);
				count++;
			}
		}
		if (count == 0) {
			throw new InvalidSeatException(seatName);

		}
	}

	public String toSting() {
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