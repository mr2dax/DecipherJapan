package com.bai.discoverjapan.dictionary;

import java.util.HashMap;
import java.util.Map;

public class HiraToKataConverter {
	// hashmap to store hiragana and katakana table for single-way conversion
	// key=>hiragana, value=>katakana
	private Map<String, String> kanaList = new HashMap<String, String>();

	/*
	 * private String hiras [] = { "あ","い","え","お","う", "か","き","け","こ","く",
	 * "さ","し","せ","そ","す", "た","ち","て","と","つ", "な","に","ね","の","ぬ",
	 * "は","ひ","へ","ほ","ふ", "ま","み","め","も","む", "ら","り","れ","ろ","る",
	 * "や","よ","ゆ", "ん","わ","を", "が","ぎ","げ","ご","ぐ", "ざ","じ","ぜ","ぞ","ず",
	 * "だ","ぢ","で","ど","づ", "ば","び","べ","ぼ","ぶ", "ぱ","ぴ","ぺ","ぽ","ぷ",
	 * "っ","ょ","ゅ","ゃ","ぃ","ぇ" };
	 */

	/*
	 * private String katas [] = { "ア","イ","エ","オ","ウ", "カ","キ","ケ","コ","ク",
	 * "サ","シ","セ","ソ","ス", "タ","チ","テ","ト","ツ", "ナ","ニ","ネ","ノ","ヌ",
	 * "ハ","ヒ","ヘ","ホ","フ", "マ","ミ","メ","モ","ム", "ラ","リ","レ","ロ","ル",
	 * "ヤ","ヨ","ユ", "ン","ワ","ヲ", "ガ","ギ","ゲ","ゴ","グ", "ザ","ジ","ゼ","ゾ","ズ",
	 * "ダ","ヂ","デ","ド","ヅ", "バ","ビ","ベ","ボ","ブ", "パ","ピ","ペ","ポ","プ",
	 * "ッ","ョ","ュ","ャ","ィ","ェ" };
	 */
	
	// constructor
	public HiraToKataConverter() {
		// add the values to construct pairs of hiragana and katakana for lookup
		kanaList.put("う", "ウ");
		kanaList.put("あ", "ア");
		kanaList.put("い", "イ");
		kanaList.put("え", "エ");
		kanaList.put("お", "オ");
		kanaList.put("う", "ウ");
		kanaList.put("か", "カ");
		kanaList.put("き", "キ");
		kanaList.put("け", "ケ");
		kanaList.put("こ", "コ");
		kanaList.put("く", "ク");
		kanaList.put("さ", "サ");
		kanaList.put("し", "シ");
		kanaList.put("せ", "セ");
		kanaList.put("そ", "ソ");
		kanaList.put("す", "ス");
		kanaList.put("た", "タ");
		kanaList.put("ち", "チ");
		kanaList.put("て", "テ");
		kanaList.put("と", "ト");
		kanaList.put("つ", "ツ");
		kanaList.put("な", "ナ");
		kanaList.put("に", "ニ");
		kanaList.put("ね", "ネ");
		kanaList.put("の", "ノ");
		kanaList.put("ぬ", "ヌ");
		kanaList.put("は", "ハ");
		kanaList.put("ひ", "ヒ");
		kanaList.put("へ", "ヘ");
		kanaList.put("ほ", "ホ");
		kanaList.put("ふ", "フ");
		kanaList.put("ま", "マ");
		kanaList.put("み", "ミ");
		kanaList.put("め", "メ");
		kanaList.put("も", "モ");
		kanaList.put("む", "ム");
		kanaList.put("ら", "ラ");
		kanaList.put("り", "リ");
		kanaList.put("れ", "レ");
		kanaList.put("ろ", "ロ");
		kanaList.put("る", "ル");
		kanaList.put("や", "ヤ");
		kanaList.put("よ", "ヨ");
		kanaList.put("ゆ", "ユ");
		kanaList.put("ん", "ン");
		kanaList.put("わ", "ワ");
		kanaList.put("を", "ヲ");
		kanaList.put("が", "ガ");
		kanaList.put("ぎ", "ギ");
		kanaList.put("げ", "ゲ");
		kanaList.put("ご", "ゴ");
		kanaList.put("ぐ", "グ");
		kanaList.put("ざ", "ザ");
		kanaList.put("じ", "ジ");
		kanaList.put("ぜ", "ゼ");
		kanaList.put("ぞ", "ゾ");
		kanaList.put("ず", "ズ");
		kanaList.put("だ", "ダ");
		kanaList.put("ぢ", "ヂ");
		kanaList.put("で", "デ");
		kanaList.put("ど", "ド");
		kanaList.put("づ", "ヅ");
		kanaList.put("ば", "バ");
		kanaList.put("び", "ビ");
		kanaList.put("べ", "ベ");
		kanaList.put("ぼ", "ボ");
		kanaList.put("ぶ", "ブ");
		kanaList.put("ぱ", "パ");
		kanaList.put("ぴ", "ピ");
		kanaList.put("ぺ", "ペ");
		kanaList.put("ぽ", "ポ");
		kanaList.put("ぷ", "プ");
		kanaList.put("っ", "ッ");
		kanaList.put("ょ", "ョ");
		kanaList.put("ゅ", "ュ");
		kanaList.put("ゃ", "ャ");
		kanaList.put("ぃ", "ィ");
		kanaList.put("ぇ", "ェ");
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
