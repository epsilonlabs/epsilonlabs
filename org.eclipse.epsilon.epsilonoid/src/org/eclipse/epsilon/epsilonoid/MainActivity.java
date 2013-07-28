package org.eclipse.epsilon.epsilonoid;

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
		exampleSet = new ExampleSet();
		exampleSet.load(getResources().openRawResource(R.raw.examples));
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
					
				Example example = new Example();
				example.setCode(codeText.getText().trim());
				example.setModel(modelText.getText().trim());
				example.execute();
				
				if (example.getCodeParseError() != null) {
					codeText.setError(example.getCodeParseError());
					codeTab.select();
				}
				else if (example.getModelLoadingError() != null) {
					modelText.setError(example.getModelLoadingError().substring(0, 200));
					modelTab.select();
				}
				else if (example.getRuntimeError() != null) {
					codeText.setError(example.getRuntimeError());
					codeTab.select();
				}
				else {
					outputText.setText(example.getOutput());
					outputTab.select();						
				}

				return true;
			}
		});
		
		return true;
	}
}
