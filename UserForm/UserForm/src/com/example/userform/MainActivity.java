package com.example.userform;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemSelectedListener, OnClickListener {
	
	EditText idno, name;
	Spinner course;
	RadioGroup rg;
	Button ok, cancel;
	
	String selectedCourse;
	String selectedSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        idno=(EditText)this.findViewById(R.id.editText1);
        name=(EditText)this.findViewById(R.id.editText2);
        course=(Spinner)this.findViewById(R.id.spinner1);
        rg=(RadioGroup)this.findViewById(R.id.radioGroup1);
        ok=(Button)this.findViewById(R.id.button1);
        cancel=(Button)this.findViewById(R.id.button2);
        
        course.setOnItemSelectedListener(this);
        ok.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
		selectedCourse=course.getItemAtPosition(arg2).toString();
		
	}


	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		int btnID=arg0.getId();
		switch(btnID){
		case R.id.button1:
			String idnum=idno.getText().toString();
			String nm=name.getText().toString();
			
			int id=rg.getCheckedRadioButtonId();
			RadioButton btn=(RadioButton)this.findViewById(id);
			selectedSex=btn.getText().toString();
			
			String m=idnum+"\n"+nm+"\n"+selectedCourse+"\n"+selectedSex;
			AlertDialog.Builder builder=new AlertDialog.Builder(this);
			builder.setTitle("Student Information");
			builder.setMessage(m);
			builder.setNeutralButton("Okey", null);
			
			AlertDialog dialog=builder.create();
			dialog.show();
			//Toast.makeText(this, m, Toast.LENGTH_SHORT).show();
		break;
		}
		
	}
    
}
