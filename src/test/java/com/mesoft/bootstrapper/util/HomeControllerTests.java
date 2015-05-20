package com.mesoft.bootstrapper.util;

import static org.junit.Assert.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import com.mesoft.bootstrapper.controllers.HomeController;

public class HomeControllerTests {

//	@Test
//	public void shouldNotPassQrCode() {
//		String respCode = callService("123456789123");
//		assertEquals("Qr Entered", "FAIL", respCode);
//	}
//	
//	@Test
//	public void shouldPassQrCode() {
//		String respCode = callService("MKZYyt99vHU=");
//		assertEquals("Qr Entered", "SUCCESS", respCode);
//	}
//
//	@Test
//	public void shouldPassRfCode() {
//		String respCode = callService("0630235152");
//		assertEquals("Qr Entered", "SUCCESS", respCode);
//	}
//	
//	@Test
//	public void shouldNotPassRfCode() {
//		String respCode = callService("0630235151");
//		assertEquals("Qr Entered", "FAIL", respCode);
//	}
//	
//	
//	@Test
//	public void shouldPassPwCode() {
//		String respCode = callService("11035111");
//		assertEquals("Qr Entered", "SUCCESS", respCode);
//	}
//	
//	@Test
//	public void shouldNotPassPwCode() {
//		String respCode = callService("11035112");
//		assertEquals("Qr Entered", "FAIL", respCode);
//	}
//	
//	
//	
//	private String callService(String code) {
//		HomeController tester = new HomeController();
//		String response = tester.handleRequestInternal(code, null);
//		JSONParser parser = new JSONParser();
//
//		JSONObject jsonObject;
//		try {
//			jsonObject = (JSONObject) parser.parse(response);
//			String respCode = (String) jsonObject.get("resultCode");
//			return respCode;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return response;
//	}
}
