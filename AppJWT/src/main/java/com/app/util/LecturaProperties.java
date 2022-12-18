package com.app.util;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class LecturaProperties {	

	@SuppressWarnings("rawtypes")
	public static Map<String, String> getLecturaProperties() {
		Map<String,String> properties = new HashMap<String,String>();
		try {
			String path = Paths.get(Constantes.pathProperties).toAbsolutePath().toString();
			File f = new File(path+"/conf.properties");
			if (f.exists() && f.canRead()) {
				try {
					Properties p = new Properties();
					FileInputStream ins = new FileInputStream(f);
					p.load(ins);
					for (Enumeration e = p.keys(); e.hasMoreElements() ; ) {
					    // Obtenemos el objeto
					    Object obj = e.nextElement();
					    properties.put(obj.toString() , p.getProperty(obj.toString()));
					}										
				} catch (Exception e) {
					System.out.println("No funciono..." + e.getMessage());
				}
			}
			
		} catch (Exception e) {
			System.out.println("Error al cargar archivo Conexion.properties");
		}
		return properties;
	}
}
