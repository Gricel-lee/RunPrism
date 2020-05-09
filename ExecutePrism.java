import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ExecutePrism {
	
	
	
	public static void execute(String prismCommand, String path, String[] specifications,String pathR) throws Exception {
		
		java.util.List<String> strList = Arrays.asList("How", "To", "Do", "In", "Java");
        
		
		
		System.out.println(Arrays.toString(specifications));
		
		//Select how to view results: a) Terminal  OR  b) Java console
		
		//String[] array1 = {"cmd","/c", "start", "cmd.exe" ,"/K", prismCommand, path }; // a) to execute in CMD/terminal and not in Java Console
    	String[] array1 = {"cmd.exe", "/c", prismCommand, path }; // b) to execute in Java Console
		String[] array2 = specifications;

    	//Join to create terminal command, e.g.: {"cmd","/c", "start", "cmd.exe" ,"/K", "prism", path , "-pctl" , "Rmin=? [F " + "state=5]" , "-exportadv" , "best-policy" , "-exportstates" , "states"};
		int aLen = array1.length;
        int bLen = array2.length;
        String[] resultCommand = new String[aLen + bLen];
        System.arraycopy(array1, 0, resultCommand, 0, aLen);
        System.arraycopy(array2, 0, resultCommand, aLen, bLen);
		
		
		//Run terminal line	
        ProcessBuilder builder = new ProcessBuilder(resultCommand);
        builder.redirectErrorStream(true);
        Process p = builder.start();
        
        //Write results in pathR
        BufferedWriter WriteToFile = new BufferedWriter(new FileWriter(pathR, true));
        
        //Read output into Java Console
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) { break; }
            System.out.println(line);
            WriteToFile.write(line); WriteToFile.newLine(); //write in pathR
        }
        
      //Close file
      WriteToFile.close();
    }
	
	
	
	    
	    
}