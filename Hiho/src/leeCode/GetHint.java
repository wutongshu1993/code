package leeCode;

import java.util.Arrays;
/**
 * �����ݣ����guess��secret���ֺ�λ�ö��ԣ�count++��guess����num�����ֺ�secret����ͬ
 * @author lh
 *
 */
public class GetHint {
public String getHint(String secret, String guess) {
	char[] cs = secret.toCharArray();
	char[] cg = guess.toCharArray();
	int count = 0;
	int num = 0;
	for (int i = 0; i < cg.length; i++) {
		if (cs[i]==cg[i]) {
			count++;
		}
	}
	Arrays.sort(cs);
	Arrays.sort(cg);
	int posx=0;
	int posy= 0;
	while(posx<cs.length&&posy<cs.length){
		if (cs[posx] == cg[posy]) {
			posx++;
			posy++;
			num++;
		}
		else if(cs[posx]<cg[posy]){
			posx++;
		}
		else if (cs[posx]>cg[posy]) {
			posy++;
		}
	}
	
	return count+"A"+(num-count)+"B";
}

//��һ�ֽϺõĽⷨ����sarr[1]��¼secret��1�ĸ�����garr[1]��¼guess��1�ĸ�����cow=min(sarr[i],garr[i]);
/*for (int i = 0; i < len; ++i) {
    if (secret.charAt(i) == guess.charAt(i)) {
        ++bull;
    } else {
        ++secretarr[secret.charAt(i) - '0'];
        ++guessarr[guess.charAt(i) - '0'];
    }
}
for (int i = 0; i < 10; ++i) {
    cow += Math.min(secretarr[i], guessarr[i]);
}*/
}
