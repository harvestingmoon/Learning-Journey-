package dsalgo;
import java.util.*;

import javax.sound.sampled.SourceDataLine;
// this is a general note or overview of different data structures & algorithms exisiting within java 
// they do not cover the complicated aspects of it (e.g. Singly & Doubly Linked List)
// These are notes taken down from AmigosCode
class array{
    array() {
        String[] colors = new String[5];
        colors[0] = "purple";
        colors[1] = "blue";
        
        System.out.println(Arrays.toString(colors));
        //System.out.println(colors[0]);
        //System.out.println(colors.length);
        //m1 to loop through arrays 
        int[] numbers = {100,200}; 
        for (int i = 0 ; i < colors.length; i ++) {
            System.out.println(colors[i]);
        }
        //m2 to loop arrays
        for (String color: colors) {
            System.out.println(color);
        }
        //m3 using streams for looping through arrays 
        Arrays.stream(colors).forEach(System.out::println);
    }  

}

class twodarrays {
    twodarrays() {
        char[][] board = new char[3][3];
        for (int i = 0; i <3; i ++ ) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        for (int i = 0; i < 3; i ++) {
            board[i][0] = '0';
        }
        // prints out the same value as top but is much faster 
        char[][] boardtwo = new char[][] {
            new char[] {'0', '-', '-'},
            new char[] {'0', '-', '-'},
            new char[] {'0', '-', '-'}
        };

// since it is a 2d array , need to pass in deep a
        System.out.println(Arrays.deepToString(boardtwo));
    }
}
// allows duplicates + not fixed in size like arrays 

class arraylist {
    arraylist() { 
        List.of(
            "blue","yellow"
        );
        // <> meaning exclusive data type  
        // list
        List<String> colors2 = new ArrayList<>();
        colors2.add("blue");
        colors2.add("cue");
        System.out.println(colors2);

        for (String color: colors2) {
            System.out.println(color);
        }
        // it is a list but the underlying hood still lies in arrays
        
    }
}

class stacks {
    stacks() { 
        Stack<Integer > stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek()); // shows you what is the code on top 
        System.out.println(stack.size()); // showing the number of integers inside the stack
        System.out.println(stack.pop()); // pop the top and also remove it 
        System.out.println(stack.empty()); // returns boolean
        // Follows the LIFO method (Last in First out method)
    }
}

class queue { 
    queue() {
        
        Queue<Person> supermarket = new LinkedList<>();
        supermarket.add(new Person("Tim", 21)); 
        supermarket.add(new Person("Ally",14));
        supermarket.add(new Person("Axx",44));
        
        System.out.println(supermarket.size());
        System.out.println(supermarket.peek());
        System.out.println(supermarket.poll()); // returns tim but removes it from the list as well
        System.out.println(supermarket.size());

    }
    static record Person(String name, int age) {

    }
        //Follows the FIFO method (head + tail method)
        // First In First Out method
}
// very expensive when it comes to memory
// linked list
//utilises node as pointers to point to the following nodes

class linkedlist{
    linkedlist() {
        LinkedList<Test> linkedlist = new LinkedList();
        linkedlist.add(new Test("value",1));
        linkedlist.add(new Test("string2", 2));
        ListIterator<Test> tListIterator = linkedlist.listIterator();
        while (tListIterator.hasNext()) {
            System.out.println(tListIterator.next());
        }
        // shows a doubly linked list (meaning that it will point to both fwd and aft of the nodes)
        while (tListIterator.hasPrevious()) {
            System.out.println(tListIterator.previous());
        }
        System.out.println(linkedlist);
        
    }
    
    static record Test(String string, int value) {

    };

}
// no duplicates are allowed in sets & not reflected in sets
class sets{
    sets() {
        Set<Ball> balls = new HashSet<>(); //utilises hashmapping
        balls.add(new Ball("blue"));
        balls.add(new Ball("blue"));
        balls.add(new Ball("yellow"));
        balls.add(new Ball("red"));
        System.out.println(balls.size()); 
        balls.forEach(System.out::println);
    };

    /*static class Ball{
        String color; // need to specify this field
        public Ball(String color) {
            this.color = color;
        }
    } // in this case it compares the values of memory */
    record Ball(String color){}
    

    
}
// very useful (impt)
class maps {
    maps() {
        Map<Integer, Person> map = new HashMap<>();
        map.put(1, new Person("Alex"));
        map.put(2, new Person("Alexia"));
        map.put(3, new Person("Maria"));
        System.out.println(map);
        System.out.println(map.size());
        System.out.println(map.get(1)); //retrieves the key 
        System.out.println(map.containsKey(4));
        System.out.println(map.keySet());
        System.out.println(map.entrySet());
        map.forEach((key,person) -> {
            System.out.println(key + " - " + person);
        });

        /* either that or  
        
        */
        map.entrySet().forEach(x ->System.out.println(x.getKey() + " - "
        + x.getValue()));
        
        // keys must be unique inside hashmap 

    }

    class Person {
        String name; // always remember this lmao this is the second time you forgot
        public Person(String name) {
            this.name = name;
        }
        /*@Override
        public String toString() {
            return "Person{" + 
            "name= " + name + '\'' + '}';
        }

        // need to override hash code if not each obj = receives new hash code
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name,person.name);

        }
        // override this code then youw ould return the same hash code whenever you add obj of same name
        @Override
        public int hashCode() {
            return Objects.hash(name);
        }*/
    };

}



class hashmap {
    hashmap() {
        Map<Person, Diamond> map = new HashMap();
        map.put(new Person("Jame"), new Diamond("Black Diamond"));
        System.out.println(new Person("Jame").hashCode());
        System.out.println(new Person("Jame").hashCode());
        System.out.println(map.get(new Person("Jame")));
    }

    class Person {
        String name; // always remember this lmao this is the second time you forgot
        public Person(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "Person{" + 
            "name= " + name + '\'' + '}';
        }

        // need to override hash code if not each obj = receives new hash code
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name,person.name);

        }
        // override this code then youw ould return the same hash code whenever you add obj of same name
        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
    record Diamond(String diamond){}

};  
