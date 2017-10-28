package rpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RpcHelper {
	   // Writes a JSONObject to http response.
		public static void writeJsonObject(HttpServletResponse response, JSONObject obj) {
			try {
				response.setContentType("application/json");
				response.addHeader("Access-Control-Allow-Origin", "*");
				PrintWriter out = response.getWriter();
				out.print(obj);
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		// Writes a JSONArray to http response.
		public static void writeJsonArray(HttpServletResponse response, JSONArray array) {
			try {
				response.setContentType("application/json");
				response.addHeader("Access-Control-Allow-Origin", "*");
				PrintWriter out = response.getWriter();
				out.print(array);
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		// Parses a JSONObject from http request.
		public static JSONObject readJsonObject(HttpServletRequest request) {
			StringBuffer sb = new StringBuffer();
			String line = null;
			BufferedReader reader = null;
			try {
				reader = request.getReader();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				reader.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JSONObject input = null;
			try {
				input = new JSONObject(sb.toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return input;

		}


}
