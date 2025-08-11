package example.account;

public class AccountManagerImpl implements AccountManager {
    private static final int MAX_CREDIT = 1000;
    @Override
    public void deposit(Customer customer, int amount) {
        // negative value added to balance so I update
        if(amount>0) {
            customer.setBalance(customer.getBalance() + amount);
        }
    }

    @Override
    public String withdraw(Customer customer, int amount) {
        int expectedBalance = customer.getBalance() - amount;

        if (expectedBalance < 0) {
            if (!customer.isCreditAllowed()) {
                return "insufficient account balance";
                // here there is a problem with expectedBalance> MAX_CREDIT gives always false
                // as, expectedBalance here always be negative, so, I update it
            } else if (expectedBalance*-1 > MAX_CREDIT && !customer.isVip()) {
                return "maximum credit exceeded";
            }
        }
        customer.setBalance(expectedBalance);
        return "success";
    }
}
