package org.example;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Main class with method find.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = find("den.txt", "d");
        System.out.println(arr.toString());
    }

    /**
     * Method for finding all occurrences of a substring in a file.
     *
     * @param name File name.
     * @param substring The substring that is being searched.
     * @return An array with indexes of the occurrence of the substring.
     */
    public static ArrayList<Integer> find(String name, String substring) {
        ArrayList<Integer> res = new ArrayList<>();
        int lens = substring.length();

        try (FileReader reader = new FileReader(name)) {
            int c;
            int i = 0;
            if ((c = reader.read()) == -1) {
                res.add(-1);
                return res;
            }

            while (true) {
                if (c == substring.codePointAt(0)) {
                    boolean isEnd = false;
                    boolean isSubString = true;
                    for (int j = 1; j < lens; j++) {
                        if ((c = reader.read()) != -1) {
                            if (c != substring.codePointAt(j)) {
                                isSubString = false;
                            }
                            i++;
                        } else {
                            isEnd = true;
                            break;
                        }
                    }
                    if (isEnd) {
                        break;
                    }
                    if (isSubString) {
                        res.add(i - lens + 1);
                    } else {
                        continue;
                    }
                }
                i++;
                if ((c = reader.read()) == -1) {
                    if (res.isEmpty()) {
                        res.add(-1);
                    }
                    return res;
                }
            }
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

        if (res.isEmpty()) {
            res.add(-1);
        }
        return res;
    }
}

