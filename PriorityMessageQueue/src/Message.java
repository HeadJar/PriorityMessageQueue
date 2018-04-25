import java.util.Random;


public class Message implements Comparable{
	public int priority;
	public int arrival;
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
	@Override
	public int compareTo(Object message) {
		return priority - ((Message) message).getPriority();
		
		
	}
	

	
	
}
