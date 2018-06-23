import java.io.FileReader;
import java.io.IOException; 
import java.nio.file.Files; 
import java.nio.file.Paths;
import java.io.*;
class ReadWrite
{//read the file and return the contents as string 
	public static String readFileAsString(String fileName) {
    String text = "";
    try {
      text = new String(Files.readAllBytes(Paths.get(fileName)));
    } catch (IOException e) {
    	System.out.println("Error reading file");
      e.printStackTrace();
    }

    return text;
  }


 public static void write(String fileName,String string) {
//create file with the given fileName and write the given String
        try {
            File newTextFile = new File(fileName);

            FileWriter fw = new FileWriter(newTextFile);
            fw.write(string);
            fw.close();

        } catch (IOException iox) {
            System.out.println("Error writing file");
            iox.printStackTrace();
        }
    }
}



