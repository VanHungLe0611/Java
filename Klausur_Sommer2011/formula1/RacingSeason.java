package formula1;

import java.util.ArrayList;
import java.util.Collections;

public class RacingSeason {
	private ArrayList<RacingTeam> teams = new ArrayList<RacingTeam>();
	private ArrayList<RaceResult> races = new ArrayList<RaceResult>();

	public RacingSeason() {
		super();
	}

	public void addTeam(RacingTeam team) {
		if (!teams.contains(team)) {
			teams.add(team);

		}
	}

	public void addRaceResults(RaceResult race) {
		if (!races.contains(race)) {
			races.add(race);
		}
	}

	public RaceResult[] getRaces() {
		return races.toArray(new RaceResult[races.size()]);
	}

	public Driver[] getDriverRanking() {
		ArrayList<Driver> drivers = new ArrayList<Driver>();
		for (RacingTeam racingTeam : teams) {
			for (int i = 0; i < racingTeam.getDrivers().length; i++) {
				drivers.add(racingTeam.getDrivers()[i]);

			}

		}
		Collections.sort(drivers);
		return drivers.toArray(new Driver[drivers.size()]);
	}
}