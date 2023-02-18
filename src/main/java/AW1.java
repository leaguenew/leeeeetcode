
import java.util.ArrayList;
import java.util.List;
//需求分析：
//Say we have a number of bank accounts, and we want to make some transfers between these accounts at the end of each day
//        to make sure that each account will have at least 100 dollars after these transfers. Please write a program to implement
//        this. Each transfer will be presented as a tuple of (from_account, to_account, amount). For example, we have
//
//        For example:
//
//
//        bank_accounts = [(“a”, 80), (“b”, 180)， （"c", 90）] ->  [(“a”, 100), (“b”, 160)， （"c", 90）] -> [(“a”, 100), (“b”, 150)， （"c", 100）]
//        transfers = make_transfers(bank_accounts)
//
//        # transfers = [(“b”, “a”, 20)]
//
//算法设计：
//
//性能分析：
//
//
//单元测试：
//


public class AW1 {

     static class BankAccount {
        String accoutName;
        int amount;

         public BankAccount(String accoutName, int amount) {
             this.accoutName = accoutName;
             this.amount = amount;
         }
     }

    class TransferInfo {
        String fromAccount;
        String toAccount;
        int amount;

        public TransferInfo(String fromAccount, String toAccount, int amount) {
            this.fromAccount = fromAccount;
            this.toAccount = toAccount;
            this.amount = amount;
        }
    }

    /**
     * @function: make transfer of bank account
     * @param bankAccountList
     * @return res
     */
    public List<TransferInfo> makeTransfers(List<BankAccount> bankAccountList) {
        //corner case
        List<TransferInfo> res = new ArrayList<>();
        if (null == bankAccountList || bankAccountList.size() == 0) {
            //logger..
            return res;
        }

        //O(n2)
        for(int i = 0; i < bankAccountList.size(); i++) {
            BankAccount currentBankAccount = bankAccountList.get(i);
            if (currentBankAccount.amount >= 100) {
                continue;
            }
            int diff = 100 - currentBankAccount.amount;
            for(int j = 0; j < bankAccountList.size(); j++) {
                if (i == j) {
                    continue;
                }
                BankAccount targetBankAccount = bankAccountList.get(j);
                if (targetBankAccount.amount >= 100 + diff) {
                    TransferInfo transferInfo = new TransferInfo(bankAccountList.get(j).accoutName, bankAccountList.get(i).accoutName, diff);
                    res.add(transferInfo);
                    currentBankAccount.amount += diff;
                    targetBankAccount.amount -= diff;
                }
            }
        }

        BankAccount lastBankAccount = bankAccountList.get(bankAccountList.size() - 1);
        if (lastBankAccount.amount < 100) {
            int diff = 100 - lastBankAccount.amount;
            for(int j = 0; j < bankAccountList.size() - 1; j++) {
                BankAccount targetBankAccount = bankAccountList.get(j);
                if (targetBankAccount.amount >= 100 + diff) {
                    TransferInfo transferInfo = new TransferInfo(bankAccountList.get(j).accoutName, lastBankAccount.accoutName, diff);
                    res.add(transferInfo);
                    lastBankAccount.amount += diff;
                    targetBankAccount.amount -= diff;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        //case1: input is empty
        AW1 pro = new AW1();
//        List<BankAccount> list = null;
        List<BankAccount> list = new ArrayList<>();
        List<TransferInfo> res = pro.makeTransfers(list);
        System.out.println("res" + res);

        //case2: no result  [(“a”, 80)]

        //case3: common result [(“a”, 80), ("b", 130)]
        BankAccount bankAccount = new BankAccount("a", 80);
        BankAccount bankAccount1 = new BankAccount("b", 130);
        BankAccount bankAccount2 = new BankAccount("c", 90);
        BankAccount bankAccount3 = new BankAccount("d", 120);
        list.add(bankAccount1);
        list.add(bankAccount2);
        list.add(bankAccount3);
        list.add(bankAccount);
        res = pro.makeTransfers(list);
        for(TransferInfo item: res) {
            System.out.println(item.fromAccount + " " + item.toAccount + " " + item.amount );
        }

    }
}
