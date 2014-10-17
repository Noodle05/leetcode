public class Interval {
    int start;
    int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(start) * 31 + Integer.hashCode(end);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || !(other instanceof Interval))
            return false;
        final Interval obj = (Interval) other;
        return obj.start == start && obj.end == end;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(start).append("->").append(end);
        return sb.toString();
    }
}
