package leeCode;


/**
 * Given "egg", "add", return true.
Given "foo", "bar", return false.
Given "paper", "title", return true.
 * @author lh
 *2016.3.10
 */
public class IsIsomorphic {
	//�뷨����s��t��ͬλ�õ���ĸ�ŵ�map����ȥ���ٽ�map����list�У����Ƚ�map��key��ͬ��ֵvalue�Ƿ���ͬ
	//�Ƚϵ�ʱ����o(n*n)ʱ�䳬ʱ��
//public boolean isIsomorphic(String s, String t){
//	char[] cs = s.toCharArray();
//	char[] ct = t.toCharArray();
//	List<Map<Character, Character>> list = new ArrayList<>();
//	for(int i=0;i<cs.length;i++){
//		Map<Character, Character> ms = new HashMap<>();
//		ms.put(cs[i], ct[i]);
//		list.add(ms);
//	}
//	for(int i=0;i<list.size();i++){
//		Map<Character, Character> mi = list.get(i);
//		Set<Character> sm = mi.keySet();
//		for(int j=i+1;j<list.size();j++){
//			Map<Character, Character> mj = list.get(j);
//			Set<Character> st = mj.keySet();
//			if (mi.equals(mj) && !sm.equals(st)) {
//				return false;
//			}
//			if (!mi.equals(mj) && sm.equals(st)) {
//				return false;
//			}
//			
//		}
//	}
//	return true;
//}
	//���е�һ�ְ취
	public boolean isIsomorphic(String s, String t){
		int count=0;
		char[] cs = s.toCharArray();
		char[] ct = t.toCharArray();
		int[] arrS = new int[256];
		int[] arrT = new int[256];
		int posS,posT;
		for(int i=0;i<s.length();i++){
			posS = cs[i];//ת��ΪascII��
			posT = ct[i];
			if(arrS[posS] != arrT[posT]) return false;
			else {
				arrS[posS] = arrT[posT] = count++;
			}
		}
		return false;
	}
public static void main(String[] args){
	String s = "abb";
	String t = "egd";
	System.out.println(new IsIsomorphic().isIsomorphic(s, t));
}
}
