
public class Main {
	public static void main(String[] args) {
		Computer cp1 = new Computer();
		System.out.println(cp1.mainboard);
		
		Mainboard board1 = new Mainboard();
		System.out.println(board1);
		
		cp1.mainboard = board1;
		System.out.println(cp1.mainboard);
		Mainboard board2 = new Mainboard();
		
		Computer cp2 = new Computer("Intel", board2, 500);
	}
	
	

}
