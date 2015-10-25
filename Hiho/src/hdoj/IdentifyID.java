package hdoj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IdentifyID {
	public static Map<String, String> tables = new HashMap<>();

	public static void initTables() {
		tables.put("33", "Zhejiang");
		tables.put("11", "Bejing");
		tables.put("71", "Taiwan");
		tables.put("81", "Hong Kong");
		tables.put("82", "Macao");
		tables.put("54", "Tibet");
		tables.put("21", "Liaoning");
		tables.put("31", "Shanghai");
	}
	public static void analysis(String idStr) {
		String province = idStr.substring(0, 2);// 提取身份证的前两位
		String year = idStr.substring(6, 10);// 年
		String month=idStr.substring(10, 12);
		String day = idStr.substring(12, 14);
		System.out.println("He/She is from " + tables.get(province)
				+ ",and his/her birthday is on " + month + "," + day + ","
				+ year + " based on the table.");
	}

	public static void main(String[] args) {
		initTables();
		Scanner s = new Scanner(System.in);
		while(s.hasNextInt()){
			int n = s.nextInt();// 输入需要查询几个省份证号
			for (int i = 0; i < n; i++) {
				String id = s.next();
				analysis(id);
			}
		}
		
	}
}
