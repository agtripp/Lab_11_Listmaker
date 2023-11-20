import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static Scanner in = new Scanner (System.in);
    public static ArrayList<String> myArrList = new ArrayList<>();
    public static void main(String[] args) {

        boolean done = false;
        String regEx = "^^[AaDdPpQq]$";
        String choice = "";
        do {
            choice = SafeInput.getRegExString(in, "Add an item to the list [a], delete an item from the list [d], view the list [p], or quit the program [q]?", regEx);
            if (choice.equalsIgnoreCase("A")) {
                add();
            }
            if (choice.equalsIgnoreCase("D")) {
                delete();
            }
            if (choice.equalsIgnoreCase("P")) {
                print();
            }
            if (choice.equalsIgnoreCase("Q")) {
                done = quit();
            }
        }while(!done);

    }
    public static void add() {
        myArrList.add(SafeInput.getNonZeroLenString(in, "What do you want to add to the list?"));

    }
    public static void delete() {
        if (myArrList.size() > 0) {
            for (int i = 0; i < myArrList.size(); i++) {
                System.out.println( (i+1) + ". " + myArrList.get(i));
            }
            myArrList.remove((SafeInput.getRangedInt(in, "What number item do you want to delete from the list?", 1, (myArrList.size()))-1));}
        else {
            System.out.println("There are no items to delete");
        }

    }
    public static void print() {
        for (int i = 0; i < myArrList.size(); i++) {
            System.out.println( (i+1) + ". " + myArrList.get(i));
        }

    }
    public static boolean quit() {
        return SafeInput.getYNConfirm(in, "Do you want to quit?");
    }
}