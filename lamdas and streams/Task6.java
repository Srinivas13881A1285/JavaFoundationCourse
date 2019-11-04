package lamdas;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class Task6 {
    public static void main(String[] args) {
        List<Point> points = Arrays.asList(
                new Point(1,2),
                new Point(3,4),
                new Point(5,6),
                new Point(7,8),
                new Point(9,10)
        );

        Points collect = points.stream().collect(new PointToPointsCollector());
        System.out.println("collect = " + collect);
    }
}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }
}

class Points {
    private Set<Integer> xs;
    private Set<Integer> ys;

    public Points(Set<Integer> xs, Set<Integer> ys) {
        this.xs = xs;
        this.ys = ys;
    }

    public Set<Integer> getXs() {
        return xs;
    }

    public void setXs(Set<Integer> xs) {
        this.xs = xs;
    }

    public Set<Integer> getYs() {
        return ys;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Points)) return false;
        Points points = (Points) o;
        return Objects.equals(xs, points.xs) && Objects.equals(ys, points.ys);
    }

    @Override
    public int hashCode() {

        return Objects.hash(xs, ys);
    }

    public void setYs(Set<Integer> ys) {
        this.ys = ys;
    }

    @Override
    public String toString() {
        return "Points{" + "xs=" + xs + ", ys=" + ys + '}';
    }
}

class PointToPointsCollector implements Collector<Point, List<Point>, Points> {

    @Override
    public Supplier<List<Point>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<Point>, Point> accumulator() {
        return List::add;
    }

    @Override
    public BinaryOperator<List<Point>> combiner() {
        return (acc, ps) -> {
            acc.addAll(ps);
            return acc;
        };
    }

    @Override
    public Function<List<Point>, Points> finisher() {
        return (points -> {
            final Set<Integer> xs = new HashSet<>();
            final Set<Integer> ys = new HashSet<>();

            for (Point p : points) {
                xs.add(p.getX());
                ys.add(p.getY());
            }
            return new Points(xs, ys);
        });

    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED));
    }
}