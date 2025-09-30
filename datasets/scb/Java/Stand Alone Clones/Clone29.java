public class Clone29 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:33067801
*  Stack Overflow answer #:33067913
*  And Stack Overflow answer#:33067919
*/
char wf () {
    Scanner input = new Scanner (System.in);
    System.out.println ("What is your choice? (x/o)");
    char choice = input.findInLine (".").charAt (0);
    while (choice != 'x' && choice != 'o') {
        System.out.println ("You must enter x or o!");
        choice = input.next ().charAt (0);
    }
    return choice;
}

char wf () {
    Scanner input = new Scanner (System.in);
    System.out.println ("What is your choice? (x/o)");
    if (input.findInLine (".") != null) {
        choice = input.findInLine (".").charAt (0);
        while (choice != 'x' && choice != 'o') {
            System.out.println ("You must enter x or o!");
            choice = input.findInLine (".").charAt (0);
        }
    }
    return choice;
}

}
