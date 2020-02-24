package com.bai.discoverjapan.morphology;

import java.util.ArrayList;
import java.util.Arrays;

/* grand array of all the possible basic tenses of a verb
 * - plain or polite
 * - positive or negative
 * - all tenses + special cases
 */
public class Verb {
	final String[] tenses = {
			"plain,+,present indicative","plain,-,present indicative","polite,+,present indicative","polite,-,present indicative",
			"plain,+,past indicative","plain,-,past indicative","polite,+,past indicative","polite,-,past indicative",
			"plain,+,presumptive","plain,-,presumptive","polite,+,presumptive","polite,-,presumptive",
			"plain,+,past presumptive","plain,-,past presumptive","polite,+,past presumptive","polite,-,past presumptive",
			"plain,+,progressive","plain,-,progressive","polite,+,progressive","polite,-,progressive",
			"plain,+,past progressive","plain,-,past progressive","polite,+,past progressive","polite,-,past progressive",
			"plain,+,present conditional","plain,-,present conditional","polite,+,present conditional","polite,-,present conditional",
			"plain,+,past conditional","plain,-,past conditional","polite,+,past conditional","polite,-,past conditional",
			"plain,+,potential","plain,-,potential","polite,+,potential","polite,-,potential",
			"plain,+,causative","plain,-,causative","polite,+,causative","polite,-,causative",
			"plain,+,imperative","plain,-,imperative","polite,+,imperative","polite,-,imperative",
			"plain,+,passive","plain,-,passive","polite,+,passive","polite,-,passive",
			"plain,+,causative passive","plain,-,causative passive","polite,+,causative passive","polite,-,causative passive",
			"plain,+,present want to", "plain,-,present want to", "polite,+,present want to", "polite,-,present want to",
			"plain,+,past want to", "plain,-,past want to", "polite,+,past want to", "polite,-,past want to", "plain,+,want to present conditional","plain,-,want to present conditional","plain,+,want to past conditional","plain,-,want to past conditional",
			"humble,+,present","humble,-,present","humble,+,past","humble,-,past","respect,+,request","respect,-,request","humble,+,request","humble,-,request","humble,+,request","humble,-,request","respect,+,present","respect,-,present","respect,+,past","respect,-,past","humble,+,request","humble,-,request",
			"plain,+,present intransitive","plain,-,present intransitive","polite,+,present intransitive","polite,-,present intransitive","plain,+,past intransitive","plain,-,past intransitive","polite,+,past intransitive","polite,-,past intransitive",
			"plain,+,present transitive","plain,-,present transitive","polite,+,present transitive","polite,-,present transitive","plain,+,past transitive","plain,-,past transitive","polite,+,past transitive","polite,-,past transitive",
			"please do"
							
			//N3 TODO
			};
	// constructor
	public Verb () {
		
	}
	
	/* main function, decides which method to call depending in the verb's secondary grammatical type
	 * attributes:
	 * - the secondary type of the verb
	 * - the dictionary form of the verb
	 * returns:
	 * - all the possible variations of the verb in a custom arraylist
	 */
	public ArrayList<Variation> variations (String verbType, String dictForm) {
		String type = verbType;
		String dict = dictForm;
		// special arraylist for sending back the data
		ArrayList<Variation> variations;
	
		if (type.matches("v5[b|g|k|m|n|r|s|t|u|z]")) {
		// godan verbs (group 1)
			variations = godan(type,dict);
		} else if(type.matches("v5[aru|k-s|u-s|uru|r-i]") || type=="v5") {
		// irregular godan verbs (group 1)
			variations = godanSpec(type,dict);
		} else if(type=="v1" || type=="vz"){
		// ichidan verbs (group 2)
			variations = ichidan(dict,type);
		} else if(type=="vs-s" || type=="vs") {
		// irregular verbs: suru (group 3)
			variations = specialSuru(dict);
		} else if(type=="vk") {
		// irregular verbs: kuru (group 3)
			variations = specialKuru(dict);
		} else {
		// old irregular and archaic verbs
			variations = misc(type,dict);
		}
		return variations;
	}

	private ArrayList<Variation> misc(String type, String dict) {
		// TODO if time is left
		return null;
	}
	
