package hiho;

import java.util.Scanner;


public class Trie {
int num;
char c;
Trie[] next = new Trie[26];
//ArrayList<Trie> next = new ArrayList<Trie>();
//public static Trie init(){
//	return null;
//	}
public static void  main(String[] arg){
	
	Trie root = new Trie();

	Scanner s = new Scanner(System.in);
	int n = s.nextInt();
	for (int i = 0; i < n; i++) {
		char[] c = s.next().toCharArray();
		Trie pTrie = root;
			for (int j = 0; j < c.length; j++) {
				int k = c[j] -'a';
				if (pTrie.next[k] != null) {
					pTrie.next[k].num++;
				}
				else {
					Trie q = new Trie();
					q.c = c[j];
					q.num = 1;
//					for (int l = 0; l < 26; l++) {
//						q.next[l] = null;
//					}//默认就是为空
					pTrie.next[k] = q;
				}
				pTrie = pTrie.next[k];
			}
	}
	int m = s.nextInt();
	for (int i = 0; i < m; i++) {
		char[] c = s.next().toCharArray();
		boolean flag = false;
		Trie pTrie  = root;
		for (int j = 0; j < c.length; j++) {
			int k = c[j] -'a';
			if (pTrie.next[k] == null) {
				flag = true;
				break;
			}
			else {
				pTrie = pTrie.next[k];
			}
		}
		if (flag) {
			System.out.println("0");
		}
		else {
			System.out.println(pTrie.num);
		}
	}

}
}
