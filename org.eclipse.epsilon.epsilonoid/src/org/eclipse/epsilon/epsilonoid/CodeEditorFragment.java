package org.eclipse.epsilon.epsilonoid;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class CodeEditorFragment extends Fragment {
	
	protected EditText editText = null;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.code_editor_fragment, container, false);
		editText = ((EditText)view.findViewById(R.id.textView));
		return view;
	}
	
	public void setText(String text) {
		editText.setText(text);
	}
	
	public String getText() {
		return editText.getText().toString();
	}
	
	public void setError(String text) {
		editText.setError(text);
	}
	
}
