import java.util.Objects;

public class Pairs {
    private String from;
    private String to;
    Pairs (String from, String to){
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pairs pairs = (Pairs) o;
        return Objects.equals(from, pairs.from) && Objects.equals(to, pairs.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
