import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		System.out.println("========================");
		System.out.println("Press 1 to start");
		System.out.println("Press 2 to stop");
		System.out.println("========================");
		int choice = 0;
		ChangeState cState = new ChangeState();
		Thread handOne = new Thread(cState, "One");
		Thread handTwo = new Thread(cState, "Two");
		Thread handThree = new Thread(cState, "Three");

		while (choice != 1 && choice != 2) {
			Scanner scanner = new Scanner(System.in);
			try {
				choice = scanner.nextInt();
			} catch (InputMismatchException e) {
				choice = 0;
			}
			if (choice == 1) {

				handOne.start();
				handTwo.start();
				handThree.start();
			}
			while (choice != 2) {
				choice = scanner.nextInt();
				if (choice == 1) {
					System.out.println("Already running");
				}

			}

			break;

		}
		cState.setStop(true);
		try {
			handOne.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			handTwo.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			handThree.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
