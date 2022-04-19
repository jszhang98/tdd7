import java.util.Hashtable;

public class Bank {
    Hashtable rates = new Hashtable();
    public Expression reduce(Expression source, String to) {
        return source.reduce(this, to);
    }
    public int rate(String from, String to){
        if(from.equals(to)) return 1;
        Integer rate = (Integer) rates.get(new Pairs(from,to));
        return rate.intValue();
    }

    public void addRate(String from, String to, int rate) {
        rates.put(new Pairs(from,to),new Integer(rate));
    }
}