	// irregulars kuru
	private ArrayList<Variation> specialKuru(String dict) {
		String dictForm = dict;
		String stem = dictForm.substring(0, dictForm.length()-1);
		String teForm = stem+"��";
		String taForm = stem+"��";
		String naForm;
		String iForm = stem;
		if (dictForm.equalsIgnoreCase("����")) {
			naForm = "���Ȃ�";
			}
		else {
			naForm = "���Ȃ�";
			}
		ArrayList<Variation> result = new ArrayList<Variation>(Arrays.asList(
			new Variation(dictForm,tenses[1]),
			new Variation(naForm,tenses[2]),
			new Variation(iForm+"�܂�",tenses[3]),
			new Variation(iForm+"�܂���",tenses[4]),
			new Variation(taForm,tenses[5]),
			new Variation(naForm.substring(0, naForm.length()-1)+"������",tenses[6]),
			new Variation(iForm+"�܂���",tenses[7]),
			new Variation(iForm+"�܂���ł���",tenses[8]),
			new Variation(naForm.substring(0, naForm.length()-2)+"�悤",tenses[9]),
			new Variation(dictForm+"���낤",tenses[9]),
			new Variation(naForm+"���낤",tenses[10]),
			new Variation(iForm+"�܂��傤",tenses[11]),
			new Variation(dictForm+"�ł��傤",tenses[11]),
			new Variation(naForm+"�ł��傤",tenses[12]),
			new Variation(taForm+"���낤",tenses[13]),
			new Variation(taForm+"�낤",tenses[13]),
			new Variation(naForm.substring(0, naForm.length()-1)+"���������낤",tenses[14]),
			new Variation(taForm+"�ł��傤",tenses[15]),
			new Variation(naForm.substring(0, naForm.length()-1)+"�������ł��傤",tenses[16]),
			new Variation(teForm+"����",tenses[17]),
			new Variation(teForm+"���Ȃ�",tenses[18]),
			new Variation(teForm+"���܂�",tenses[19]),
			new Variation(teForm+"���܂���",tenses[20]),
			new Variation(teForm+"����",tenses[21]),
			new Variation(teForm+"���Ȃ�����",tenses[22]),
			new Variation(teForm+"���܂���",tenses[23]),
			new Variation(teForm+"���܂���ł���",tenses[24]),
			new Variation(dictForm.substring(0, naForm.length()-1)+"���",tenses[25]),
			new Variation(naForm.substring(0, naForm.length()-1)+"�����",tenses[26]),
			new Variation(dictForm+"�Ȃ�",tenses[27]),
			new Variation(iForm+"�܂���Ȃ�",tenses[28]),
			new Variation(taForm+"��",tenses[29]),
			new Variation(naForm.substring(0, naForm.length()-1)+"��������",tenses[30]),
			new Variation(iForm+"�܂�����",tenses[31]),
			new Variation(iForm+"�܂���ł�����",tenses[32]),
			new Variation(naForm.substring(0, naForm.length()-2)+"����",tenses[33]),
			new Variation(naForm.substring(0, naForm.length()-1)+"���Ȃ�",tenses[34]),
			new Variation(naForm.substring(0, naForm.length()-1)+"���܂�",tenses[35]),
			new Variation(naForm.substring(0, naForm.length()-1)+"���܂���",tenses[36]),
			new Variation(naForm.substring(0, naForm.length()-1)+"������",tenses[37]),
			new Variation(naForm.substring(0, naForm.length()-1)+"�����Ȃ�",tenses[38]),
			new Variation(naForm.substring(0, naForm.length()-1)+"�����܂�",tenses[39]),
			new Variation(naForm.substring(0, naForm.length()-1)+"�����܂���",tenses[40]),
			new Variation(naForm.substring(0, naForm.length()-2)+"��",tenses[41]),
			new Variation(dictForm+"��",tenses[42]),
			new Variation(iForm+"��������",tenses[43]),
			new Variation(naForm+"�ł�������",tenses[44]),
			new Variation(naForm.substring(0, naForm.length()-2)+"����",tenses[45]),
			new Variation(naForm.substring(0, naForm.length()-2)+"���Ȃ�",tenses[46]),
			new Variation(naForm.substring(0, naForm.length()-2)+"���܂�",tenses[47]),
			new Variation(naForm.substring(0, naForm.length()-2)+"���܂���",tenses[48]),
			new Variation(naForm.substring(0, naForm.length()-2)+"��������",tenses[49]),
			new Variation(naForm.substring(0, naForm.length()-2)+"�������Ȃ�",tenses[50]),
			new Variation(naForm.substring(0, naForm.length()-2)+"�������܂�",tenses[51]),
			new Variation(naForm.substring(0, naForm.length()-2)+"�������܂���",tenses[52]),
			new Variation(iForm+"����",tenses[53]),
			new Variation(iForm+"�����Ȃ�",tenses[54]),
			new Variation(iForm+"�����ł�",tenses[55]),
			new Variation(iForm+"�����Ȃ��ł�",tenses[56]),
			new Variation(iForm+"��������",tenses[57]),
			new Variation(iForm+"���Ȃ�����",tenses[58]),
			new Variation(iForm+"����������",tenses[59]),
			new Variation(iForm+"���������ł�",tenses[60]),
			new Variation(iForm+"���Ȃ������ł�",tenses[61]),
			new Variation(iForm+"�������",tenses[62]),
			new Variation(iForm+"���Ȃ����",tenses[63]),
			new Variation(iForm+"����������",tenses[64]),
			new Variation(iForm+"���Ȃ�������",tenses[65]),
			new Variation("��"+iForm+"���܂�",tenses[66]),
			new Variation("��"+iForm+"���܂���",tenses[67]),
			new Variation("��"+iForm+"���܂���",tenses[68]),
			new Variation("��"+iForm+"���܂���ł���",tenses[69]),
			new Variation("��"+iForm+"���Ă�������",tenses[70]),
			new Variation("��"+iForm+"���ĉ�����",tenses[70]),
			new Variation("��"+naForm+"�ł�������",tenses[71]),
			new Variation("��"+naForm+"�ŉ�����",tenses[71]),
			new Variation("��"+iForm+"��������",tenses[72]),
			new Variation("��"+iForm+"������",tenses[72]),
			new Variation("��"+iForm+"�ɂȂ�܂�",tenses[73]),
			new Variation("��"+iForm+"�ɂȂ�܂���",tenses[74]),
			new Variation("��"+iForm+"�ɂȂ�܂���",tenses[75]),
			new Variation("��"+iForm+"�ɂȂ�܂���ł���",tenses[76]),
			new Variation("��"+iForm+"�ɂȂ��Ă�������",tenses[77]),
			new Variation("��"+iForm+"�ɂȂ��ĉ�����",tenses[77]),
			new Variation("��"+iForm+"�ɂȂ�Ȃ��ł�������",tenses[78]),
			new Variation("��"+iForm+"�ɂȂ�Ȃ��ŉ�����",tenses[78]),
			new Variation(teForm+"����",tenses[79]),
			new Variation(teForm+"�Ȃ�",tenses[80]),
			new Variation(teForm+"����܂�",tenses[81]),
			new Variation(teForm+"����܂���",tenses[82]),
			new Variation(teForm+"������",tenses[83]),
			new Variation(teForm+"�Ȃ�����",tenses[84]),
			new Variation(teForm+"����܂���",tenses[85]),
			new Variation(teForm+"����܂���ł���",tenses[86]),
			new Variation(teForm+"����",tenses[87]),
			new Variation(teForm+"���Ȃ�",tenses[88]),
			new Variation(teForm+"���܂�",tenses[89]),
			new Variation(teForm+"���܂���",tenses[90]),
			new Variation(teForm+"����",tenses[91]),
			new Variation(teForm+"���Ȃ�����",tenses[92]),
			new Variation(teForm+"���܂���",tenses[93]),
			new Variation(teForm+"���܂���ł���",tenses[94]),
			new Variation(iForm+"�Ȃ���",tenses[95])
			));
		return result;
	}
	// irregulars ��uru
	private ArrayList<Variation> specialSuru(String dict) {
		String dictForm = dict;
		// "stem" needed for the 'noun+suru' e.g.: benkyou suru
		String stem = dictForm.substring(0, dictForm.length()-2);
		ArrayList<Variation> result = new ArrayList<Variation>(Arrays.asList(
				new Variation(stem+"����",tenses[1]),
				new Variation(stem+"���Ȃ�",tenses[2]),
				new Variation(stem+"���܂�",tenses[3]),
				new Variation(stem+"���܂���",tenses[4]),
				new Variation(stem+"����",tenses[5]),
				new Variation(stem+"���Ȃ�����",tenses[6]),
				new Variation(stem+"���܂���",tenses[7]),
				new Variation(stem+"���܂���ł���",tenses[8]),
				new Variation(stem+"���悤",tenses[9]),
				new Variation(stem+"���邾�낤",tenses[9]),
				new Variation(stem+"���Ȃ����낤",tenses[10]),
				new Variation(stem+"���܂��傤",tenses[11]),
				new Variation(stem+"����ł��傤",tenses[11]),
				new Variation(stem+"���Ȃ��ł��傤",tenses[12]),
				new Variation(stem+"�������낤",tenses[13]),
				new Variation(stem+"�����낤",tenses[13]),
				new Variation(stem+"���Ȃ��������낤",tenses[14]),
				new Variation(stem+"���܂����낤",tenses[15]),
				new Variation(stem+"���Ȃ������ł��傤",tenses[16]),
				new Variation(stem+"���Ă���",tenses[17]),
				new Variation(stem+"���Ă��Ȃ�",tenses[18]),
				new Variation(stem+"���Ă��܂�",tenses[19]),
				new Variation(stem+"���Ă��܂���",tenses[20]),
				new Variation(stem+"���Ă���",tenses[21]),
				new Variation(stem+"���Ă��Ȃ�����",tenses[22]),
				new Variation(stem+"���Ă��܂���",tenses[23]),
				new Variation(stem+"���Ă��܂���ł���",tenses[24]),
				new Variation(stem+"�����",tenses[25]),
				new Variation(stem+"���Ȃ����",tenses[26]),
				new Variation(stem+"����Ȃ�",tenses[27]),
				new Variation(stem+"���Ȃ��Ȃ�",tenses[28]),
				new Variation(stem+"������",tenses[29]),
				new Variation(stem+"���Ȃ�������",tenses[30]),
				new Variation(stem+"���܂�����",tenses[31]),
				new Variation(stem+"���܂���ł�����",tenses[32]),
				new Variation(stem+"�ł���",tenses[33]),
				new Variation(stem+"�ł��Ȃ�",tenses[34]),
				new Variation(stem+"�ł��܂�",tenses[35]),
				new Variation(stem+"�ł��܂���",tenses[36]),
				new Variation(stem+"������",tenses[37]),
				new Variation(stem+"�����Ȃ�",tenses[38]),
				new Variation(stem+"�����܂�",tenses[39]),
				new Variation(stem+"�����܂���",tenses[40]),
				new Variation(stem+"����",tenses[41]),
				new Variation(stem+"�����",tenses[42]),
				new Variation(stem+"���Ă�������",tenses[43]),
				new Variation(stem+"���Ȃ��ł�������",tenses[44]),
				new Variation(stem+"�����",tenses[45]),
				new Variation(stem+"����Ȃ�",tenses[46]),
				new Variation(stem+"����܂�",tenses[47]),
				new Variation(stem+"����܂���",tenses[48]),
				new Variation(stem+"��������",tenses[49]),
				new Variation(stem+"�������Ȃ�",tenses[50]),
				new Variation(stem+"�������܂�",tenses[51]),
				new Variation(stem+"�������܂���",tenses[52]),
				new Variation(stem+"������",tenses[53]),
				new Variation(stem+"�������Ȃ�",tenses[54]),
				new Variation(stem+"�������ł�",tenses[55]),
				new Variation(stem+"�������Ȃ��ł�",tenses[56]),
				new Variation(stem+"����������",tenses[57]),
				new Variation(stem+"�����Ȃ�����",tenses[58]),
				new Variation(stem+"������������",tenses[59]),
				new Variation(stem+"�����������ł�",tenses[60]),
				new Variation(stem+"�����Ȃ������ł�",tenses[61]),
				new Variation(stem+"���������",tenses[62]),
				new Variation(stem+"�����Ȃ����",tenses[63]),
				new Variation(stem+"������������",tenses[64]),
				new Variation(stem+"�����Ȃ�������",tenses[65]),
				new Variation(stem+"�������܂�",tenses[66]),
				new Variation(stem+"�������܂���",tenses[67]),
				new Variation(stem+"���������܂���",tenses[68]),
				new Variation(stem+"�������܂���ł���",tenses[69]),
				new Variation(stem+"�v���܂�",tenses[66]),
				new Variation(stem+"�v���܂���",tenses[67]),
				new Variation(stem+"�v���܂���",tenses[68]),
				new Variation(stem+"�v���܂���ł���",tenses[69]),
				new Variation(stem+"�Ȃ����܂�",tenses[73]),
				new Variation(stem+"�Ȃ����܂���",tenses[74]),
				new Variation(stem+"�Ȃ����܂���",tenses[75]),
				new Variation(stem+"�Ȃ����܂���ł���",tenses[76]),
				new Variation(stem+"�Ȃ����Ă�������",tenses[77]),
				new Variation(stem+"�Ȃ����ĉ�����",tenses[77]),
				new Variation(stem+"�Ȃ��Ȃ��ł�������",tenses[78]),
				new Variation(stem+"�Ȃ��Ȃ��ŉ�����",tenses[78]),
				new Variation(stem+"�ׂ����܂�",tenses[73]),
				new Variation(stem+"�ׂ����܂���",tenses[74]),
				new Variation(stem+"�ׂ����܂���",tenses[75]),
				new Variation(stem+"�ׂ����܂���ł���",tenses[76]),
				new Variation(stem+"�ׂ����Ă�������",tenses[77]),
				new Variation(stem+"�ׂ����ĉ�����",tenses[77]),
				new Variation(stem+"�ׂ��Ȃ��ł�������",tenses[78]),
				new Variation(stem+"�ׂ��Ȃ��ŉ�����",tenses[78]),
				new Variation(stem+"���Ă���",tenses[79]),
				new Variation(stem+"���ĂȂ�",tenses[80]),
				new Variation(stem+"���Ă���܂�",tenses[81]),
				new Variation(stem+"���Ă���܂���",tenses[82]),
				new Variation(stem+"���Ă�����",tenses[83]),
				new Variation(stem+"���ĂȂ�����",tenses[84]),
				new Variation(stem+"���Ă���܂���",tenses[85]),
				new Variation(stem+"���Ă���܂���ł���",tenses[86]),
				new Variation(stem+"���Ă���",tenses[87]),
				new Variation(stem+"���Ă��Ȃ�",tenses[88]),
				new Variation(stem+"���Ă��܂�",tenses[89]),
				new Variation(stem+"���Ă��܂���",tenses[90]),
				new Variation(stem+"���Ă���",tenses[91]),
				new Variation(stem+"���Ă��Ȃ�����",tenses[92]),
				new Variation(stem+"���Ă��܂���",tenses[93]),
				new Variation(stem+"���Ă��܂���ł���",tenses[94]),
				new Variation(stem+"���Ȃ���",tenses[95])
				));
				return result;
	}

