//*******************************************************
// Class: TaskOne
// Author: Hugh Seeley
// Date Created: 20241029
// Modified:20241029
//
// Attributes: None
//
// Methods: +createHashSets(): void - creates the sets, then calls the methods for finding the Union, Difference, and Intersection
//          -findUnion(): String - Clones set and finds union
//          -findDifference(): String - Clones set and removes all elements of set 2
//          -findIntersection(): String - Clones set and finds duplicates
//
//********************************************************

import java.util.LinkedHashSet;
import java.util.Set;

public class TaskOne {
    public void createHashSets() {
        Set<String> lhs1 = new LinkedHashSet<>();
        Set<String> lhs2 = new LinkedHashSet<>();

        lhs1.add("George");
        lhs1.add("Jim");
        lhs1.add("John");
        lhs1.add("Blake");
        lhs1.add("Kevin");
        lhs1.add("Michael");

        lhs2.add("George");
        lhs2.add("Katie");
        lhs2.add("Kevin");
        lhs2.add("Michelle");
        lhs2.add("Ryan");

        System.out.println("Set One: " + lhs1); //Printing initial sets
        System.out.println("Set Two: " + lhs2);

        System.out.println("Union: " + findUnion(lhs1, lhs2));
        System.out.println("Difference: " + findDifference(lhs1, lhs2));
        System.out.println("Intersection: " + findIntersection(lhs1, lhs2));
    }

    private Set<String> findUnion(Set<String> set1, Set<String> set2) {
        Set<String> union = new LinkedHashSet<>(set1); // clone set1
        union.addAll(set2); // add all elements of set2
        return union;
    }

    private Set<String> findDifference(Set<String> set1, Set<String> set2) {
        Set<String> difference = new LinkedHashSet<>(set1); // clone set1
        difference.removeAll(set2); // remove all elements of set2
        return difference;
    }

    private Set<String> findIntersection(Set<String> set1, Set<String> set2) {
        Set<String> intersection = new LinkedHashSet<>(set1); // clone set1
        intersection.retainAll(set2); // retain only elements also in set2
        return intersection;
    }
}
