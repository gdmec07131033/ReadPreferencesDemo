package cn.edu.gdmec.s07131033.readpreferencesdemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText myed;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myed = (EditText) findViewById(R.id.editText1);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void READ(View v)
    {
    	Context myContext = null;
    	try {
			myContext = createPackageContext("cn.edu.gdmec.s07131033.sharedpreferencedemo", Context.CONTEXT_IGNORE_SECURITY);
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	SharedPreferences myPre=myContext.getSharedPreferences("personal", Context.MODE_WORLD_READABLE+Context.MODE_WORLD_WRITEABLE);
    	String myName = myPre.getString("name", "MMM");
    	myed.setText(myName);
    }
}
