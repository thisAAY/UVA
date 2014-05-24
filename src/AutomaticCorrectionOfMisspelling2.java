/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;
import java.io.*;

public class AutomaticCorrectionOfMisspelling2 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        Set<String> set = new HashSet<String>();
        String[] dict = new String[N];
        for (int i = 0; i < N; ++i) {
            dict[i] = in.readLine();
            set.add(dict[i]);
        }

        int Q = Integer.parseInt(in.readLine());
        while (Q-- > 0) {
            String query = in.readLine();

            if (set.contains(query)) {
                System.out.println(query + " is correct");
                continue;
            }

            String mispell = "";
            for (int i = 0; i < N && mispell.isEmpty(); ++i) {
                System.out.println(query + " - " + dict[i]);
                if (query.length() == dict[i].length() + 1) { // One letter too much?
                    for (int j = 1; j <= query.length(); ++j) {
                        String str = query.substring(0, j - 1) + query.substring(j);
                        System.out.println(str + " - " + dict[i] + " A");
                        if (str.equals(dict[i])) {
                            mispell = dict[i];
                            System.out.println("A " + mispell);
                            break;
                        }
                    }
                }
                if (query.length() + 1 == dict[i].length()) { // One letter missing?
                    for (int j = 1; j <= dict[i].length(); ++j) {
                        String str = dict[i].substring(0, j - 1) + dict[i].substring(j);
                        System.out.println(str + " - " + query + " B");
                        if (str.equals(query)) {
                            mispell = dict[i];
                            System.out.println("B " + mispell);
                            break;
                        }
                    }
                }
                if (query.length() == dict[i].length()) {
                    int cnt = 0;
                    for (int j = 0; j < query.length(); ++j) {
                        if (query.charAt(j) != dict[i].charAt(j)) {
                            ++cnt;
                        }
                    }
                    if (cnt == 1) {
                        mispell = dict[i];
                        System.out.println("C " + mispell);
                        break;
                    } else if (cnt == 2) {
                        for (int j = 1; j < query.length(); ++j) {
                            if (query.charAt(j - 1) != dict[i].charAt(j - 1)
                                    && query.charAt(j) != dict[i].charAt(j)
                                    && query.charAt(j - 1) == dict[i].charAt(j)
                                    && query.charAt(j) == dict[i].charAt(j - 1)) {
                                mispell = dict[i];
                                System.out.println("D" + mispell);
                                break;
                            }
                        }
                    }
                }
            }

            if (!mispell.isEmpty()) {
                System.out.println(query + " is a misspelling of " + mispell);
            } else {
                System.out.println(query + " is unknown");
            }
        }

        in.close();
        System.exit(0);
    }
}