	private ArrayList<Variation> godanSpec(String type, String dict) {
		// TODO if time is left
		return null;
	}
	
	// ichidan
	private ArrayList<Variation> ichidan(String dict, String type) {
		String dictForm = dict;
		String verbType = type;
		String stem = dictForm.substring(0, dictForm.length()-1);
		String teForm = stem+"��";
		String taForm = stem+"��";
		String naForm = stem+"�Ȃ�";
		String iForm = stem;
		// building the array
		ArrayList<Variation> result = new ArrayList<Variation>(Arrays.asList(
				new Variation(dictForm,tenses[1]),
				new Variation(naForm,tenses[2]),
				new Variation(iForm+"�܂�",tenses[3]),
				new Variation(iForm+"�܂���",tenses[4]),
				new Variation(taForm,tenses[5]),
				new Variation(naForm.substring(0, naForm.length()-1)+"������",tenses[6]),
				new Variation(iForm+"�܂���",tenses[7]),
				new Variation(iForm+"�܂���ł���",tenses[8]),
				new Variation(iForm+"�悤",tenses[9]),
				new Variation(dictForm+"���낤",tenses[9]),
				new Variation(naForm+"���낤",tenses[10]),
				new Variation(iForm+"�܂��傤",tenses[11]),
				new Variation(dictForm+"�ł��傤",tenses[11]),
				new Variation(naForm+"�ł��傤",tenses[12]),
				new Variation(taForm+"���낤",tenses[13]),
				new Variation(taForm+"�낤",tenses[13]),
				new Variation(naForm.substring(0, naForm.length()-1)+"���������낤",tenses[14]),
				new Variation(taForm+"�ł��傤",tenses[15]),
				new Variation(naForm.substring(0, naForm.length()-1)+"�������ł��傤",tenses[16]),
				new Variation(teForm+"����",tenses[17]),
				new Variation(teForm+"���Ȃ�",tenses[18]),
				new Variation(teForm+"���܂�",tenses[19]),
				new Variation(teForm+"���܂���",tenses[20]),
				new Variation(teForm+"����",tenses[21]),
				new Variation(teForm+"���Ȃ�����",tenses[22]),
				new Variation(teForm+"���܂���",tenses[23]),
				new Variation(teForm+"���܂���ł���",tenses[24]),
				new Variation(iForm+"���",tenses[25]),
				new Variation(naForm.substring(0, naForm.length()-1)+"�����",tenses[26]),
				new Variation(iForm+"�܂��Ȃ�",tenses[27]),
				new Variation(iForm+"�܂���Ȃ�",tenses[28]),
				new Variation(taForm+"��",tenses[29]),
				new Variation(naForm.substring(0, naForm.length()-1)+"��������",tenses[30]),
				new Variation(iForm+"�܂�����",tenses[31]),
				new Variation(iForm+"�܂���ł�����",tenses[32]),
				new Variation(iForm+"����",tenses[33]),
				new Variation(iForm+"���Ȃ�",tenses[34]),
				new Variation(iForm+"���܂�",tenses[35]),
				new Variation(iForm+"���܂���",tenses[36]),
				new Variation(iForm+"������",tenses[37]),
				new Variation(iForm+"�����Ȃ�",tenses[38]),
				new Variation(iForm+"�����܂�",tenses[39]),
				new Variation(iForm+"�����܂���",tenses[40]),
				new Variation(iForm+"��",tenses[41]),
				new Variation(dictForm+"��",tenses[42]),
				new Variation(teForm+"��������",tenses[43]),
				new Variation(naForm+"�ł�������",tenses[44]),
				new Variation(iForm+"����",tenses[45]),
				new Variation(iForm+"���Ȃ�",tenses[46]),
				new Variation(iForm+"���܂�",tenses[47]),
				new Variation(iForm+"���܂���",tenses[48]),
				new Variation(iForm+"��������",tenses[49]),
				new Variation(iForm+"�������Ȃ�",tenses[50]),
				new Variation(iForm+"�������܂�",tenses[51]),
				new Variation(iForm+"�������܂���",tenses[52]),
				new Variation(iForm+"����",tenses[53]),
				new Variation(iForm+"�����Ȃ�",tenses[54]),
				new Variation(iForm+"�����ł�",tenses[55]),
				new Variation(iForm+"�����Ȃ��ł�",tenses[56]),
				new Variation(iForm+"��������",tenses[57]),
				new Variation(iForm+"���Ȃ�����",tenses[58]),
				new Variation(iForm+"����������",tenses[59]),
				new Variation(iForm+"���������ł�",tenses[60]),
				new Variation(iForm+"���Ȃ������ł�",tenses[61]),
				new Variation(iForm+"�������",tenses[62]),
				new Variation(iForm+"���Ȃ����",tenses[63]),
				new Variation(iForm+"����������",tenses[64]),
				new Variation(iForm+"���Ȃ�������",tenses[65]),
				// honorific TODO
				new Variation("��"+iForm+"���܂�",tenses[66]),
				new Variation("��"+iForm+"���܂���",tenses[67]),
				new Variation("��"+iForm+"���܂���",tenses[68]),
				new Variation("��"+iForm+"���܂���ł���",tenses[69]),
				new Variation("��"+iForm+"���Ă�������",tenses[70]),
				new Variation("��"+iForm+"���ĉ�����",tenses[70]),
				new Variation("��"+naForm+"�ł�������",tenses[71]),
				new Variation("��"+naForm+"�ŉ�����",tenses[71]),
				new Variation("��"+iForm+"��������",tenses[72]),
				new Variation("��"+iForm+"������",tenses[72]),
				new Variation("��"+iForm+"�ɂȂ�܂�",tenses[73]),
				new Variation("��"+iForm+"�ɂȂ�܂���",tenses[74]),
				new Variation("��"+iForm+"�ɂȂ�܂���",tenses[75]),
				new Variation("��"+iForm+"�ɂȂ�܂���ł���",tenses[76]),
				new Variation("��"+iForm+"�ɂȂ��Ă�������",tenses[77]),
				new Variation("��"+iForm+"�ɂȂ��ĉ�����",tenses[77]),
				new Variation("��"+iForm+"�ɂȂ�Ȃ��ł�������",tenses[78]),
				new Variation("��"+iForm+"�ɂȂ�Ȃ��ŉ�����",tenses[78]),
				new Variation(iForm+"�Ȃ���",tenses[95])
				));
		if(verbType.matches(",vi")){
			result.add(new Variation(teForm+"����",tenses[87]));
			result.add(new Variation(teForm+"���Ȃ�",tenses[88]));
			result.add(new Variation(teForm+"���܂�",tenses[89]));
			result.add(new Variation(teForm+"���܂���",tenses[90]));
			result.add(new Variation(teForm+"����",tenses[91]));
			result.add(new Variation(teForm+"���Ȃ�����",tenses[92]));
			result.add(new Variation(teForm+"���܂���",tenses[93]));
			result.add(new Variation(teForm+"���܂���ł���",tenses[94]));
		} else if (verbType.matches(",vt")){
			result.add(new Variation(teForm+"����",tenses[79]));
			result.add(new Variation(teForm+"�Ȃ�",tenses[80]));
			result.add(new Variation(teForm+"����܂�",tenses[81]));
			result.add(new Variation(teForm+"����܂���",tenses[82]));
			result.add(new Variation(teForm+"������",tenses[83]));
			result.add(new Variation(teForm+"�Ȃ�����",tenses[84]));
			result.add(new Variation(teForm+"����܂���",tenses[85]));
			result.add(new Variation(teForm+"����܂���ł���",tenses[86]));
		} else {
			// no transitive or intransitive usage
		}
		return result;
	}

