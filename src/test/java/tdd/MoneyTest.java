package tdd;

import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MoneyTest {
    @Test
    public void testMultiplication(){
        Money five = Money.dollar(5);
        Assert.assertEquals(Money.dollar(10), five.times(2));
        Assert.assertEquals(Money.dollar(15),five.times(3));
    }
    @Test
    public void testEquality(){
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(6)));
    }
    @Test
    public void testCurrency(){
        Assert.assertEquals("USD", Money.dollar(5).currency());
        Assert.assertEquals("CHF", Money.franc(5).currency());
    }
    @Test
    public void testSimpleAddition(){
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Expression reduced = bank.reduce(sum,"USD");
        Assert.assertEquals(Money.dollar(10),reduced);

    }
    @Test
    public void testPlusReturnSum(){
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum)result;
        Assert.assertEquals(five,sum.augend);
        Assert.assertEquals(five,sum.addend);
    }
    @Test
    public void testReduceMoney(){
        Bank bank = new Bank();
        Expression result = bank.reduce(Money.dollar(1),"USD");
        Assert.assertEquals(Money.dollar(1),result) ;
    }
    @Test
    public void testReduceDifferentCurrency(){
        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);
        Expression result = bank.reduce(Money.franc(2),"USD");
        Assert.assertEquals(Money.dollar(1),result);
    }
    @Test
    public void testArrayEquals(){
        Assert.assertEquals(new Pairs("USD","CHF"),new Pairs("USD","CHF"));
    }
    @Test
    public void testIdentityRate(){
        Assert.assertEquals(1,new Bank().rate("USD","USD"));
    }
    @Test
    public void testMixedAddition(){
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);
        Expression result = bank.reduce(fiveBucks.plus(tenFrancs),"USD");
        Assert.assertEquals(Money.dollar(10),result);

    }
    @Test
    public void testSumPlusMoney(){
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);
        Expression sum = new Sum(fiveBucks,tenFrancs).plus(Money.dollar(5));
        Expression result = bank.reduce(sum,"USD");
        Assert.assertEquals(Money.dollar(15),result);
    }
    @Test
    public void testSumTimes(){
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);
        Expression sum = new Sum(fiveBucks,tenFrancs).times(2);
        Expression result = bank.reduce(sum,"USD");
        Assert.assertEquals(Money.dollar(20),result);
    }

}
