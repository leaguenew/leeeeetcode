//package company.coupang;
//
//import java.util.concurrent.ConcurrentHashMap;
//
//public class RateLimiter {
//
//    private ConcurrentHashMap<String, RateLimitAction> counters = new ConcurrentHashMap<String, RateLimitAction>();
//
//    public RateLimiter() {
//
//        //
//    }
//
//    public boolean limit(String appId, String url, int limit) throws InterruptedException {
//
//        String counterKey = appId + ":" + url;
//        RateLimitAction rateLimitAction = counters.get(counterKey);
//
//        if (null == rateLimitAction) {
//            rateLimitAction = new RateLimitAction(limit);
//            counters.putIfAbsent(counterKey, rateLimitAction);
//        }
//
//        return rateLimitAction.tryAcquire();
//    }
//}
