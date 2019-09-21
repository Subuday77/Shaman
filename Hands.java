
public class Hands {

	private boolean handOneState;
	private boolean handTwoState;
	private boolean handThreeState;

	public void setHandOneState(boolean handOneState) {
		this.handOneState = handOneState;
	}

	public void setHandTwoState(boolean handTwoState) {
		this.handTwoState = handTwoState;
	}

	public void setHandThreeState(boolean handThreeState) {
		this.handThreeState = handThreeState;
	}

	public synchronized void printResult() {
		int count = 0;
		boolean[] handsState = new boolean[3];
		handsState[0] = handOneState;
		handsState[1] = handTwoState;
		handsState[2] = handThreeState;
		for (Boolean h : handsState) {
			if (h) {
				++count;
			}
		}
		switch (count) {
		case 0:
			System.out.println("Clap!");
			break;
		case 1:
			System.out.println("Clap! Fap!");
			break;
		case 2:
			System.out.println("Fap!");
			break;
		case 3:
			System.out.println("Fap!");
		default:
			break;
		}
	}
}
