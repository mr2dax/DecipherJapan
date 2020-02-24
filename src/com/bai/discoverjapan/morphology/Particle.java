package com.bai.discoverjapan.morphology;

import java.util.HashMap;
import java.util.Map;

public class Particle {
	private Map<String, String> funcParts = new HashMap<String, String>();
	private Map<String, String> meanParts = new HashMap<String, String>();

	// constructor
	public Particle() {
		funcParts.put("��", "");
		funcParts.put("��", "");
		funcParts.put("����", "");
		funcParts.put("��", "");
		
		meanParts.put("������", "myself");
		meanParts.put("�~����", "myself");
		meanParts.put("��", "too");
		meanParts.put("��", "");
		meanParts.put("��������", "because");
		meanParts.put("���񂾂���", "because");
		meanParts.put("����", "because");
		meanParts.put("�킢��", "!");
		meanParts.put("�킢��", "!");
		meanParts.put("�킢�̂�", "!");
		meanParts.put("��", "!?");
		meanParts.put("��", "?");
		meanParts.put("����", "or ...?");
		meanParts.put("������","??");
		meanParts.put("����", "or ...?");
		meanParts.put("����",", right?");
		meanParts.put("����", "");
		meanParts.put("����", "Really?");
		meanParts.put("����","");
		meanParts.put("���Ȃ�","");
		meanParts.put("��","?");
		meanParts.put("����", "?");
		meanParts.put("����", "");
		meanParts.put("��", "!");
		meanParts.put("����", "");
		meanParts.put("��", "!");
		meanParts.put("����", "");
		meanParts.put("����", "");
		meanParts.put("����", "and");
		meanParts.put("����", "?");
		meanParts.put("����", "and");
		meanParts.put("����","?");
		meanParts.put("����", "");
		meanParts.put("���Ă�","");
		meanParts.put("��", "");
		meanParts.put("�Ă�","");
		meanParts.put("��", "in");
		meanParts.put("�ł�����", "by");
		meanParts.put("�Ƃ�", "in other words");
		meanParts.put("�Ƃ��","I heard");
		meanParts.put("�ǂ���","not at all");
		meanParts.put("��", "!");
		meanParts.put("��","at");
		meanParts.put("�ɂ�", "in");
		meanParts.put("��",", right?");
		meanParts.put("�˂�",", right?");
		meanParts.put("�˂�", "!");
		meanParts.put("��", "'s");
		meanParts.put("�̂�", "!");
		meanParts.put("�̂�", "");
		meanParts.put("�̂�", "");
		meanParts.put("��", "");
		meanParts.put("�΂�", "!");
		meanParts.put("�w", "to");
		meanParts.put("������","");
		meanParts.put("���̂�","");
		meanParts.put("����","");
		meanParts.put("��", "and");
		meanParts.put("���", "");
		meanParts.put("��","!");
		meanParts.put("��", "!");
		meanParts.put("�킢", "!");
		meanParts.put("�킦", "!");
		meanParts.put("���", "!");
		meanParts.put("��", "and");
		meanParts.put("�Ƃ�", "or");
		meanParts.put("���̂�","because");
		meanParts.put("�����","because");
		meanParts.put("�̂�","because");
		meanParts.put("�̂�","instead");
	}
	public String particleMeaning(String particle) {
		String part = particle;
		String meaning="";
		// if particle can be translated into some meaningful word(s) (found among the hashmap keys)
		if (meanParts.containsKey(part)){
			meaning = meanParts.get(part); // get meaning
		} else if (funcParts.containsKey(part)){
			meaning = funcParts.get(part); // get functional stuff TODO
		} else {
			meaning = part;
		}
		return meaning;
	}
}
