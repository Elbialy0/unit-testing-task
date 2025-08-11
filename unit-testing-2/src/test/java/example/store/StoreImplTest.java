package example.store;

import example.account.AccountManager;
import example.account.AccountManagerImpl;
import example.account.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Currency;

import static org.mockito.Mockito.*;


public class StoreImplTest {
    @Test
    void giveProductWithValidQuantityThenSuccess(){
        // Arrange
        AccountManager accountManager = mock(AccountManagerImpl.class);
        Store store = new StoreImpl(accountManager);
        Customer customer = new Customer();
        Product product = new Product();
        product.setQuantity(50);
        product.setPrice(100);
        when(accountManager.withdraw(customer,product.getPrice())).thenReturn("success");
        // Act
        store.buy(product,customer);
        // Assert
        Assertions.assertEquals(49,product.getQuantity());
    }

    @Test
    void giveProductWithoutQuantityThenFail(){
        AccountManager accountManager = mock(AccountManagerImpl.class);
        Store store = new StoreImpl(accountManager);
        Customer customer = new Customer();
        Product product = new Product();
        product.setQuantity(0);
        product.setPrice(50);

      Assertions.assertThrows(RuntimeException.class,()->store.buy(product,customer));

    }

    @Test
    void giveProductWithFailureWithdrawThenFail(){
        AccountManager accountManager = mock(AccountManager.class);
        Store store = new StoreImpl(accountManager);
        Customer customer = new Customer();
        Product product = new Product();
        product.setQuantity(20);
        product.setPrice(50);

        when(accountManager.withdraw(customer,product.getPrice())).thenReturn("insufficient account balance");

        Assertions.assertThrows(RuntimeException.class,()->store.buy(product,customer));
    }
}
