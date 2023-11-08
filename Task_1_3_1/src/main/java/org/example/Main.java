package org.example;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = find("den.txt", "d");
        System.out.println(arr.toString());
    }
    public static ArrayList<Integer> find(String name, String substring) {
        ArrayList<Integer> res = new ArrayList<>();
        int lens = substring.length();
        try(FileReader reader = new FileReader(name)) {
            int c;
            int i = 0;
            if ((c = reader.read()) == -1) {
                res.add(-1);
                return res;
            }
            while(true){
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
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

        if (res.isEmpty()) {
            res.add(-1);
        }
        return res;
    }
}

