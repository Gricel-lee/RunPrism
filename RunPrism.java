import java.io.IOException;



public class RunPrism {
	// Run cmd instructions 
	
	public static void main(String[] args) {
		
		// Run Prism from Java.
		
		//*** INPUTS ***//
		// a) Specifications-	Write the specifications as a vector as in the example: { "-pctl" , "Rmin=? [F " + "state=5]" , "-exportadv" , "best-policy" , "-exportstates" , "states"}
		// b) Path to model-	Select the file and write the absolute path as: "C:\\Users\\gris\\Desktop\\model.pm"
		// c) Prism environmental variable-	The "prismCommand" value must coincide with the environmental variable register in your PC to run Prism in CMD, usually "prism"
		// d) Results-	Specify Path and Filename to write the results, e.g.: "C:\\Users\\gris\\Desktop\\results1.txt"
		//**************//
		
		// a) Specifications:
		 String[] specifications = { "-pctl" , "Rmin=? [F " + "state=5]" , "-exportadv" , "best-policy" , "-exportstates" , "states"};
		// b) Path to model
		String path = "C:\\Users\\grist\\Desktop\\model.pm";
		// c) Prism environmental variable
		String prismCommand = "prism";  //this is the environmental variable register in your pc to run Prism in CMD, usually "prism"
		// d) Results
		String pathR = "C:\\Users\\grist\\Desktop\\results1.txt";
		
		// Run in cmd 
		try {
			// Execute Prism
			ExecutePrism.execute(prismCommand,path,specifications,pathR);
		} catch (Exception e) {
			// error catch
			e.printStackTrace();
		}
	}
	
}



