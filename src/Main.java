import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

	public static void main(String[] args) {

		final String uri = "http://localhost/demo/sample/json";
		String resquestBody = "{\"id\":1, \"foo\":\"baa\"}";

		System.out.println("URL: " + uri);
		System.out.println("RequestBody: " + resquestBody);

		try {

			URL url = new URL(uri);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);

			OutputStreamWriter output = new OutputStreamWriter(conn.getOutputStream());
			output.write(resquestBody.toString());
			output.flush();

			Object[] param = new Object[2];
			param[0] = conn.getResponseCode();
			param[1] = conn.getResponseMessage();
			System.out.printf("Status: %s - %s\n", param);

			InputStreamReader input = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(input);
			String line = null;
			StringBuilder responseBody = new StringBuilder();
			responseBody.append("responseBody:\n");
			while ((line = br.readLine()) != null) {
				responseBody.append("\t" + line + "\n");
			}
			conn.disconnect();
			
			System.out.println(responseBody);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
