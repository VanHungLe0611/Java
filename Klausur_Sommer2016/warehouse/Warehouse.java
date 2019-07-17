package warehouse;

import java.util.ArrayList;

public class Warehouse {

	private ArrayList<Pallet> pallets = new ArrayList<Pallet>();
	private int capacity;

	public Warehouse(int capacity) {
		super();
		if (capacity < 0) {
			throw new CapacityException();

		} else
			this.capacity = capacity;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public void addPallet(Pallet pallet) {
		if (pallets.size() < capacity) {
			if (!pallets.contains(pallet)) {
				pallets.add(pallet);

			}
		}

	}

	public boolean hasPallet(Pallet pallet) {
		if (pallets.contains(pallet)) {
			return true;
		} else
			return false;

	}

	public void removePallet(Pallet pallet) {
		if (pallets.contains(pallet)) {
			pallets.remove(pallet);

		}

	}

	public Pallet[] getInventory() {
		return pallets.toArray(new Pallet[pallets.size()]);

	}

	public Pallet[] getInventory(String destination) {
		ArrayList<Pallet> newPallets = new ArrayList<Pallet>();
		for (int i = 0; i < pallets.size(); i++) {
			if (pallets.get(i).getDestination().equals(destination)) {
				newPallets.add(pallets.get(i));
			}

		}
		return newPallets.toArray(new Pallet[newPallets.size()]);

	}
	
	@Override
	public String toString() {
		String string = "";
		for (Pallet pallet : pallets) {
			string += pallet + "\n";
			
		}
		return string;
	}

}
