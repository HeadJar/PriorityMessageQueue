
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * 
 * @author Jarhead This assignment simulates the average waiting time for a
 *         message to be processed A message processed will take four iterations
 *         to be completed No Messages will be processed until every message is
 *         in the Queue Messages have a 20% chance of being created per
 *         iteration
 * 
 */
public class PriorityMessageQueue {
	// Number of priority Message Queues
	private static final int queueNums = 5;

	// Number of Messages to be created
	private static final int maxMessages = 15;

	// This is where the messages go when created
	public ArrayList<Queue<Message>> priorityList;

	// This is where they go when departed
	public ArrayList<ArrayList<Message>> departed;
	int time;

	/**
	 * Constructor will create an arrayList for both priority and departed lists.
	 */
	PriorityMessageQueue() {

		time = 0;
		priorityList = new ArrayList<Queue<Message>>(queueNums);
		departed = new ArrayList<ArrayList<Message>>();
		for (int i = 0; i < queueNums; i++) {
			priorityList.add(new LinkedList<Message>());
		}
		for (int i = 0; i < queueNums; i++) {
			departed.add(new ArrayList<Message>());
		}

	}

	/**
	 * This will take in a message and add it to the selected queue
	 * 
	 * @param message
	 *            This is the message taken in
	 */
	public void addMessageToQueue(Message message) {
		int priority = message.getPriority();
		priorityList.get(priority).add(message);
		System.out.println("The priority is : " + message.getPriority());
	}

	/**
	 * This will create a message A message has a 20% chance of being created
	 * 
	 * @param currentTime
	 *            This is the time at which the message is created(Arrival)
	 */
	// Twenty Percent Chance of creating a new Message
	public void createMessages(int currentTime) {
		Random random = new Random();
		int randomChance = random.nextInt(5);

		if (randomChance == 4) {
			addMessageToQueue(new Message(time));
		}
	}

	/**
	 * This will get the message count in the priorityList ArrayList
	 * 
	 * @return the amount of messages in priorityList
	 */
	public int totalMessageCount() {
		int size = 0;
		size = priorityList.get(0).size() + priorityList.get(1).size() + priorityList.get(2).size()
				+ priorityList.get(3).size() + priorityList.get(4).size();
		return size;
	}

	/**
	 * This will get the message count in the departed ArrayList
	 * 
	 * @return the amount of messages in departed
	 */
	public int totalMessageProcessed() {
		int size = 0;
		size = departed.get(0).size() + departed.get(1).size() + departed.get(2).size() + departed.get(3).size()
				+ departed.get(4).size();
		return size;
	}

	/**
	 * This will take in the current time and if the time is divisible by 4 then it
	 * will remove the message from the priorityQueue
	 * 
	 * @param currentTime
	 *            The current iteration
	 */
	public void processMessages(int currentTime) {
		Message message;
		if (currentTime % 4 == 0) {
			if (!priorityList.get(0).isEmpty()) {
				message = priorityList.get(0).remove();
				message.setDeparted(currentTime);
				departed.get(0).add(message);
			} else if (!priorityList.get(1).isEmpty() && priorityList.get(0).isEmpty()) {
				message = priorityList.get(1).remove();
				message.setDeparted(currentTime);
				departed.get(1).add(message);
			} else if (!priorityList.get(2).isEmpty() && priorityList.get(1).isEmpty()
					&& priorityList.get(0).isEmpty()) {
				message = priorityList.get(2).remove();
				message.setDeparted(currentTime);
				departed.get(2).add(message);
			} else if (!priorityList.get(3).isEmpty() && priorityList.get(2).isEmpty() && priorityList.get(1).isEmpty()
					&& priorityList.get(0).isEmpty()) {
				message = priorityList.get(3).remove();
				message.setDeparted(currentTime);
				departed.get(3).add(message);
			} else if (!priorityList.get(4).isEmpty() && priorityList.get(3).isEmpty() && priorityList.get(2).isEmpty()
					&& priorityList.get(1).isEmpty() && priorityList.get(0).isEmpty()) {
				message = priorityList.get(4).remove();
				message.setDeparted(currentTime);
				departed.get(4).add(message);
			}
		}
	}

	/**
	 * This prints out every message and will print out the average time it takes to
	 * process a message in each queue
	 * @param time 
	 * This is the time it starts processing information
	 */
	public void analyze(int time) {

		for (int i = 0; i < departed.size(); i++) {
			for (int j = 0; j < departed.get(i).size(); j++) {
				System.out.println("The current message is of priority: " + departed.get(i).get(j).getPriority());
				System.out.println("The priority is: " + departed.get(i).get(j).getPriority());
				System.out.println("The arrival is: " + departed.get(i).get(j).getArrival());
				System.out.println("the departure is: " + departed.get(i).get(j).getDeparted());
				System.out.println("---------------");
			}
		}
		for (int i = 0; i < departed.size(); i++) {
			double processingTime = 0;
			for (int j = 0; j < departed.get(i).size(); j++) {
				processingTime += departed.get(i).get(j).getDeparted() - departed.get(i).get(j).getArrival();
			}
			processingTime = processingTime / (departed.get(i).size());
			System.out.println("The average time of a message in queue " + i + " is, " + processingTime);
		}
		System.out.println();

	}

	public static void main(String[] args) {

		PriorityMessageQueue simulation = new PriorityMessageQueue();
		int messageNum = 0;
		int usedMessage = 0;
int timeStop;
		while (messageNum < maxMessages) {
			simulation.createMessages(simulation.time);
			messageNum = simulation.totalMessageCount();
			simulation.time++;
		}
		System.out.println();
		System.out.println("The time is everything was added in is " + simulation.time);
timeStop = simulation.time;
		System.out.println();
		while (usedMessage < maxMessages) {
			simulation.processMessages(simulation.time);
			usedMessage = simulation.totalMessageProcessed();
			simulation.time++;
		}
		System.out.println();
		System.out.println("The time everything is done is " + simulation.time);
		System.out.println();
		simulation.analyze(timeStop);
	}

}
