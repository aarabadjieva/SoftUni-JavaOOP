package bankAccount;


import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class BankAccountTest {
   private static final BigDecimal INITIAL_BALANCE = BigDecimal.valueOf(1500.00);
   private static final String INITIAL_NAME = "Name1";

   private BankAccount bankAccount;

   @Before
   public void create(){
      this.bankAccount =  new BankAccount(INITIAL_NAME, INITIAL_BALANCE);
   }


   @Test
    public void setNameShouldSetCorrectly(){
       assertEquals(this.bankAccount.getName(),INITIAL_NAME);
   }

   @Test(expected = IllegalArgumentException.class)
   public void setNameShouldThrowIfNameLengthLessThan3(){
      this.bankAccount = new BankAccount("Al", INITIAL_BALANCE);
   }

   @Test(expected = IllegalArgumentException.class)
   public void setNameShouldThrowIfNameLengthMoreThan25(){
      this.bankAccount = new BankAccount("Aleksandra Svetlinova Arabadjieva", INITIAL_BALANCE);
   }

   @Test
   public void setBalanceShouldSetCorrectly(){
      assertEquals(this.bankAccount.getBalance(), INITIAL_BALANCE);
   }

   @Test(expected = IllegalArgumentException.class)
   public void setBalanceShouldThrowIfBalanceLessThanZero(){
      this.bankAccount = new BankAccount(INITIAL_NAME,BigDecimal.valueOf(-12));
   }

   @Test
   public void depositShouldDepositCorrectly(){
      this.bankAccount.deposit(BigDecimal.TEN);
      assertEquals(INITIAL_BALANCE.add(BigDecimal.TEN),this.bankAccount.getBalance());
   }

   @Test(expected = UnsupportedOperationException.class)
   public void depositShouldThrowIfAmountEqualsZero(){
      this.bankAccount.deposit(BigDecimal.ZERO);
   }

   @Test(expected = UnsupportedOperationException.class)
   public void depositShouldThrowIfAmountIsLessThanZero(){
      this.bankAccount.deposit(BigDecimal.valueOf(-12));
   }

   @Test
   public void withdrawShouldSetCorrectBalance(){
      this.bankAccount.withdraw(BigDecimal.TEN);
      assertEquals(INITIAL_BALANCE.subtract(BigDecimal.TEN),this.bankAccount.getBalance());
   }

   @Test(expected = UnsupportedOperationException.class)
   public void withdrawShouldThrowIfBalanceIsLessThanAmount(){
      this.bankAccount.withdraw(INITIAL_BALANCE.add(BigDecimal.TEN));
   }

   @Test(expected = UnsupportedOperationException.class)
   public void withdrawShouldThrowIfAmountIsLessThanZero(){
      this.bankAccount.withdraw(BigDecimal.valueOf(-12));
   }

   @Test
   public void withdrawShoudReturnCorrectly(){
      BigDecimal amount = BigDecimal.TEN;
      assertEquals(this.bankAccount.withdraw(amount),amount);
   }
}