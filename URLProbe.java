import java.net.*;
import java.io.*;
import java.util.*;

public class URLProbe
{
    public static void main(String[] args) throws Exception {

	BufferedReader input = new BufferedReader(System.in);
	System.out.println("Enter the URL to search for alphanumeric permutations, with the area to search delimitted by '|'. Example: http://www.searchformykey.com/key=|&someotherbullshit-hi"); 
	String url = input.readLine();
	System.out.println("Okay, now input number of characters per key...");
	int charLimit = Integer.parseInt(input.readLine());
	System.out.println("What should I be looking for in the pages to affirm success? Example: if a page is valid it should contain the substring 'HI_MOM'");
	String success = input.readLine();
	System.out.println("Finally, tell me how many permutations do you want me to generate and attempt?");
	int numTimes = Integer.parseInt(input.readLine());

	System.out.println("Okay, let's go.");
	String[] searchURL = url.split("|");
	DataInputStream in = new DataInputStream(System.in);	
	HashMap<String,String> tried = new HashMap<String,String>();
	Random generator = new Random();

	System.out.println("Okay, LFG.");
	
	trying: for(int i = 0; i < numTimes; i++)
	{
		//generate the string
		attemptMe = "";
		for(int j = 0; j < charLimit; j++)
			if(generator.nextBoolean())
				attemptMe+= ""+(char)(generator.nextInt(26)+'a');
			else
				attemptMe+= ""+(char)(generator.nextInt(9)+'0');

		if tried.containsKey(attemptMe)
			continue trying;
		try
		{
			attemptedURL = new URL(searchURL[0]+attemptMe+searchURL[1]);
			BufferedReader in = new BufferedReader(new InputStreamReader(attemptedURL.openStream()));
			while((trace = in.readLine()) != null)
			{
				#its a hit!
				if(trace.contains(success) 
				{
					tried.add(attemptMe,"");
					System.out.println("Key found! Navigate to here: "+ searchURL[0]+attemptMe+searchURL[1]);
					continue trying;
				}
		}		
		catch (Exception E)	
		{
			System.out.println("Something is wrong: "+E);
			return;
		}
	}
	in.close();
    }
}
