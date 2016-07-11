import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringTokenizer;
import java.util.*;
import java.util.stream.*;

public class Assignment2 {

    private static HashMap<String,Double> h = new HashMap<String,Double>();

    public static void main(String[] args) throws IOException{       
        reader(args[0]);
	useForEach();
    }
     
    public static void reader(String filepath) {
    	try {
		BufferedReader br = new BufferedReader(new FileReader(new File(filepath)));
		String line ="";
		while((line = br.readLine()) != null){
			String[] words = line.split("    ");
			for(String str : words)
			{
			    try{
				String[] word = line.split("    ");
				double num = Integer.parseInt(str);
				String[] w = line.split("    ");	//to get the num, value pair

				if(h.containsKey(w[0]) == true)
				{
					double val = h.get(w[0]);	//get existing value of key
					val += num;
					h.put(w[0],val);	//update key->value
				}
				else
					h.put(w[0],num);				
			    }catch(NumberFormatException e) { };  //word is not an integer, do nothing*/
			}
		}
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
    public static void useForEach(){
	for (String pair : h.keySet())
	{
		System.out.println(pair + "  " + h.get(pair));
	}
    }
}
