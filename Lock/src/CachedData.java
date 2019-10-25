import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CachedData {
	Object data;
	volatile boolean cacheValid;

	ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

	void processCachedData() {

		rwl.readLock().lock();

		if (!cacheValid) {

			rwl.readLock().unlock();
			rwl.writeLock().lock();

			if (!cacheValid) {
				data = 123;
				cacheValid = true;
			}

			rwl.readLock().lock();

			rwl.writeLock().unlock();

		}

		// Use(data);
		rwl.readLock().unlock();
	}

}
