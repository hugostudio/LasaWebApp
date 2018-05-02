package br.com.lasa.util;

import java.text.SimpleDateFormat;
import br.com.lasa.mvc.entity.Venda;

public final class Util {
	
	
	
	public static final String gerarNomeArq(Venda venda) {
		StringBuffer strBuff = new StringBuffer();
	
		SimpleDateFormat sdfr = new SimpleDateFormat("yyyyMMddHHmmss");
		String text = sdfr.format(venda.getData());
		strBuff.append(text);
		
		strBuff.append(" - ");
		strBuff.append(venda.getLoja());
		strBuff.append(" - ");
		strBuff.append(venda.getId());
		strBuff.append(".txt");
		return strBuff.toString();
	}
}
