package T2;

import java.util.Objects;

public class Pair<T1, T2>  {
    private final T1 first;
    private final T2 second;
    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }
    public T1 getFirst()  {  return first;  }
    public T2 getSecond() {  return second; }
    public boolean equals(Object o) {
        if (!(o instanceof Pair))
            return false;
        Pair<?,?> e = (Pair<?,?>)o;
        return Objects.equals(first, e.getFirst()) && Objects.equals(second, e.getSecond());
    }
    public int hashCode()    {  return Objects.hash(first, second); }
    public String toString() { return first + ":" + second;         }
}

