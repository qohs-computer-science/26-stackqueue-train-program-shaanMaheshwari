/*
 * TODO: Name
 * TODO: Date
 * TODO: Class Period
 * TODO: Program Description
 */
import java.util.Scanner;
import java.io.File;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class MyProgram {
	public static int val = 0;
	public static void main(String[] args) {

		int limitTrackA = 100000, limitTrackB = 100000, limitTrackC = 100000;
	
		Scanner x = new Scanner(System.in);
		Queue<String> trainQ = new LinkedList<String>();

		try{
			File f = new File("HelloWorldProject/src/data.txt");
			x = new Scanner (f);
			String name = x.nextLine();
			System.out.println(name);
			trainQ.add(name);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		Stack<Train> first = new Stack<>();
		Stack<Train> track1 = new Stack<>();
		Stack<Train> trackA = new Stack<>();
		Stack<Train> trackB = new Stack<>();
		Stack<Train> trackC = new Stack<>();
		Stack<Train> trackD = new Stack<>();

		while(!trainQ.toLowerCase.equals("end")){
			Train car = trainQ.peek();
			if(car.getName().substring(0, 3).equals("CAR") && car.getMiles()> 700){
				track1.push(car);
			}
		}

	}
}
