package leeCode;

public class ZigZagConvertion {
	public static String convert(String s, int numRows) {
        StringBuilder res = new StringBuilder();
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i=0;i<sb.length;i++)    sb[i] = new StringBuilder();
        int i=0;
        while(i<s.length()){
            for(int n=0;n<numRows&&i<s.length();n++) sb[n].append(s.charAt(i++));
            for(int n=0;n<numRows-2&&i<s.length();n++)    sb[numRows-2-n].append(s.charAt(i++));//-2ÊÇÈ¥Ê×Î²
        }
        for(StringBuilder b: sb)    res.append(b);
        return res.toString();
    }
	public static void main(String[] args){
		System.out.println(convert("PAYPALISHIRING", 3));
	}
}
