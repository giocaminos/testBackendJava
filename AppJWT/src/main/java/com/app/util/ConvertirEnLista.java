package com.app.util;

import java.util.ArrayList;
import java.util.List;

public class ConvertirEnLista {

	
	public static List<String> getListaAuthority(String param) {
		String[] array = param.split(",", -1);			
		List<String> lista = new ArrayList<>();

		for(int i=0;i<array.length ; i++)
		{		
			lista.add(array[i]);
		}
		return lista;
	}
}
