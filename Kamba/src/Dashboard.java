
import java.util.Arrays;

public class Dashboard implements IDashboard {

	private int size;
	private transient Task[] tasks;
	private transient int modCount = 0;

	
	public boolean add(Task task) {
		ensureCapacity(size + 1);
		tasks[size++] = task;
		return true;
	}

	public void ensureCapacity(int minCapacity) {
		modCount++;
		int oldCapacity = tasks.length;
		if (minCapacity > oldCapacity) {
			int newCapacity = (oldCapacity * 3) / 2 + 1;
			if (newCapacity < minCapacity)
				newCapacity = minCapacity;
			
			tasks = Arrays.copyOf(tasks, newCapacity);
		}
	}

	public boolean remove(Task task) {
		if (task == null) {
			for (int index = 0; index < size; index++)
				if (tasks[index] == null) {
					fastRemove(index);
					return true;
				}
		} else {
			for (int index = 0; index < size; index++)
				if (task.equals(tasks[index])) {
					fastRemove(index);
					return true;
				}
		}
		return false;
	}

	
	private void fastRemove(int index) {
		modCount++;
		int numMoved = size - index - 1;
		if (numMoved > 0)
			System.arraycopy(tasks, index + 1, tasks, index, numMoved);
		tasks[--size] = null; // Let gc do its work
	}

	public void clear() {
		modCount++;

		// Let gc do its work
		for (int i = 0; i < size; i++)
			tasks[i] = null;

		size = 0;
	}

	public Dashboard(int initialCapacity) {
		super();
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
		this.tasks = new Task[initialCapacity];
	}

	public Dashboard() {
		this(10);
	}
}