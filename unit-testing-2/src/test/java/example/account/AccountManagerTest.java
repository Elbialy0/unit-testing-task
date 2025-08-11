package example.account;

import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AccountManagerTest {

    @Test
    void givenCustomerWithSufficientBalance_whenWithdraw_thenSucceed() {
        // Arrange
        AccountManager am = new AccountManagerImpl();
        Customer c = new Customer();
        c.setBalance(1000);

        // Act
        String result = am.withdraw(c, 500);

        // Assert
        Assertions.assertEquals("success", result);
        Assertions.assertEquals(500, c.getBalance());
    }

    @Test
    void givenCustomerWithInSufficientBalanceAndWithoutCreditAllowedThenFail(){
        // Arrange
        AccountManager am = new AccountManagerImpl();
        Customer customer = new Customer();
        customer.setBalance(100);
        customer.setCreditAllowed(false);
        //Act
        String result = am.withdraw(customer,1000);
        //Assert
        Assertions.assertEquals("insufficient account balance",result);

    }
    @Test
    void givenCustomerWithInSufficientBalanceAndCreditAllowedThenSuccess(){
        AccountManager accountManager = new AccountManagerImpl();
        Customer customer = new Customer();
        customer.setBalance(500);
        customer.setCreditAllowed(true);

        String result = accountManager.withdraw(customer,1000);
        Assertions.assertEquals("success",result);
    }
    @Test
    void givenNonVipCustomerWithInSufficientBalanceAndCreditAllowedThenFail(){

        AccountManager accountManager = new AccountManagerImpl();
        Customer customer = new Customer();
        customer.setBalance(500);
        customer.setCreditAllowed(true);
        customer.setVip(false);

        String result = accountManager.withdraw(customer,3000);
        Assertions.assertEquals("maximum credit exceeded",result);
    }
    @Test
    void givenVipCustomerWithInSufficientBalanceAndCreditAllowedThenSuccess(){
        AccountManager accountManager = new AccountManagerImpl();
        Customer customer = new Customer();
        customer.setBalance(200);
        customer.setCreditAllowed(true);
        customer.setVip(true);

        String result = accountManager.withdraw(customer,5000);
        Assertions.assertEquals("success",result);
    }
    @Test
    void givenVipCustomerWithInSufficientBalanceAndWithoutCreditAllowedThenFail(){
        AccountManager accountManager = new AccountManagerImpl();
        Customer customer = new Customer();
        customer.setBalance(100);
        customer.setVip(true);
        customer.setCreditAllowed(false);

        String result = accountManager.withdraw(customer,5000);
        Assertions.assertEquals("insufficient account balance",result);
    }
    @Test
    void givenCustomerWithValidAmountThenAmountAddedToBalance(){
        AccountManager accountManager = new AccountManagerImpl();
        Customer customer = new Customer();

        accountManager.deposit(customer,500);
        Assertions.assertEquals(500,customer.getBalance());
    }
    @Test
    void givenCustomerWithInvalidAmountThenAmountNotAddedToBalance(){
        AccountManager accountManager = new AccountManagerImpl();
        Customer customer = new Customer();

        accountManager.deposit(customer,-100);
        Assertions.assertEquals(0,customer.getBalance());
    }

}
