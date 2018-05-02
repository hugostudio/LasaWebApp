package br.com.lasa.batch.step;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.springframework.batch.item.file.FlatFileItemWriter;



public class MyWriter extends FlatFileItemWriter<String>  {

	private final BufferedWriter bw;
	
	public MyWriter() {
		FileWriter fw = null;
		try {
			File file = new File("lasadata.txt");
			if (!file.exists()) {file.createNewFile();}		
			fw = new FileWriter(file.getAbsoluteFile(), true);           
        } catch (IOException e) {
        	System.out.println( e.getMessage());
        }
		 bw = new BufferedWriter(fw);

    }
    
	public void write(List<? extends String> items) throws Exception {
            
		for (String txt : items) {
			bw.write(txt);
			bw.newLine();
			System.out.println("Writing the data " + txt);
		}
	} 		      

    public void close() {
    	try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}