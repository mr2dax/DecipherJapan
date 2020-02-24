package com.bai.discoverjapan;

import android.os.Environment;

public class Constant {
	public static final String 	TAG 					= "BAITAL_TOURISM_APP";
	public static final String 	DATA_PATH 				= Environment.getExternalStorageDirectory().toString() + "/DecipherJapan/";
	public static final String 	TESS_FOLDER				= "tessdata/";
	public static final String 	IPADIC_FOLDER			= "ipadic/";
	public static final String 	DICT_FOLDER				= "dictionary/";
	public static final String  SERVER_LOC				= "http://175.41.248.154/discover_japan/";
	public static final String  DICT_ZIP_FILENAME		= "dictionary/dictionary.zip";
	public static final String  TESS_ZIP_FILENAME		= "tessdata/jpn.zip";
	public static final String  DICT_FILENAME			= "dictionary/dictionary.sqlite";
	public static final String  TESS_FILENAME			= "tessdata/jpn.traineddata";
	/** List of language files and their names from here: http://code.google.com/p/tesseract-ocr/downloads/list */
	public static final String 	LANGUAGE				= "jpn";
	public static final String 	APP_SHR_PRF_KEY 		= "BaiJapanTourism";
	public static final String 	PRF_KEY_REQ_CONFIDENCE 	= "RequiredRecognitionConfidence";
	public static final int		DEFAULT_REQ_CONFIDENCE 	= 66;
	public static final String 	PRF_KEY_REQ_TIME 		= "RequiredCaptureDelay";
	public static final int		DEFAULT_REQ_TIME 		= 3000;
	
	public static final String 	REF_IS_PREVIEW	 		= "PreviewBoolean";
	public static final boolean	IS_PREVIEW_STOPED 		= false;
	
	public static final String 	PRF_KEY_CHECK 			= "CheckBoxKey";
	public static final boolean	DEFAULT_CHECK 			= false;
	public static final String	LOW_CONFIDENCE_TEXT		= "LOW CONFIDENCE LEVEL, TRY AGAIN";
	public static final String 	PRF_SELEC_X1		 	= "SelectionX1Ratio";
	public static final String 	PRF_SELEC_Y1		 	= "SelectionY1Ratio";
	public static final String 	PRF_SELEC_X2		 	= "SelectionX2Ratio";
	public static final String 	PRF_SELEC_Y2		 	= "SelectionY2Ratio";
	public static final int		LONG_WORDS_MIN_LENGTH	= 10;	//exclusive, i.e. same as >=11
	public static final int		LONG_WORDS_MAX_LENGTH	= 18;	//exclusive, i.e. same as <=17
	public static final int		MAX_TRANS_RESULTS		= 20;	
	public static final int		SIMILAR_WORD_MAX_LENGTH = 3;	//exclusive, i.e. same as <=17
}