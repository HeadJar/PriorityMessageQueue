
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PriorityMessageQueue {

	private static final int queueNums = 5;
	public ArrayList<Queue<Message>> priorityList;

	PriorityMessageQueue() {
		priorityList = new ArrayList<Queue<Message>>(queueNums);

		for (int i = 0; i < queueNums; i++) {
			priorityList.add(new LinkedList<Message>());
		}
	}

	public void sortMessages(Message message) {
		int priority = message.getPriority();
		priorityList.get(priority).add(message);
	}

	public static void main(String[] args) {

	}

}
