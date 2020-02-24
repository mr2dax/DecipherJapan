package com.bai.discoverjapan.dictionary;

import java.util.HashMap;
import java.util.Map;

public class HiraToKataConverter {
	// hashmap to store hiragana and katakana table for single-way conversion
	// key=>hiragana, value=>katakana
	private Map<String, String> kanaList = new HashMap<String, String>();

	/*
	 * private String hiras [] = { "��","��","��","��","��", "��","��","��","��","��",
	 * "��","��","��","��","��", "��","��","��","��","��", "��","��","��","��","��",
	 * "��","��","��","��","��", "��","��","��","��","��", "��","��","��","��","��",
	 * "��","��","��", "��","��","��", "��","��","��","��","��", "��","��","��","��","��",
	 * "��","��","��","��","��", "��","��","��","��","��", "��","��","��","��","��",
	 * "��","��","��","��","��","��" };
	 */

	/*
	 * private String katas [] = { "�A","�C","�G","�I","�E", "�J","�L","�P","�R","�N",
	 * "�T","�V","�Z","�\","�X", "�^","�`","�e","�g","�c", "�i","�j","�l","�m","�k",
	 * "�n","�q","�w","�z","�t", "�}","�~","��","��","��", "��","��","��","��","��",
	 * "��","��","��", "��","��","��", "�K","�M","�Q","�S","�O", "�U","�W","�[","�]","�Y",
	 * "�_","�a","�f","�h","�d", "�o","�r","�x","�{","�u", "�p","�s","�y","�|","�v",
	 * "�b","��","��","��","�B","�F" };
	 */
	
	// constructor
	public HiraToKataConverter() {
		// add the values to construct pairs of hiragana and katakana for lookup
		kanaList.put("��", "�E");
		kanaList.put("��", "�A");
		kanaList.put("��", "�C");
		kanaList.put("��", "�G");
		kanaList.put("��", "�I");
		kanaList.put("��", "�E");
		kanaList.put("��", "�J");
		kanaList.put("��", "�L");
		kanaList.put("��", "�P");
		kanaList.put("��", "�R");
		kanaList.put("��", "�N");
		kanaList.put("��", "�T");
		kanaList.put("��", "�V");
		kanaList.put("��", "�Z");
		kanaList.put("��", "�\");
		kanaList.put("��", "�X");
		kanaList.put("��", "�^");
		kanaList.put("��", "�`");
		kanaList.put("��", "�e");
		kanaList.put("��", "�g");
		kanaList.put("��", "�c");
		kanaList.put("��", "�i");
		kanaList.put("��", "�j");
		kanaList.put("��", "�l");
		kanaList.put("��", "�m");
		kanaList.put("��", "�k");
		kanaList.put("��", "�n");
		kanaList.put("��", "�q");
		kanaList.put("��", "�w");
		kanaList.put("��", "�z");
		kanaList.put("��", "�t");
		kanaList.put("��", "�}");
		kanaList.put("��", "�~");
		kanaList.put("��", "��");
		kanaList.put("��", "��");
		kanaList.put("��", "��");
		kanaList.put("��", "��");
		kanaList.put("��", "��");
		kanaList.put("��", "��");
		kanaList.put("��", "��");
		kanaList.put("��", "��");
		kanaList.put("��", "��");
		kanaList.put("��", "��");
		kanaList.put("��", "��");
		kanaList.put("��", "��");
		kanaList.put("��", "��");
		kanaList.put("��", "��");
		kanaList.put("��", "�K");
		kanaList.put("��", "�M");
		kanaList.put("��", "�Q");
		kanaList.put("��", "�S");
		kanaList.put("��", "�O");
		kanaList.put("��", "�U");
		kanaList.put("��", "�W");
		kanaList.put("��", "�[");
		kanaList.put("��", "�]");
		kanaList.put("��", "�Y");
		kanaList.put("��", "�_");
		kanaList.put("��", "�a");
		kanaList.put("��", "�f");
		kanaList.put("��", "�h");
		kanaList.put("��", "�d");
		kanaList.put("��", "�o");
		kanaList.put("��", "�r");
		kanaList.put("��", "�x");
		kanaList.put("��", "�{");
		kanaList.put("��", "�u");
		kanaList.put("��", "�p");
		kanaList.put("��", "�s");
		kanaList.put("��", "�y");
		kanaList.put("��", "�|");
		kanaList.put("��", "�v");
		kanaList.put("��", "�b");
		kanaList.put("��", "��");
		kanaList.put("��", "��");
		kanaList.put("��", "��");
		kanaList.put("��", "�B");
		kanaList.put("��", "�F");
	}
	
	/*
	 * Looks up hiragana (key) in hashmap 'kanaList' and gets the katakana (value)
	 * @param hiragana - 1-character-long string (can be katakana, kanji, alphabet, hiragana)
	 * @returns kata - 1-character-long string (hiragana converted to katakana, else character unchanged)
	 */
	public String ConvertToKata(String hiragana) {
		String hira = hiragana;
		String kata="";
		// if hiragana (found among the hashmap keys)
		if (kanaList.containsKey(hira)){
			kata = kanaList.get(hira); // convert
		} else {
			kata=hira; // leave as is
		}
		return kata;
	}
}
