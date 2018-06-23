import java.util.*;
class Question_2
{

public static void main(String[] args) {
	//read the text from the file Question_2_Sample_Text.txt.
String str=ReadWrite.readFileAsString("Question_2_Sample_Text.txt");
//REmove the non charecters and space from the text i.e removing numbers, special charecters etc
str=str.replaceAll("[^a-zA-Z\\s]", "");
//put each word into array
String[] words=str.split(" ");
Map<String,Integer> map=new HashMap<String,Integer>();
	for(String a:words)
	{
		if(map.containsKey(a))
		{//if the word is alredy present in the map then increment its count.
			int q=(int)map.get(a);
			q++;
			map.put(a,q);
			
		}
		else
		{//if the word is not present in the map the add the word to th map with count 1
			map.put(a,1);
		}
	}
	
	System.out.println("Word\t"+"Frequency");
	for(int t=0;t<3;t++)
	{
		//find the maximum value currently present in the map
		int max=(Collections.max(map.values()));
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
    String key = it.next();
    if(map.get(key)==max)
    {//if the value matches to the maximum value the print the key and value and the delete the particular entry
    		System.out.println(key+"\t"+map.get(key));
			it.remove();

    }
}


}
	

}

}