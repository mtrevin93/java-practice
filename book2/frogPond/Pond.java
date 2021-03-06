public class Pond {
    
    public static void main (String[] args) {

        Frog Peepo = new Frog("Peepo");
        Frog Pepe = new Frog("Pepe", 10,15);
        Frog Peepaw = new Frog("Peepaw", 4.6, 5);
        Frog Pepper = new Frog("Pepper");

        Fly fly1 = new Fly(1, 3);
        Fly fly2 = new Fly(6);
        Fly fly3 = new Fly(1, 1);
        Pepper.grow();

        Frog.setSpecies("1331 Frogs");
        System.out.println(Peepo);
        Peepo.eat(fly2);
        System.out.println(fly2);
        Peepo.grow(8);
        Peepo.eat(fly2);
        System.out.println(fly2);
        System.out.println(Peepo);
        System.out.println(Pepper);
        Peepaw.grow(4);
        System.out.println(Peepaw);
        System.out.println(Pepe);

    }

}