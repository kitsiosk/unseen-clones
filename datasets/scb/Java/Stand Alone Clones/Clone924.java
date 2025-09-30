public class Clone924 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:34281611
*  Stack Overflow answer #:34281876
*  And Stack Overflow answer#:34282592
*/
public static void main (String [] args) {
    ScottishPerson scottishPerson = new ScottishPerson ();
    BritishPerson britishPerson = new BritishPerson ();
    BritishPerson britishPersonUpcasted = new ScottishPerson ("Another scottish name");
    scottishPerson.salute ();
    scottishPerson.warcry ();
    System.out.println (scottishPerson.name);
    System.out.println (scottishPerson.clanName);
    britishPerson.salute ();
    System.out.println (britishPerson.name);
    britishPersonUpcasted.salute ();
    System.out.println (britishPersonUpcasted.name);
}

public static void main (String [] args) {
    Dog dog = new Dog ();
    Horse horse = new Horse ();
    Animal animal = dog;
    Animal horseAnimal = new Horse ();
    Dog upcastedAnimal = upcastToDog (animal);
    dog.saySomething ();
    dog.getTheBall ();
    upcastedAnimal.saySomething ();
    upcastedAnimal.getTheBall ();
    horse.saySomething ();
    horse.getTheBall ();
    try {
        Dog upcastedDog = upcastToDog (horseAnimal);
    } catch (Exception ex) {
        System.out.println (ex.getClass ().getSimpleName () + ": Obviously a horse is not a dog!");
    }
}

}
