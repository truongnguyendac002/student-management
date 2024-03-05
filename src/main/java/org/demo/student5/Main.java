package org.demo.student5;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class Chicken{
    private int eggs;

    public Chicken(int eggs) {
        this.eggs = eggs;
    }

}

public class Main{
    public static void test(Chicken a) {
        a.setEggs(10);
        System.out.println(a.getEggs());
    }

    public static void main(String[] args) {
        Chicken a = new Chicken(5);
        test(a);
        System.out.println(a.getEggs());
    }
}