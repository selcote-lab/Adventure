package com.tonasolution;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<>();
    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

	    locations.put(0, new Location(0, "You are sitting in front of a computer learning java"));
        locations.put(1, new Location(1, "You are standing at the end of the road 1"));
        locations.put(2, new Location(2, "You are standing at the end of the road 2"));
        locations.put(3, new Location(3, "You are standing at the end of the road 3"));
        locations.put(4, new Location(4, "You are standing at the end of the road 4"));
        locations.put(5, new Location(5, "You are standing at the end of the road 5"));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);
//        locations.get(1).addExit("Q", 0);


        locations.get(2).addExit("N", 5);
//        locations.get(2).addExit("Q", 0);

        locations.get(3).addExit("W", 1);
//        locations.get(3).addExit("W", 0);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);
//        locations.get(4).addExit("Q", 0);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);
//        locations.get(5).addExit("Q", 0);

        int loc = 1;
        while(true){
            System.out.println(locations.get(loc).getDescription());

            if(loc == 0) break;

            Map<String, Integer> exists = locations.get(loc).getExists();

            for(String exit: exists.keySet()){
                System.out.print(exit + " , ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();

            if(exists.containsKey(direction)){
                loc = exists.get(direction);
            } else {
                System.out.println("You cannot go in that direction");
            }
        }
    }
}
