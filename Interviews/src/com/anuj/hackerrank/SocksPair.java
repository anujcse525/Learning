package com.anuj.hackerrank;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class SocksPair {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int pairs = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int co: ar){
            if(map.containsKey(co)){
                map.put(co, map.get(co) + 1);
            }
            else{
                map.put(co, 1);
            }
        }
        
        Iterator<Entry<Integer, Integer>> itr = map.entrySet().iterator();
        while(itr.hasNext()){
            Entry<Integer, Integer> ent = itr.next();
            pairs += ent.getValue()/2;
        }
        return pairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
