package org.eclipse.epsilon.epsilonoid;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class CodeEditorFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.code_editor_fragment, container, false);
	}
	
	public void setText(String text) {
		((MyEditText)getView().findViewById(R.id.textView)).paintRed();
	}
	
}
