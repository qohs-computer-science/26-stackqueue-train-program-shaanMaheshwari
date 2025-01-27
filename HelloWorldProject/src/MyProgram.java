/*
 * Shaan Maheshwari
 * 1/27/25
 * Pd. 3
 * This program took input from a file and sorted it as trains with cars and engines. This also follows the restrictions given.
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
			
			while (!name.toLowerCase().equals("end")){
				if(name.substring(0,3).equals("CAR")){
					String product = x.nextLine();
					String origin = x.nextLine();
					String dest = x.nextLine();
					int weight = x.nextInt();
					int miles = x.nextInt();
					x.nextLine();
					trainQ.add(new Train(name, product, origin, dest, weight, miles));

				} else {
					String dest = x.nextLine();
					trainQ.add(new Train(name, dest));

				}//end if else

				name = x.nextLine();
			}//end while
		}//end try
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}//end catch

		Stack<Train> track1 = new Stack<>();
		Stack<Train> trackA = new Stack<>();
		Stack<Train> trackB = new Stack<>();
		Stack<Train> trackC = new Stack<>();
		Stack<Train> trackD = new Stack<>();
		int weightA = 0;
		int weightB = 0;
		int weightC = 0;
		int counter = 0;

		while(!trainQ.isEmpty()){
			Train car = trainQ.remove();
			if(car.getName().substring(0, 3).equals("CAR") && car.getMiles()> 700){
				track1.push(car);
				car.setMiles();
			} else {
			 	if(car.getDestination().equals("Trenton")){
					if(car.getName().substring(0,3).equals("CAR")){
						if(weightA + car.getWeight() <= limitTrackA){
							trackA.push(car);
							weightA += car.getWeight();
						} else {
							System.out.println("Sent out to Trenton");
							System.out.println("ENG00000 leaving for Trenton with following cars: ");
							while(!trackA.isEmpty()){
								Train temp = trackA.pop();
								System.out.println(temp.getName() + " containing " + temp.getProduct() + " with " + temp.getMiles() + " miles");
							}//end while
							trackA.push(car);
							System.out.println(weightA + " " + car.getWeight());

							weightA = car.getWeight();
							System.out.println(weightA + " " + car.getWeight());
							System.out.println("");

						}//end if else
						
					} else {
						System.out.println("Sent out to Trenton");
						System.out.println(car.getName() + " leaving for " + car.getDestination() + " with the following cars: ");
						while(!trackA.isEmpty()){
								Train temp = trackA.pop();
								System.out.println(temp.getName() + " containing " + temp.getProduct() + " with " + temp.getMiles() + " miles");
						}//end while
						System.out.println(weightA);
						weightA = 0;
						System.out.println("");
					}//end if else
					


				} else if(car.getDestination().equals("Charlotte")){
					if(car.getName().substring(0,3).equals("CAR")){
						if(weightB + car.getWeight() <= limitTrackB){
							trackB.push(car);
							weightB += car.getWeight();
						} else {
							System.out.println("Sent out to Charlotte");
							System.out.println("ENG00000 leaving for Charlotte with following cars: ");
							while(!trackB.isEmpty()){
								Train temp = trackB.pop();
								System.out.println(temp.getName() + " containing " + temp.getProduct() + " with " + temp.getMiles() + " miles");
							}//end while
							trackB.push(car);
							System.out.println(weightB + " " + car.getWeight());
							weightB = car.getWeight();
							System.out.println(weightB + " " + car.getWeight());
							System.out.println("");
						}//end if else
					} else {
						System.out.println("Sent out to Charlotte");
						System.out.println(car.getName() + " leaving for " + car.getDestination() + " with the following cars: ");
						while(!trackB.isEmpty()){
								Train temp = trackB.pop();
								System.out.println(temp.getName() + " containing " + temp.getProduct() + " with " + temp.getMiles() + " miles");
						}//end while
						System.out.println(weightB);
						weightB = 0;
						System.out.println("");
					}//end if else
				} else if(car.getDestination().equals("Baltimore")){
					if(car.getName().substring(0,3).equals("CAR")){
						if(weightC + car.getWeight() <= limitTrackC){
							trackC.push(car);
							weightC += car.getWeight();
						} else {
							System.out.println("Sent out to Baltimore");
							System.out.println("ENG00000 leaving for Baltimore with following cars: ");
							while(!trackC.isEmpty()){
								Train temp = trackC.pop();
								System.out.println(temp.getName() + " containing " + temp.getProduct() + " with " + temp.getMiles() + " miles");
							}//end while
							trackC.push(car);
							System.out.println(weightC + " " + car.getWeight());

							weightC = car.getWeight();
							System.out.println(weightC + " " + car.getWeight());
							System.out.println("");

						}//end if else
					} else {
						System.out.println("Sent out to Baltimore");
						System.out.println(car.getName() + " leaving for " + car.getDestination() + " with the following cars: ");
						while(!trackC.isEmpty()){
							Train temp = trackC.pop();
							System.out.println(temp.getName() + " containing " + temp.getProduct() + " with " + temp.getMiles() + " miles");
						}//end while
						weightC = 0;
						System.out.println("");
					}//end if else
				} else {
					trackD.push(car);
					System.out.println("");
				}//end if else
			}//end if if else else
			if(!trainQ.isEmpty() && counter == 0){
				counter++;
				while(!track1.isEmpty()){
					trainQ.add(track1.pop());
				}//end while	
			}//end if
		}//end while

		System.out.println("Trains leaving for other destinations: ");
		while(!trackD.isEmpty()){
			Train temp = trackD.pop();
			System.out.println(temp.getName() + " containing " + temp.getProduct() + " with " + temp.getMiles() + " miles");
		}//end while
		System.out.println(""); 
	}//end main
}//end class
