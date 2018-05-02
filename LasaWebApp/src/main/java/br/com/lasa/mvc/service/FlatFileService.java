package br.com.lasa.mvc.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class FlatFileService implements IFlatFileService{

	private static final String LASA_DIRETORIO="C:\\PROCESSADOS\\";
	private static final String LASA_NOMEARQ="LASA";
	private static final String LASA_EXTENSAO=".DAT";
	
	private String flatFileName= LASA_DIRETORIO + LASA_NOMEARQ + LASA_EXTENSAO;
	
	public String getFlatFileName() {		
		return flatFileName;
	}


	public void gerarNovoNomeArquivo(){
		SimpleDateFormat sdfDate = new SimpleDateFormat("-yyyyMMddHHmmss");
		String strDate = sdfDate.format(new Date());		
		flatFileName= LASA_DIRETORIO + LASA_NOMEARQ + strDate + LASA_EXTENSAO;
	}
	
	public BufferedWriter getflatFile() throws IOException{ 
		File file = new File(getFlatFileName());
		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
        return new BufferedWriter(fw);
	}
}
 