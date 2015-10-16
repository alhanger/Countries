import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Countries {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Country>> listOfCountries = new HashMap<>();

        String countriesContent = readFile("countries.txt");
        String[] lines = countriesContent.split("\n"); //puts each line of text into an array

        for (String line : lines) {
            String[] columns = line.split("\\|"); //splits abbreviations and names and stores them in an array for each country

            String abrv = columns[0];
            String countryName = columns[1];
            Country country = new Country(countryName, abrv); //creates new Country object for each country
            String countryLetter = String.valueOf(country.name.charAt(0)); //stores first letter of a country

            ArrayList<Country> list = listOfCountries.get(countryLetter); //uses countryLetter as the key to return ArrayList of countries
            if (list == null) { //create a list by the first letter of the country
                list = new ArrayList<>();
                list.add(country);
                listOfCountries.put(countryLetter, list);
            }
            else { //adds the country to the list
                list.add(country);
            }
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a letter to return all countries that start with that letter");
        String entry = scanner.nextLine().toLowerCase();
        String output = "";

        if (listOfCountries.containsKey(entry)) { //searches for countries in the hashmap using the user input as the key
            for (Country place : listOfCountries.get(entry)) { //loops over all countries that start with user input
                output += (String.format("%s %s\n", place.abbrev, place.name)); //returns the search results and stores it in output
            }
        }
        writeFile(String.format("%s_countries.txt", entry), output); //saves results to a file and names the file by the user input
    }

    static String readFile(String fileName) {
        File f = new File(fileName);
        try {
            FileReader fr = new FileReader(f);
            int fileSize = (int) f.length();
            char[] fileContent = new char[fileSize];
            fr.read(fileContent);
            return new String(fileContent);
        } catch (Exception e) {
            return null;
        }
    }

    static void writeFile(String fileName, String fileContent) {
        File f = new File(fileName);
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(fileContent);
            fw.close();
        } catch (Exception e) {

        }
    }
}
