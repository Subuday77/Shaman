
public class ChangeState implements Runnable {

	private boolean stop;
	Hands hand = new Hands();

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {
		stop = false;
		while (!stop) {
			String threadName = Thread.currentThread().getName();
			switch (threadName) {
			case "One":
				boolean state = Math.random() < 0.5;
				hand.setHandOneState(state);
				break;
			case "Two":
				hand.setHandTwoState(Math.random() < 0.5);
				break;
			case "Three":
				hand.setHandThreeState(Math.random() < 0.5);
			default:
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			hand.printResult();
		}

	}

}
