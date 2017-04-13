package gitlabapis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class Groups {
	static String Gitlab_Url = "http://gitlab.test.com";
	static String Gitlab_Token = "gitlab-private-key";

	public static int search_group(String group_name) {
		String request_URL = Gitlab_Url + "/api/v3/groups?search=" + group_name + "&private_token=" + Gitlab_Token;
		String result = "";
		BufferedReader in = null;

		try {
			URL realUrl = new URL(request_URL);
			URLConnection connection = realUrl.openConnection();
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible;MSIE 6.0; Windows NT 5.1;SV1)");
			connection.connect();
			Map<String, List<String>> map = connection.getHeaderFields();

			for (String key : map.keySet()) {
				System.out.println("----test---");
				System.out.println(key + "--->" + map.get(key));
				System.out.println(key + "--->" + map.get(key));
			}

			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			System.out.println("====result=====");
			System.out.println(result);

		} catch (Exception e) {
			System.out.println("发送get请求出现异常" + e);
			e.printStackTrace();
		}

		return 1;
	}

	public static void main(String[] args) {

		search_group("wangleiaf_group");
	}

}

