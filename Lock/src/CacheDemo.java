import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheDemo {

	private Map<String, Object> cache = new HashMap<String, Object>();

	private ReadWriteLock rwl = new ReentrantReadWriteLock();

	public Object getData(String key) {

		rwl.readLock().lock();

		Object value = null;

		try {
			value = cache.get(key);
			if (value == null) {
				rwl.readLock().unlock(); // 没有数据，释放读锁，上写锁

				// 多个线程取上写锁，第一个上成功后，其他线程阻塞，第一个线程开始执行下面的代码
				// 最后释放写锁，后面的线程继续上写锁，为了避免后面的线程重复写入，进行第二次判断

				rwl.writeLock().lock();

				try {
					if (value == null) {
						value = "aaaa";
					}
				} finally {
					rwl.writeLock().unlock();
				}
				rwl.readLock().lock();
			}

		} finally {
			rwl.readLock().unlock();
		}
		return value;
	}

}
