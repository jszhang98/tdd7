public class Sum implements Expression{
    Expression augend;
    Expression addend;

    public Sum(Expression augend, Expression addend) {
        this.augend=augend;
        this.addend = addend;
    }
    @Override
    public Money reduce(Bank bank,String to) {
        int amount = this.augend.reduce(bank,to).amount+addend.reduce(bank,to).amount;
        return new Money(amount,to);
    }


    @Override
    public Expression times(int multiplier){
        return new Sum(this.augend.times(multiplier),this.addend.times(multiplier));
    }
}
