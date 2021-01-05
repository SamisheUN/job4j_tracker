package ru.job4j.oop;

public class PolyUsage {
    public static void main(String[] args) {
        Bus liaz = new Bus();
        Plane wellington = new Plane();
        Train thomas = new Train();
        Vehicle bus = liaz;
        Vehicle plane = wellington;
        Vehicle train = thomas;
        Vehicle[] park = new Vehicle[]{bus, plane, train};
        for (Vehicle a : park) {
            a.move();
            a.fuel();
        }
    }
}
