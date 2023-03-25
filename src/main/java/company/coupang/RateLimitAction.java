//package company.coupang;
//
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class RateLimitAction {
//
//    private AtomicInteger currentCount = new AtomicInteger(0);
//    private int limit;
//
//    private StopWatch stopWatch;
//
//    private ReentrantLock reentrantLock = new ReentrantLock();
//
//    public RateLimitAction(int limit) {
//        this(limit , StopWatch.createStarted());
//    }
//
//    public RateLimitAction(int limit , StopWatch stopWatch) {
//        this.limit = limit;
//        this.stopWatch = stopWatch;
//    }
//
//    public boolean tryAcquire() throws InterruptedException {
//        int updateCount = currentCount.incrementAndGet();
//        if (updateCount <= limit) {
//            return true;
//        }
//
//        if (reentrantLock.tryLock(50, TimeUnit.MILLISECONDS)) {
//            try {
//                //update time
//                if (stopWatch.elapsed(TimeUnit.MILLISECONDS) > TimeUnit.SECONDS.toMillis(1)) {
//                    currentCount.set(0);
//                    stopWatch.reset();
//                }
//                updateCount = currentCount.incrementAndGet();
//
//                return updateCount <= limit;
//            } finally {
//                reentrantLock.unlock();
//            }
//        }
//    }
//
//}
