package org.eclipse.epsilon.epsilonoid;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.epsilonoid.R;

import android.app.ActionBar.Tab;
import android.app.ActionBar;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	protected String output = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		Button runButton = (Button) findViewById(R.id.runButton);
		final TextView codeText = (TextView) findViewById(R.id.codeText);
		final TextView outputText = (TextView) findViewById(R.id.outputText);
		
		getActionBar().setSubtitle("Epsilon demo app");
		getActionBar().setHomeButtonEnabled(true);
		
		getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		getActionBar().setDisplayShowTitleEnabled(false);
		//getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		
		createTab("Code");
		createTab("Output");
		
		CodeEditorFragment codeEditorFragment = (CodeEditorFragment) getFragmentManager().findFragmentById(R.id.codeText1);
		codeEditorFragment.setText("I feel good");
		
		codeText.setText("for (i in 4.to(2)) {\n\t i.println(\"L: \"); \n }");
		
		runButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				try {
					EolModule module = new EolModule();
					module.parse(codeText.getText()+"");
					
					output = "";
					module.getContext().setOutputStream(new PrintStream(new OutputStream() {
						
						@Override
						public void write(int c) throws IOException {
							output += (char) c;
							System.err.println(output);
						}
						
					}));
					
					module.execute();
					outputText.setText(output);
					
				}
				catch (Exception ex) {
					throw new RuntimeException(ex);
				}
				
			}
		});
		
		
	}
	
	protected void createTab(String text) {
		Tab tab = getActionBar().newTab();
		tab.setText(text).setTabListener(new TabListener() {
			
			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}
		});
		getActionBar().addTab(tab);		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.layout.main_menu, menu);
		//createMenuItem(menu, "M1");
		//createMenuItem(menu, "M2");
		//createMenuItem(menu, "M3");
		
		return true;
	}
	
	protected void createMenuItem(Menu menu, String text) {
		MenuItem item = menu.add(0, 0, Menu.NONE, text);
		item.setIcon(R.drawable.ic_launcher);
		item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
	}
}
