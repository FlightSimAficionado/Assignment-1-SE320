//*******************************************************
// Class: Exercise19_03
// Author: Hugh Seeley
// Date Created: 20241014
// Modified:20241015
//
// Attributes: None
//
// Methods: +Exercise19(): void - provided code, adds elements to an arraylist
//          -removeDuplicates(ArrayList<E> list): ArrayList<E> - places all elements into a hash set to remove duplicates, then places them back into the arraylist and returns it.
//
//********************************************************

import java.util.ArrayList;
import java.util.HashSet;


public class Exercise19_03 {
        public void Exercise19() {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(14);
            list.add(24);
            list.add(14);
            list.add(42);
            list.add(25);

            ArrayList<Integer> newList = removeDuplicates(list);

            System.out.print(newList);
        }
        public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){

            //creates hashSet with arraylist elements
            HashSet<E> intSet = new HashSet<>(list);

            //converts hashset into a new arraylist, randomized order
            ArrayList<E> listNoDup = new ArrayList<>(intSet); //could be simpler, but steps must be shown

            return listNoDup;
        }
    }