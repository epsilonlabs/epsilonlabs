package org.eclipse.epsilon.epsilonoid;

import java.util.Arrays;
import java.util.List;

import org.eclipse.epsilon.epsilonoid.syntaxhighlighting.SyntaxHighlighterParser;
import org.eclipse.epsilon.epsilonoid.syntaxhighlighting.brush.Brush;
import org.eclipse.epsilon.epsilonoid.syntaxhighlighting.brush.BrushJava;
import org.eclipse.epsilon.epsilonoid.syntaxhighlighting.brush.BrushXml;
import org.eclipse.epsilon.epsilonoid.syntaxhighlighting.brush.epsilon.BrushEol;
import org.eclipse.epsilon.epsilonoid.syntaxhighlighting.brush.epsilon.BrushEtl;
import org.eclipse.epsilon.epsilonoid.syntaxhighlighting.brush.epsilon.BrushEvl;
import org.eclipse.epsilon.epsilonoid.syntaxhighlighting.parser.*;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.renderscript.Font.Style;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class CodeEditorFragment extends Fragment {
	
	protected EditText editText = null;
	protected boolean formattingChangeEvent = false;
	protected TextWatcher textWatcher = null;
	protected String language = null;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.code_editor_fragment, container, false);
		editText = ((EditText)view.findViewById(R.id.textView));
		if (savedInstanceState != null) {
			language = savedInstanceState.getString("language");
			System.err.println("Language was " + language);
		}
		return view;
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		System.err.println("Setting language to " + language);
		outState.putString("language", language);
	}
	
	public void setText(String text, String lang) {
		
		language = lang;
		
		if (textWatcher == null) {
			
			textWatcher = new TextWatcher() {
				
				@Override
				public void onTextChanged(CharSequence s, int start, int before, int count) {
					
					System.err.println("Changed " + language);
					
					if (language == null) return;
					
					if (!formattingChangeEvent) {
						formattingChangeEvent = true;
						
						SpannableString formatted = new SpannableString(s.toString());
						
						List<Brush> brushes = Arrays.asList(new BrushXml(), new BrushEol(), new BrushEvl(), new BrushEtl());
						Brush brush = new BrushEol();
						for (Brush b : brushes) {
							if (b.getCommonFileExtensionList().contains(language.toLowerCase())) {
								brush = b;
								break;
							}
						}
						
						System.err.println(brush.getClass().getCanonicalName());
						
						SyntaxHighlighterParser parser = new SyntaxHighlighterParser(brush);
						List<ParseResult> results = parser.parse("", s.toString());
						for (final ParseResult result : results) {
							formatted.setSpan(new CharacterStyle() {
								
								@Override
								public void updateDrawState(TextPaint tp) { 
									if (result.getStyleKeys().contains("string")) {
										tp.setColor(Color.rgb(42, 0, 255));
									}
									else if (result.getStyleKeys().contains("comment")) {
										tp.setColor(Color.rgb(63, 127, 95));
										tp.setTextSkewX(-0.2f);
									}
									else if (result.getStyleKeys().contains("keyword")) {
										if (!"xml".equals(language)) {
											tp.setColor(Color.rgb(127, 0, 85));
											tp.setFakeBoldText(true);
										}
										else {
											tp.setColor(Color.rgb(42, 0, 255));
										}
									}
								}
							}, result.getOffset(), result.getOffset() + result.getLength(), 0);
						}
						
						int selectionStart = editText.getSelectionStart();
						int selectionEnd = editText.getSelectionEnd();
						
						editText.setText(formatted);
						
						editText.setSelection(selectionStart, selectionEnd);
						
						formattingChangeEvent = false;
					}
				}
				
				@Override
				public void beforeTextChanged(CharSequence s, int start, int count,
						int after) {
					
				}
				
				@Override
				public void afterTextChanged(Editable s) {
					
				}
				
			};
			
			editText.addTextChangedListener(textWatcher);
			
		}
		
		editText.setText(text);
	}
	
	public String getText() {
		return editText.getText().toString();
	}
	
	public void setError(String text) {
		editText.setError(text);
	}
	
}
