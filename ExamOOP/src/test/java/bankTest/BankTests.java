package bankTest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankTests {

    private Bank bank;
    private Client client;

    @Before
    public void createBank(){
        bank = new Bank("DSK",2);
        client = new Client("Rado");
    }
    @Test(expected = NullPointerException.class)
    public void testCreateBankShouldExeceptionInvalidName(){
        bank = new Bank(" ",2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateBankShouldExceptionInvalidCapacity(){
        bank = new Bank("DSK",-1);
    }

    @Test
    public void testGetName(){
        assertEquals("DSK",bank.getName());
    }

    @Test
     public void testGetCapacity(){
        assertEquals(2,bank.getCapacity());
    }

    @Test
    public void testGetCount(){
        bank.addClient(client);
        assertEquals(1,bank.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddClient(){
        bank.addClient(client);
        bank.addClient(new Client("Meri"));
        bank.addClient(new Client("Dani"));
    }

    @Test
    public void testRemoveClient(){
        bank.addClient(client);
        bank.addClient(new Client("Dani"));
        bank.removeClient("Dani");
        assertEquals(1,bank.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveClientShouldReturnException(){
        bank.addClient(client);
        bank.addClient(new Client("Dani"));
        bank.removeClient("Meri");
    }

    @Test
    public void testLoanWithdrawal(){
        bank.addClient(client);
        bank.addClient(new Client("Dani"));
        assertFalse(bank.loanWithdrawal("Rado").isApprovedForLoan());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLoanWithdrawalShouldReturnException(){
        bank.addClient(client);
        bank.addClient(new Client("Dani"));
        bank.loanWithdrawal("Meri");
    }

    @Test
    public void testStatistics(){

        bank.addClient(client);
        bank.addClient(new Client("Dani"));
        String currentString = "The client Rado, Dani is at the DSK bank!";
        assertEquals(currentString, bank.statistics());
    }
}
