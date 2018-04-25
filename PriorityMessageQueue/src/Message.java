
public class Message implements Comparable{
	public int priority;
	public int arrival;
	
	public Message(int priority, int arrival) {
		this.priority = priority;
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
