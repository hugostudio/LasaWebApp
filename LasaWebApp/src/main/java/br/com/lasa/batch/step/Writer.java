package br.com.lasa.batch.step;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.springframework.batch.item.ItemWriter;

import br.com.lasa.mvc.service.IFlatFileService;

public class Writer implements ItemWriter<String> {
	private IFlatFileService flatFileService;
	
	public Writer(IFlatFileService flatFileService) {
		this.flatFileService = flatFileService;	
	}
	
	@Override
	public void write(List<? extends String> messages) throws Exception {
		try {
			
			File file = new File(flatFileService.getFlatFileName());

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);

            BufferedWriter bw = new BufferedWriter(fw);
            
    		for (String txt : messages) {
    			bw.write(txt);
    			bw.newLine();
    			System.out.println(">> " + txt);
    		}
    		      
            bw.close();

        } catch (IOException e) {
        	System.out.println( e.getMessage());
        }
		
	}

}