//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class Shiptest
{
    public static void main( String args[] )
    {
        MovingThing test = new Ship();
        System.out.println("Ship 1 " + test);

        Ship test2 = new Ship(50,75);
        System.out.println("Ship 2 " + test2);

        Ship test3 = new Ship(7,7,6,5,1);
        test3.setX(3);
        test3.setY(5);
        System.out.println("Ship 3 " + test2);
    }
}
