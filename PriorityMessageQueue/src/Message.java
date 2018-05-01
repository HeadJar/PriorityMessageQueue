import java.util.Random;


public class Message  {
	public int priority;
	public int arrival;
	public int departed;
	public Random random = new Random();
	
	public Message(int arrival) {
		
		this.priority = random.nextInt(5);
		this.arrival = arrival;
	}
	
	public int getPriority() {
		return priority;
	}

	public int getArrival() {
		return arrival;
	}
	public int getDeparted() {
		return departed;
	}
	public void setDeparted(int time) {
		departed = time;
	}
	
	
	

	
	
}
