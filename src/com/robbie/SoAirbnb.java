package com.robbie;

import java.io.*;
import java.util.*;

/*
  Often, we want to encode raw IDs in our database by hiding them behind some 2-way decodeable hash.
  So, a URL which would have at one time been: https://www.airbnb.com/rooms/848662 becomes https://www.airbnb.com/rooms/nJKeY
  We decode the ID 'nJKeY' to 848662 on our backend and serve the relevant content.
  At some point, we start getting 404 errors from clients requesting a certain URL of the form
  https://www.airbnb.com/rooms/njkey
  This can happen if certain clients, email services, or url shorteners “sanitize” the url by converting it to lowercase. Unfortunately, this change breaks decoding and the resource cannot be found.
  To assess how big of a deal this is, we may want to recover the IDs of the targets that were 404ing.
  We give you a method decode(testEncStr) which will return the decoded int id if testEncStr is decodeable or -1 if it is not, please test every capitalization combination of the input string and return the number it decodes to, or -1 if there are none that match.
*/
class SoAirbnb {
    public static void main(String[] args) {
        System.out.println("Decoded to id: " + decodeFind("njkey"));
    }

    // you implement this
    public static int decodeFind(String badEncStr) {
        if (badEncStr == null || badEncStr.length() == 0)
            return -1;
        int length = badEncStr.length();
        List<Character> dicts = new ArrayList<Character>();
        for (int i = 0; i < length; i++) {
            dicts.add(badEncStr.charAt(i));
        }
        System.out.println(dicts);
        return find(dicts, "", 0, length); // TODO
    }

    public static int find(List<Character> dicts, String str, int index, int target) {
        if (target == index) {
            System.out.println(str);
            return decode(str);
        }
        String next = str + dicts.get(index);
        int result = find(dicts, next, index + 1, target);
        if (result > 0)
            return result;
        else {
            next = str + convert(dicts.get(index));
            return find(dicts, next, index + 1, target);
        }
    }

    private static char convert(char c) {
        if (c >= 'a' && c <= 'z') {
            return (char)(c + ('A' - 'a'));
        } else {
            return (char)(c + ('a' - 'A'));
        }
    }

    /** return an int if testEncStr is a valid capitalization, else return -1 */
    private static int decode(String testEncStr) {
        System.out.println("Testing " + testEncStr);
        if (testEncStr.equals("nJKeY")) {
            return 848662;
        } else {
            return -1;
        }
    }
}