	// godan
	private ArrayList<Variation> godan(String type, String dict) {
		String dictForm = dict;
		String verbType = type;
		String stem = dictForm.substring(0, dictForm.length()-1);
		String [] conjugation = new String[5];
		// conjugation variations in godan
		// b|g|k|m|n|r|s|t|u|z
		if (verbType.matches("v5b")) {
			conjugation[0]="��";
			conjugation[1]="��";
			conjugation[2]="��";
			conjugation[3]="��";
			conjugation[4]="��";
		} else if(type.matches("v5g")) {
			conjugation[0]="��";
			conjugation[1]="��";
			conjugation[2]="��";
			conjugation[3]="��";
			conjugation[4]="��";
		} else if(type.matches("v5k")) {
			conjugation[0]="��";
			conjugation[1]="��";
			conjugation[2]="��";
			conjugation[3]="��";
			conjugation[4]="��";
		} else if(type.matches("v5m")) {
			conjugation[0]="��";
			conjugation[1]="��";
			conjugation[2]="��";
			conjugation[3]="��";
			conjugation[4]="��";
		} else if(type.matches("v5n")) {
			conjugation[0]="��";
			conjugation[1]="��";
			conjugation[2]="��";
			conjugation[3]="��";
			conjugation[4]="��";
		} else if(type.matches("v5r")) {
			conjugation[0]="��";
			conjugation[1]="��";
			conjugation[2]="��";
			conjugation[3]="��";
			conjugation[4]="��";
		} else if(type.matches("v5t")) {
			conjugation[0]="��";
			conjugation[1]="��";
			conjugation[2]="��";
			conjugation[3]="��";
			conjugation[4]="��";
		} else if(type.matches("v5u")) {
			conjugation[0]="��";
			conjugation[1]="��";
			conjugation[2]="��";
			conjugation[3]="��";
			conjugation[4]="��";
		} else if(type.matches("v5z")) {
			conjugation[0]="��";
			conjugation[1]="��";
			conjugation[2]="��";
			conjugation[3]="��";
			conjugation[4]="��";
		} else if(type.matches("v5s")) {
			conjugation[0]="��";
			conjugation[1]="��";
			conjugation[2]="��";
			conjugation[3]="��";
			conjugation[4]="��";
		} else {
			conjugation[0]="";
			conjugation[1]="";
			conjugation[2]="";
			conjugation[3]="";
			conjugation[4]="";
		}
		// building the arraylist
		ArrayList<Variation> result = new ArrayList<Variation>(Arrays.asList(
				new Variation(stem+conjugation[4],tenses[1]),
				new Variation(stem+conjugation[0]+"�Ȃ�",tenses[2]),
				new Variation(stem+conjugation[1]+"�܂�",tenses[3]),
				new Variation(stem+conjugation[1]+"�܂���",tenses[4]),
				// past indicative, positive, plain
				new Variation(stem+conjugation[0]+"�Ȃ�����",tenses[6]),
				new Variation(stem+conjugation[1]+"�܂���",tenses[7]),
				new Variation(stem+conjugation[1]+"�܂���ł���",tenses[8]),
				new Variation(stem+conjugation[3]+"��",tenses[9]),
				new Variation(stem+conjugation[4]+"���낤",tenses[9]),
				new Variation(stem+conjugation[0]+"�Ȃ����낤",tenses[10]),
				new Variation(stem+conjugation[1]+"�܂��傤",tenses[11]),
				new Variation(stem+conjugation[4]+"�ł��傤",tenses[11]),
				new Variation(stem+conjugation[0]+"�Ȃ��ł��傤",tenses[12]),
				// past presumptive, positive, plain
				new Variation(stem+conjugation[0]+"�Ȃ��������낤",tenses[14]),
				new Variation(stem+conjugation[1]+"�܂����낤",tenses[15]),
				new Variation(stem+conjugation[0]+"�Ȃ������ł��傤",tenses[16]),
				// te-forms
				new Variation(stem+conjugation[2]+"��",tenses[25]),
				new Variation(stem+conjugation[0]+"�Ȃ����",tenses[26]),
				new Variation(stem+conjugation[4]+"�Ȃ�",tenses[27]),
				new Variation(stem+conjugation[0]+"�Ȃ��Ȃ�",tenses[28]),
				// past conditional, positive, plain
				new Variation(stem+conjugation[0]+"�Ȃ�������",tenses[30]),
				new Variation(stem+conjugation[1]+"�܂�����",tenses[31]),
				new Variation(stem+conjugation[1]+"�܂���ł�����",tenses[32]),
				new Variation(stem+conjugation[2]+"��",tenses[33]),
				new Variation(stem+conjugation[2]+"�Ȃ�",tenses[34]),
				new Variation(stem+conjugation[2]+"�܂�",tenses[35]),
				new Variation(stem+conjugation[2]+"�܂���",tenses[36]),
				new Variation(stem+conjugation[0]+"����",tenses[37]),
				new Variation(stem+conjugation[0]+"���Ȃ�",tenses[38]),
				new Variation(stem+conjugation[0]+"���܂�",tenses[39]),
				new Variation(stem+conjugation[0]+"���܂���",tenses[40]),
				new Variation(stem+conjugation[2],tenses[41]),
				new Variation(stem+conjugation[4]+"��",tenses[42]),
				// tekudasai, positive
				new Variation(stem+conjugation[0]+"�Ȃ��ł�������",tenses[44]),
				new Variation(stem+conjugation[0]+"�Ȃ��ŉ�����",tenses[44]),
				new Variation(stem+conjugation[0]+"���",tenses[45]),
				new Variation(stem+conjugation[0]+"��Ȃ�",tenses[46]),
				new Variation(stem+conjugation[0]+"��܂�",tenses[47]),
				new Variation(stem+conjugation[0]+"��܂���",tenses[48]),
				new Variation(stem+conjugation[0]+"������",tenses[49]),
				new Variation(stem+conjugation[0]+"�����Ȃ�",tenses[50]),
				new Variation(stem+conjugation[0]+"�����܂�",tenses[51]),
				new Variation(stem+conjugation[0]+"�����܂���",tenses[52])
				));
		
		// godan irregularities of te- and ta-form
		String taForm="";
		String teForm="";
		String naForm = stem+conjugation[0]+"�Ȃ�";
		String iForm = stem+conjugation[1];
		
		if(verbType.matches("v5[b|n|m]")){
			taForm = stem+"��";
			teForm = stem+"���";
		} else if(verbType.matches("v5[u|t|r]")) {
			taForm = stem+"����";
			teForm = stem+"����";
		} else if(verbType.matches("v5k")) {
			taForm = stem+"����";
			teForm = stem+"����";
		} else if(verbType.matches("v5g")) {
			taForm = stem+"����";
			teForm = stem+"����";
		} else if(verbType.matches("v5s")) {
			taForm = stem+"����";
			teForm = stem+"����";
		}
		// passive causative v2 for all godan verbs except su type
		if (verbType.matches("v5[b|n|m|u|t|r|k|g]")) {
			result.add(new Variation(stem+conjugation[0]+"�����",tenses[49]));
			result.add(new Variation(stem+conjugation[0]+"����Ȃ�",tenses[50]));
			result.add(new Variation(stem+conjugation[0]+"����܂�",tenses[51]));
			result.add(new Variation(stem+conjugation[0]+"����܂���",tenses[52]));
		}
		result.add(new Variation(stem+taForm,tenses[5]));
		result.add(new Variation(stem+taForm+"���낤",tenses[13]));
		result.add(new Variation(stem+taForm+"�낤",tenses[13]));
		result.add(new Variation(stem+teForm+"����",tenses[17]));
		result.add(new Variation(stem+teForm+"���Ȃ�",tenses[18]));
		result.add(new Variation(stem+teForm+"���܂�",tenses[19]));
		result.add(new Variation(stem+teForm+"���܂���",tenses[20]));
		result.add(new Variation(stem+teForm+"����",tenses[21]));
		result.add(new Variation(stem+teForm+"���Ȃ�����",tenses[22]));
		result.add(new Variation(stem+teForm+"���܂���",tenses[23]));
		result.add(new Variation(stem+teForm+"���܂���ł���",tenses[24]));
		result.add(new Variation(stem+taForm+"��",tenses[29]));
		result.add(new Variation(stem+teForm+"��������",tenses[43]));
		result.add(new Variation(stem+teForm+"������",tenses[43]));
		result.add(new Variation(iForm+"����",tenses[53]));
		result.add(new Variation(iForm+"�����Ȃ�",tenses[54]));
		result.add(new Variation(iForm+"�����ł�",tenses[55]));
		result.add(new Variation(iForm+"�����Ȃ��ł�",tenses[56]));
		result.add(new Variation(iForm+"��������",tenses[57]));
		result.add(new Variation(iForm+"���Ȃ�����",tenses[58]));
		result.add(new Variation(iForm+"����������",tenses[59]));
		result.add(new Variation(iForm+"���������ł�",tenses[60]));
		result.add(new Variation(iForm+"���Ȃ������ł�",tenses[61]));
		result.add(new Variation(iForm+"�������",tenses[62]));
		result.add(new Variation(iForm+"���Ȃ����",tenses[63]));
		result.add(new Variation(iForm+"����������",tenses[64]));
		result.add(new Variation(iForm+"���Ȃ�������",tenses[65]));
		result.add(new Variation("��"+iForm+"���܂�",tenses[66]));
		result.add(new Variation("��"+iForm+"���܂���",tenses[67]));
		result.add(new Variation("��"+iForm+"���܂���",tenses[68]));
		result.add(new Variation("��"+iForm+"���܂���ł���",tenses[69]));
		result.add(new Variation("��"+iForm+"���Ă�������",tenses[70]));
		result.add(new Variation("��"+iForm+"���ĉ�����",tenses[70]));
		result.add(new Variation("��"+naForm+"�ł�������",tenses[71]));
		result.add(new Variation("��"+naForm+"�ŉ�����",tenses[71]));
		result.add(new Variation("��"+iForm+"��������",tenses[72]));
		result.add(new Variation("��"+iForm+"������",tenses[72]));
		result.add(new Variation("��"+iForm+"�ɂȂ�܂�",tenses[73]));
		result.add(new Variation("��"+iForm+"�ɂȂ�܂���",tenses[74]));
		result.add(new Variation("��"+iForm+"�ɂȂ�܂���",tenses[75]));
		result.add(new Variation("��"+iForm+"�ɂȂ�܂���ł���",tenses[76]));
		result.add(new Variation("��"+iForm+"�ɂȂ��Ă�������",tenses[77]));
		result.add(new Variation("��"+iForm+"�ɂȂ��ĉ�����",tenses[77]));
		result.add(new Variation("��"+iForm+"�ɂȂ�Ȃ��ł�������",tenses[78]));
		result.add(new Variation("��"+iForm+"�ɂȂ�Ȃ��ŉ�����",tenses[78]));
		result.add(new Variation(iForm+"�Ȃ���",tenses[95]));
		// intransitive
		if(verbType.matches(",vi")){
			result.add(new Variation(teForm+"����",tenses[87]));
			result.add(new Variation(teForm+"���Ȃ�",tenses[88]));
			result.add(new Variation(teForm+"���܂�",tenses[89]));
			result.add(new Variation(teForm+"���܂���",tenses[90]));
			result.add(new Variation(teForm+"����",tenses[91]));
			result.add(new Variation(teForm+"���Ȃ�����",tenses[92]));
			result.add(new Variation(teForm+"���܂���",tenses[93]));
			result.add(new Variation(teForm+"���܂���ł���",tenses[94]));
		// transitive
		} else if (verbType.matches(",vt")){
			result.add(new Variation(teForm+"����",tenses[79]));
			result.add(new Variation(teForm+"�Ȃ�",tenses[80]));
			result.add(new Variation(teForm+"����܂�",tenses[81]));
			result.add(new Variation(teForm+"����܂���",tenses[82]));
			result.add(new Variation(teForm+"������",tenses[83]));
			result.add(new Variation(teForm+"�Ȃ�����",tenses[84]));
			result.add(new Variation(teForm+"����܂���",tenses[85]));
			result.add(new Variation(teForm+"����܂���ł���",tenses[86]));
		} else {
			// no transitive or intransitive usage
		}
		return result;
	}
}