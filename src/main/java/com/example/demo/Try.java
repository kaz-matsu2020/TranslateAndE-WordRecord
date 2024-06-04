package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.translate.Translate;
import com.google.api.services.translate.TranslateRequestInitializer;
import com.google.api.services.translate.model.TranslationsListResponse;

public class Try {
	public static void main(String args[]) throws Exception{
		
		Translate translate = getTranslate();
	    Translate.Translations translations = translate.translations();
	    
	    List<String> q = new ArrayList<>();
	    q.add("翻訳したいやつ");
	    Translate.Translations.List op = translations.list(q, "ja");
	    
	    TranslationsListResponse res = op.execute();
	    System.out.print(res);
	    
	}
	
	private static Translate getTranslate() throws Exception {
	    HttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();
	    GsonFactory jsonFactory = GsonFactory.getDefaultInstance();
	    
	    TranslateRequestInitializer key = new TranslateRequestInitializer("APIキー");
	    return new Translate.Builder(transport, jsonFactory, null)
	            .setGoogleClientRequestInitializer(key).build();
	}
	
}