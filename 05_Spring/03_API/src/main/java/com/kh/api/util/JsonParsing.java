package com.kh.api.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParsing {

	public static void main(String[] args) {

		String serviceKey = "lp0JtzA6esvjXvJsJLm2eFxoeHDHTCCPBWThfJEoWX41euEw6Isy%2BmaGUMmWert0ndRgI%2FceHBWI9rA1WBidlg%3D%3D";
		String url = "https://apis.data.go.kr/6260000/FoodService/getFoodKr?serviceKey=" + serviceKey + "&pageNo=1&numOfRows=10&resultType=json";
		
		
		try {
			URL requestUrl = new URL(url);
			HttpURLConnection urlConnection = (HttpURLConnection) requestUrl.openConnection();
			urlConnection.setRequestMethod("GET");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			
			StringBuffer responseBuffer = new StringBuffer();
			String line = null;
			
			while((line = br.readLine())!=null) {
				responseBuffer.append(line);
			}
			br.close();
			urlConnection.disconnect();
			
			String responseData = responseBuffer.toString();
			
			
			JSONObject jsonResponse = new JSONObject(responseData);
			
			JSONObject jsonData = jsonResponse.getJSONObject("getFoodKr");
			System.out.println(jsonData);
			
			JSONArray items = jsonData.getJSONArray("item");
			
			for (int i=0; i< items.length(); i++) {
				JSONObject result = items.getJSONObject(i);
				System.out.println(result.getString("MAIN_TITLE"));
				System.out.println(result.getDouble("LNG"));
				System.out.println(result.getDouble("LAT"));
				System.out.println("------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
