package com.mesoft.bootstrapper.controllers;


import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;




/**
 * Created with IntelliJ IDEA. User: will Date: 11/23/13 Time: 12:37 PM
 */
@Controller
@RequestMapping("/")
public class HomeController {

	public static String url = "http://www.sporsimdi.com/mobile/turnstileRequest.jsf?request=";
	
	@Value("${gateNo}") private String gateNo;
	@Value("${gpio.pin}") private String pin;
	@Value("${gpip.sleep}") private String sleepTime;	
	
	
	
	static Logger logger = LoggerFactory.getLogger("com.mesoft.bootstrapper.controllers.HomeController");
    
	
	

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "/WEB-INF/views/angular-index.jsp";
	}

	@RequestMapping(value = "/access/{code}", method = RequestMethod.GET)
	public @ResponseBody
	String handleRequestInternal(@PathVariable String code, ModelMap model) {

		if (code.length() == 10) {
			code = "Q-RF-" + code+"-0"+gateNo;
		} else if (code.length() == 12) {
			code = "Q-QR-" + code+"-0"+gateNo;
		} else if (code.length() == 8) {
			code = "Q-PW-" + code+"-0"+gateNo;
		}

		HttpClient client = new HttpClient();

		// Create a method instance.
		GetMethod method = new GetMethod(url + code);

		System.err.println();
		
		
		logger.debug("Method url: " + url + code);


		
		// Provide custom retry handler is necessary
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler(3, false));

		try {
			// Execute the method.
			int statusCode = client.executeMethod(method);

			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: " + method.getStatusLine());
			}
			// Read the response body.
			byte[] responseBody = method.getResponseBody();

			// Deal with the response.
			// Use caution: ensure correct character encoding and is not binary
			// data
			
			logger.debug("Method Response Body: " + new String(responseBody));

			String response = new String(responseBody);
			
			
			JSONParser parser = new JSONParser();
			 
			JSONObject jsonObject = (JSONObject) parser.parse(response);
			
			String respCode = (String) jsonObject.get("resultCode");
			
//				Object obj = parser.parse(new FileReader("c:\\test.json"));
//		 
//				JSONObject jsonObject = (JSONObject) obj;
//		 
//				String name = (String) jsonObject.get("name");
//				System.out.println(name);
			

			if (respCode.equals("SUCCESS")) {
				logger.info("Kapi acildi");
				GpioAdapter adapter = new GpioAdapter();
				adapter.setSleepTime(Integer.valueOf(sleepTime));
				adapter.setPinNumber(Integer.valueOf(pin));
				adapter.start();
			} else {
			}
			return response;

		} catch (Exception e) {
			logger.error("Error while processing", e);
		} finally {
			// Release the connection.
			method.releaseConnection();
		}
		return "NOK";

	}

}
