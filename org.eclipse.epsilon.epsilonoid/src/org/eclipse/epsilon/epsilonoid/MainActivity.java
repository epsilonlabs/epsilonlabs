package org.eclipse.epsilon.epsilonoid;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;
import org.eclipse.epsilon.eol.EolModule;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class MainActivity extends Activity {
	
	protected CodeEditorFragment codeText = null;
	protected CodeEditorFragment modelText = null;
	protected CodeEditorFragment outputText = null;
	protected String output = "";
	protected Tab outputTab = null;
	protected Tab modelTab = null;
	protected Tab codeTab = null;
	protected ActionBarDrawerToggle actionBarDrawerToggle;
	protected ExampleSet exampleSet = null;
	protected ListView examplesList = null;
	protected DrawerLayout drawerLayout = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		//getActionBar().setSubtitle("Epsilon demo app");
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        
		getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		//getActionBar().setDisplayShowTitleEnabled(false);
		//getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		
		// Set up drawerLayout
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		actionBarDrawerToggle = new ActionBarDrawerToggle(this, 
				drawerLayout, R.drawable.ic_drawer, R.string.show, R.string.hide);
		drawerLayout.setDrawerListener(actionBarDrawerToggle);
		
		
		// Set up examplesList
		exampleSet = loadExampleSet();
		examplesList = (ListView) findViewById(R.id.examplesList);
		examplesList.setAdapter(new ArrayAdapter<Example>(this, android.R.layout.simple_list_item_1, exampleSet.getExamples()){
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				View view = super.getView(position, convertView, parent);
				TextView textView=(TextView) view.findViewById(android.R.id.text1);
	            textView.setTextColor(Color.WHITE);
				return view;
			}
		});
		examplesList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				examplesList.setItemChecked(position, true);
				drawerLayout.closeDrawer(examplesList);
				displayExample(exampleSet.getExamples().get(position));
			}
		});
		
		codeText = (CodeEditorFragment) getFragmentManager().findFragmentById(R.id.codeText);
		modelText = (CodeEditorFragment) getFragmentManager().findFragmentById(R.id.modelText);
		outputText = (CodeEditorFragment) getFragmentManager().findFragmentById(R.id.outputText);
		
		codeTab = createTab("Code", codeText);
		modelTab = createTab("Model", modelText);
		outputTab = createTab("Output", outputText);
		
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.hide(modelText);
		ft.hide(outputText);
		ft.commit();
		
		displayExample(exampleSet.getExamples().get(0));
				
	}
	
	protected void displayExample(Example example) {
		
		if (example.getModel().trim().length() == 0 && getActionBar().getTabCount() == 3) {
			getActionBar().removeTab(modelTab);
		}
		else if (example.getModel().trim().length() > 0 && getActionBar().getTabCount() == 2) {
			getActionBar().addTab(modelTab, 1);
		}
		
		codeText.setText(example.getCode().trim());
		modelText.setText(example.getModel().trim());
		outputText.setText("");
		codeTab.select();
		getActionBar().setSubtitle(example.getTitle());
	}
	
	protected ExampleSet loadExampleSet() {
		XStream xStream = new XStream(new DomDriver());
		xStream.alias("exampleset", ExampleSet.class);
		xStream.alias("example", Example.class);
		xStream.useAttributeFor(Example.class, "title");
		xStream.useAttributeFor(Example.class, "language");
		return (ExampleSet) xStream.fromXML(getResources().openRawResource(R.raw.examples));
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
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		actionBarDrawerToggle.syncState();
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		actionBarDrawerToggle.onConfigurationChanged(newConfig);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
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
						
						if (modelText.getText().trim().length() > 0) {
							PlainXmlModel model = new PlainXmlModel();
							model.setName("M");
							model.setXml(modelText.getText());
							
							try {
								model.load();
							}
							catch (Exception ex) {
								modelText.setError(ex.getMessage().substring(0, 200));
								modelTab.select();
								return true;
							}
							module.getContext().getModelRepository().addModel(model);
						}
						
						module.getContext().setOutputStream(new PrintStream(new OutputStream() {
							
							@Override
							public void write(int c) throws IOException {
								output += (char) c;
							}
							
						}));
						
						module.execute();
						outputText.setText(output);
						outputTab.select();
					}
					else {
						for (ParseProblem problem : module.getParseProblems()) {
							output += problem.toString() + "\n";
						}
						codeText.setError(output);
						codeTab.select();
					}
					
				}
				catch (Exception ex) {
					outputText.setText(ex.getMessage());
					outputTab.select();
				}
				
				return true;
			}
		});
		
		return true;
	}
}
