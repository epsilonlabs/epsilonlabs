package org.eclipse.epsilon.epsilonoid;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.epsilonoid.R;

import android.app.ActionBar.Tab;
import android.app.ActionBar;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	protected CodeEditorFragment codeText = null;
	protected CodeEditorFragment modelText = null;
	protected CodeEditorFragment outputText = null;
	protected String output = "";
	protected Tab outputTab = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		//getActionBar().setSubtitle("Epsilon demo app");
		getActionBar().setHomeButtonEnabled(true);
		
		getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		//getActionBar().setDisplayShowTitleEnabled(false);
		//getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		
		
		codeText = (CodeEditorFragment) getFragmentManager().findFragmentById(R.id.codeText);
		modelText = (CodeEditorFragment) getFragmentManager().findFragmentById(R.id.modelText);
		outputText = (CodeEditorFragment) getFragmentManager().findFragmentById(R.id.outputText);
		
		codeText.setText("for (b in t_book.all) {\n\t b.a_title.println();\n}");
		modelText.setText("<?xml version='1.0'?>\n<library>\n\t<book title='book1'/>\n\t<book title='book2'/>\n</library>");
		outputText.setText("");
		
		createTab("Code", codeText);
		createTab("Model", modelText);
		outputTab = createTab("Output", outputText);
		
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.hide(modelText);
		ft.hide(outputText);
		ft.commit();
				
	}
	
	protected Tab createTab(String text, Fragment fragment) {
		Tab tab = getActionBar().newTab();
		tab.setText(text).setTabListener(new ActionBarTabListener(fragment));
		getActionBar().addTab(tab);		
		return tab;
	}
	
	class ActionBarTabListener implements TabListener {
		
		protected Fragment fragment = null;
		
		public ActionBarTabListener(Fragment fragment) {
			this.fragment = fragment;
		}
		
		@Override
		public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
			
		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			ft.show(fragment);
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			ft.hide(fragment);
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.layout.main_menu, menu);
		
		menu.findItem(R.id.action_run).setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem arg0) {
				try {
					EolModule module = new EolModule();
					output = "";
					module.parse(codeText.getText());
					
					if (module.getParseProblems().size() == 0) {
						
						PlainXmlModel model = new PlainXmlModel();
						model.setName("M");
						model.setXml(modelText.getText());
						model.load();
						
						module.getContext().setOutputStream(new PrintStream(new OutputStream() {
							
							@Override
							public void write(int c) throws IOException {
								output += (char) c;
							}
							
						}));
						
						module.getContext().getModelRepository().addModel(model);
						module.execute();
					}
					else {
						for (ParseProblem problem : module.getParseProblems()) {
							output += problem.toString() + "\n";
						}
					}
					outputText.setText(output);
				}
				catch (Exception ex) {
					outputText.setText(ex.getMessage());
				}
				outputTab.select();
				return true;
			}
		});
		
		return true;
	}
}
