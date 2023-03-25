package company;

import java.util.*;


//        # list of customer ids (sort by total amount desc)
//
//        note: 数据结构不需要自己实现。可以使用现成的库
//
//需求：资金账户系统(算法设计 + 系统设计)
//1)创建一个账户(每个人都有一个账户，uuid)，存入金额（amount）
//        def create_customer(amount:int) -> str
//2)有一个推荐者，推荐了一个人来创建账户，相应的推荐者也会获取到对应金额的奖励
//                def create_customer_with_referer(amount:int, referer: str) -> str
//备注：如果推荐者没有账户，不需要给他添加
//3)找到topK,并且需要大于一个最小金额的，返回这些账户的id
//                def list_customers_by_total_amount(k: int, min_total_amount: int) -> List[str]
//
//约束：
//1)数据结构放在内存中
//2)
//
//算法设计：
//1)数据结构
////class Account() {
////    int amount;
////    String uuid;
////}
//TreeMap:
//        key : uuid
//        value: amount
//
//2)算法流程
//
//测试用例：
//1)
//
//复杂度分析：
//1)

public class AW {

    class Account {
        String uuid;
        int amount;

        public Account(String uuid, int amount) {
            this.uuid = uuid;
            this.amount = amount;
        }
    }

    private Map<String, Account> id2account = new HashMap<>();

    //使用的是大顶堆
    private PriorityQueue<Account> priorityQueue = new PriorityQueue<>(new Comparator<Account>() {
        @Override
        public int compare(Account o1, Account o2) {
            return o2.amount - o1.amount;
        }
    });

    /**
     * 时间复杂度：O(logN)
     * @param amount
     * @return
     */
    public String createCustomer(int amount) {
        if (amount <= 0) {
            //logger..
            return null;
        }

        String uuid = UUID.randomUUID().toString();
        id2account.put(uuid, new Account(uuid, amount));
        priorityQueue.add(new Account(uuid, amount));
        return uuid;
    }

    /**
     * 时间复杂度：O(logN)
     * @param amount
     * @return
     */
    public String createCustomerWithReferer(int amount, String referer) {
        if (amount <= 0) {
            //logger..
            return null;
        }

        String uuid = UUID.randomUUID().toString();
        id2account.put(uuid, new Account(uuid, amount)); //
        priorityQueue.add(new Account(uuid, amount)); //logN
        id2account.put(referer, new Account(referer, id2account.get(referer).amount + amount));

        priorityQueue.remove(id2account.get(referer));
        priorityQueue.add(new Account(referer,  id2account.get(referer).amount + amount));
        return uuid;
    }

    /**
     * 时间复杂度：O(k * logN)
     * @param minTotalAmount
     * @return
     */
    public List<String> listCustomersByTotalAmount(int k, int minTotalAmount) {
        List<String> resIds = new ArrayList<>();
        if (k <= 0) {
            //logger..
            return resIds;
        }

        //O(k * logN)
        while( k-- > 0 && !priorityQueue.isEmpty() && priorityQueue.peek().amount > minTotalAmount) {
            Account account = priorityQueue.poll();
            resIds.add(account.uuid);
        }

        return resIds;
    }

}





