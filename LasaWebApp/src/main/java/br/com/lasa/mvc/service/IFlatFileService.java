package br.com.lasa.mvc.service;

import java.io.BufferedWriter;
import java.io.IOException;

public interface IFlatFileService {
	public String getFlatFileName();
	public void gerarNovoNomeArquivo();
	public BufferedWriter getflatFile() throws IOException;
}
