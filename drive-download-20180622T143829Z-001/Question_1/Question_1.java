import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
class Question_1
{
public static void main(String[] args) {

	String customerName="";
	ArrayList<String> data=new ArrayList<String>();
	//Read the Question_1_Template.txt as string by calling static method from another class ReadWrite
	String str=(ReadWrite.readFileAsString("Question_1_Template.txt"));


	try {
		//Read the Question_1_Data.txt line by line and put each coma seperated values in ArraList.
			File file = new File("Question_1_Data.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String line;
			//Read the one complete line
			while ((line = bufferedReader.readLine()) != null) {
				// Spliting the elements based on coma between them.
				String[] dataSet=line.split(",");
				for(String s:dataSet)
					//Adding the each String item to ArrayList
					data.add(s);
			}
			fileReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Converting ArrayList to String array for the ease of looping
	String[] dataSet=data.toArray(new String[0]);
	//loop entire dataSet and replace the fields with new values 
	//count starts from 3 because first 3 indexes conatince the headings which we dont want	
	int i=3;
	while(i<dataSet.length)
	{
		String newString=str;
		// taking customer name from the array  
		customerName=dataSet[i].substring(1,dataSet[i].length()-1);
		System.out.println("Writing into file for "+customerName);
		//replace "{CUSTOMER_NAME}" with the new customer name
		newString=newString.replace("{CUSTOMER_NAME}",customerName);
		i++;
		//replace "{CURRENT_LIMIT}" with the given value
		newString=newString.replace("{CURRENT_LIMIT}",dataSet[i].substring(1,dataSet[i].length()-1));
		i++;
		//replace "{NEW_LIMIT}"with the given value
		newString=newString.replace("{NEW_LIMIT}",dataSet[i].substring(1,dataSet[i].length()-1));
		i++;
		// calling static method with customer name as file name and string which is to be written to the file.
		ReadWrite.write(customerName+"'s file",newString);
		

    }
    System.out.println("All the files are written and the file names are customer names");
	
}

}
