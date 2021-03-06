package com.anuj.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FrequencyQueries {

	static List<Integer> freqQuery(List<int[]> queries) {
		List<Integer> result = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Iterator<int[]> itr = queries.iterator();
		while (itr.hasNext()) {
			int[] queryEntry = itr.next();

			if (queryEntry != null && queryEntry.length > 1) {
				int query = queryEntry[0];
				int item = queryEntry[1];
				if (query == 1) {
					if (map.containsKey(item)) {
						map.put(item, map.get(item) + 1);
					} else {
						map.put(item, 1);
					}
				} else if (query == 2) {
					if (map.containsKey(item)) {
						map.put(item, map.get(item) - 1);
					}
				} else if (query == 3) {
					if (map.containsValue(item)) {
						result.add(1);
					} else {
						result.add(0);
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numQueries = Integer.parseInt(br.readLine().trim());
		List<List<Integer>> inputs = new ArrayList<>();
		IntStream.range(0, numQueries).forEach(i -> {
			try {
				inputs.add(Stream.of(br.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
						.collect(Collectors.toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});
		List<Integer> result = freqQuery(inputs);
		System.out.println(Arrays.toString(result.toArray()));
		br.close();*/
		 try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
		      int q = Integer.parseInt(bufferedReader.readLine().trim());
		      List<int[]> queries = new ArrayList<>(q);
		      Pattern p  = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
		      for (int i = 0; i < q; i++) {
		        int[] query = new int[2];
		        Matcher m = p.matcher(bufferedReader.readLine());
		        if (m.matches()) {
		          query[0] = Integer.parseInt(m.group(1));
		          query[1] = Integer.parseInt(m.group(2));
		          queries.add(query);
		        }
		      }
		      List<Integer> ans = freqQuery(queries);
		      /*try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {
		        bufferedWriter.write(
		                ans.stream()
		                        .map(Object::toString)
		                        .collect(Collectors.joining("\n"))
		                        + "\n");
		      }*/
		    }
	}

}
