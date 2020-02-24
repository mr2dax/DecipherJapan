package com.bai.discoverjapan.morphology;

import java.util.ArrayList;
import java.util.Arrays;

/* grand array of all the possible basic tenses of an adjective/noun
 * - plain or polite
 * - positive or negative
 * - all tenses
 */
public class AdjectiveNoun {
	final String[] tenses = {"plain,+,present indicative","plain,-,present indicative","polite,+,present indicative","polite,-,present indicative",
							"plain,+,past indicative","plain,-,past indicative","polite,+,past indicative","polite,-,past indicative",
							"plain,+,provisional","plain,-,provisional",
							"plain,+,conditional","plain,-,conditional"
							
							// dictionary form
							//"plain,present,can-do", "polite,present,can-do","plain,past,can-do", "polite,past,can-do","plain,present,can't-do", "polite,present,can't-do","plain,past,can't-do", "polite,past,can't-do",
							//"order", "plain,must not", "polite, must not","before doing",
							
							// universal plain form
							//"plain, explanation", "polite, explanation", "explanation to a request", "hearsay", "interrogative", "whether", "about to just start;now doing;have just finished",
							//"plain,looks like", "plain,doesn't look like", "polite,looks like", "polite,doesn't look like"
							};
	// constructor
	public AdjectiveNoun () {
		
	}
	
	/* main function, decides which method to call depending in the adjective's secondary grammatical type
	 * attributes:
	 * - the secondary type of the adjective
	 * - the dictionary form of the adjective
	 * returns:
	 * - all the possible variations of the adjective in a custom arraylist
	 */
	public ArrayList<com.bai.discoverjapan.morphology.Variation> variations (String wordType, String dictForm) {
		String type = wordType;
		String dict = dictForm;
		// special arraylist for sending back the data
		ArrayList<com.bai.discoverjapan.morphology.Variation> variations;
	
		if (type.matches("adj-i")) {
		//i-adjectives
			variations = iAdj(dict);
		} else if(type.matches("adj-na") || type.matches("adj-no") || type.matches("n")) {
		// na-adjectives and nouns
			variations = naAdjNoun(dict);
		} else {
		// misc cases
			variations = misc(type,dict);
		}
		return variations;
	}

	private ArrayList<com.bai.discoverjapan.morphology.Variation> misc(String verb, String type) {
		// TODO if time is left
		return null;
	}
	
	// i-adjectives
	private ArrayList<com.bai.discoverjapan.morphology.Variation> iAdj(String dict) {
		String dictForm = dict;
		String stem = dictForm.substring(0, dictForm.length()-1);
		ArrayList<Variation> result = new ArrayList<Variation>(Arrays.asList(
				new Variation(stem+"��",tenses[1]),
				new Variation(stem+"���Ȃ�",tenses[2]),
				new Variation(stem+"���ł�",tenses[3]),
				new Variation(stem+"���Ȃ��ł�",tenses[4]),
				new Variation(stem+"������",tenses[5]),
				new Variation(stem+"�Ȃ�����",tenses[6]),
				new Variation(stem+"�������ł�",tenses[7]),
				new Variation(stem+"���Ȃ������ł�",tenses[8]),
				new Variation(stem+"�����",tenses[9]),
				new Variation(stem+"�Ȃ����",tenses[10]),
				new Variation(stem+"��������",tenses[11]),
				new Variation(stem+"�Ȃ�������",tenses[12]),
				new Variation(stem+"����",tenses[13]),
				new Variation(stem,tenses[14])
				));
				return result;
	}

	// na-adjectives and nouns
	private ArrayList<com.bai.discoverjapan.morphology.Variation> naAdjNoun(String dict) {
		String dictForm = dict;
		String stem = dictForm;
		ArrayList<Variation> result = new ArrayList<Variation>(Arrays.asList(
				new Variation(stem+"��",tenses[1]),
				new Variation(stem+"����Ȃ�",tenses[2]),
				new Variation(stem+"���Ⴀ��܂���",tenses[2]),
				new Variation(stem+"�ł�",tenses[3]),
				new Variation(stem+"�ł͂Ȃ�",tenses[4]),
				new Variation(stem+"�ł͂���܂���",tenses[4]),
				new Variation(stem+"������",tenses[5]),
				new Variation(stem+"����Ȃ�����",tenses[6]),
				new Variation(stem+"���Ⴀ��܂���ł���",tenses[6]),
				new Variation(stem+"�ł���",tenses[7]),
				new Variation(stem+"�ł͂���܂�ł���",tenses[8]),
				new Variation(stem+"�ł͂Ȃ�����",tenses[8]),
				new Variation(stem+"�Ȃ�",tenses[9]),
				new Variation(stem+"�Ȃ��",tenses[9]),
				new Variation(stem+"�ł����",tenses[9]),
				new Variation(stem+"����Ȃ����",tenses[10]),
				new Variation(stem+"�łȂ����",tenses[10]),
				new Variation(stem+"�łȂ��Ȃ�",tenses[10]),
				new Variation(stem+"��������",tenses[11]),
				new Variation(stem+"����Ȃ�������",tenses[12]),
				new Variation(stem+"��",tenses[13]),
				new Variation(stem,tenses[14])
				));
		return result;
	}
}