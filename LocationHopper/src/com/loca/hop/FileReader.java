package com.loca.hop;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {

	public List<String> getPlacesToHop(String filePath) {

		String fileName = filePath;
		List<String> list = new ArrayList<>();
		List<String> quotedPlacesList = new LinkedList<>();
		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

			list = br.lines().collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String place : list) {

			String p = "\"" + place + "\"";
			quotedPlacesList.add(p);
		}
		// String p = String.join("|", quotedPlacesList);

		/*for (int i = 0; i < list.size(); i++) {

			if (i == 0) {
				System.out.println("Place Of Stay: \n" + list.get(i));
			} else if (i == 1) {
				System.out.println("\n Places to Visit : \n" + i + "." + list.get(i));
			} else {
				System.out.println(i + "." + list.get(i));
			}
		}
*/
		return quotedPlacesList;
	}
}
