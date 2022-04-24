package tdd;

public class Money implements Expression{
    protected int amount;
    protected String currency;
    Money(int amount, String currency){
        this.amount=amount;
        this.currency = currency;
    }
    public boolean equals( Object obj){
        Money money = (Money) obj;
        return this.amount == money.amount && this.currency().equals(money.currency());
    }

    @Override
    public Expression times(int multiplier){
        return new Money(amount * multiplier,currency);
    }
    public static Money dollar(int amount){
        return new Money(amount,"USD");
    }
    public static Money franc(int amount){
        return new Money(amount,"CHF");
    }
    public String toString(){
        return amount + " " + currency;
    }

    public String currency() {
        return currency;
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(currency, to);
        return new Money(amount/rate,to);
    }
}
