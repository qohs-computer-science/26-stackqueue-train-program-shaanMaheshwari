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
		Queue<Train> trainQ = new LinkedList<Train>();

		try{
			File f = new File("HelloWorldProject/src/data.txt");
			x = new Scanner (f);
			String name = x.nextLine();
			System.out.println(name);
			while (name.toLowerCase().equals("end")){
				if(name.substring(0,3).equals("CAR")){
					String name2 = x.nextLine();
					String product = x.nextLine();
					String origin = x.nextLine();
					String dest = x.nextLine();
					int weight = x.nextInt();
					int miles = x.nextInt();

					trainQ.add(new Train(name2, product, origin, dest, weight, miles));
				} else {
					String name2 = x.nextLine();
					String dest = x.nextLine();
					trainQ.add(new Train(name2, dest));
				}
			}
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
		int weightA = 0;
		int weightB = 0;
		int weightC;

		while(!trainQ.isEmpty()){
			Train car = trainQ.remove();
			if(car.getName().substring(0, 3).equals("CAR") && car.getMiles()> 700){
				track1.push(car);
				
			} else if(car.getDestination().equals("Trenton")){
					if(car.getName().substring(0,3).equals("CAR")){
						if(weightA + car.getWeight() <= limitTrackA){
							trackA.push(car);
							trainQ.remove(car);
							weightA += car.getWeight();
						} else {
							System.out.println("ENG00000 leaving for Trenton with cars: ");
							while(!trackA.isEmpty()){
								Train temp = trackA.pop();
								System.out.println(temp.getName() + " containing " + temp.getProduct());
							}
							System.out.println("Sent out to Trenton");
							trackA.push(car);
						}
						
					} else {
						while(!trackA.isEmpty()){
							Train temp = trackA.pop();
							System.out.println(temp.getName() + " leaving for " + temp.getDestination() + " with the following cars: ");
						}
					}



				} else if(car.getDestination().equals("Charlotte")){
					if(car.getName().substring(0,3).equals("CAR")){
						if(weightB + car.getWeight() <= limitTrackB){
							trackB.push(car);
							trainQ.remove(car);
							weightB += car.getWeight();
						} else {
							System.out.println("ENG00000 leaving for Trenton with cars: ");
							while(!trackB.isEmpty()){
								Train temp = trackB.pop();
								System.out.println(temp.getName() + " containing " + temp.getProduct());
							}
							System.out.println("Sent out to Trenton");
							trackA.push(car);
						}
						
					} else {
						while(!trackB.isEmpty()){
							Train temp = trackB.pop();
							System.out.println(temp.getName() + " leaving for " + temp.getDestination() + " with the following cars: ");
						}
					}
				}


		}


	}
}
