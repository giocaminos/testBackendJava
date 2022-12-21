package com.app.view.rest;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.entity.Log;
import com.app.model.service.ConexionAPIService;
import com.app.model.service.ILogService;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/API")
public class ViewRest {

	private Logger logger = Logger.getLogger(ViewRest.class.toString());

	@Autowired
	private ILogService service;

	@GetMapping(value = "/public/timezome")
	public String TImeZONE(@RequestParam String country, @RequestParam String date) throws IOException {
		System.out.println("date: " + date + " country: " + country);

		ConexionAPIService con = new ConexionAPIService(date, country);
		String r = con.conexionAPI_TIMEZONE();
		JSONObject json_transform = null;
		try {
			json_transform = new JSONObject(r);
            
	        json_transform = (JSONObject) json_transform.get("data");
	        
	        json_transform = (JSONObject) json_transform.get("timezone");
	        Log log = new Log();
			log.setValor(json_transform.toString());
			service.save(log);
		} catch (Exception e) {
			return null;
		}		
		return r;
	}

	@GetMapping(value = "/public/log")
	public List<Log> log() throws IOException {
		return service.findAll();
	}

}
