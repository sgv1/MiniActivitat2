package com.example.surtidointentimpl;




import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	private Intent in;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		Button btn1 = (Button) findViewById(R.id.button1);
		Button btn2 = (Button) findViewById(R.id.button2);
		Button btn3 = (Button) findViewById(R.id.button3);
		Button btn4 = (Button) findViewById(R.id.button4);
		Button btn5 = (Button) findViewById(R.id.button5);
		Button btn6 = (Button) findViewById(R.id.button6);
		Button btn7 = (Button) findViewById(R.id.button7);
        Button btn8 = (Button) findViewById(R.id.button8);
        Button btn9 = (Button) findViewById(R.id.button9);

		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
		btn6.setOnClickListener(this);
		btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

	}

	@SuppressWarnings("deprecation")
	public void onClick (View v) {
		switch (v.getId()) {
		case R.id.button1:
		  Toast.makeText(this, getResources().getString(R.string.SLoc), Toast.LENGTH_LONG).show();
		  String lat = "41.60788";
		  String lon = "0.623333";
		  in = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:"+lat+","+lon));
		  startActivity(in);
		  break;
		case R.id.button2:
			Toast.makeText(this, getResources().getString(R.string.SLocD), Toast.LENGTH_LONG).show();
			in = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + "Carrer de Jaume II, 69, Lleida"));
			startActivity(in);
			break;
		case R.id.button3:
			Toast.makeText(this,getResources().getString(R.string.AWeb), Toast.LENGTH_LONG).show();
			in = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.urlEPS)));
			startActivity(in);
			break;
		case R.id.button4:
			Toast.makeText(this, getResources().getString(R.string.SGoogle), Toast.LENGTH_LONG).show();
			in = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/search?q=" + "escola politecnica superior UdL"));
			//in = new Intent(Intent.ACTION_WEB_SEARCH);
			//in.putExtra(SearchManager.QUERY, "escola politecnica superior UdL");
			startActivity(in);
			break;
		case R.id.button5:
			Toast.makeText(this, getResources().getString(R.string.MTlfn), Toast.LENGTH_LONG).show();
			in = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.tlfEPS) ));
			startActivity(in);
			break;
		case R.id.button6:
			Toast.makeText(this, getResources().getString(R.string.ACntcts), Toast.LENGTH_LONG).show();
			in = new Intent(Intent.ACTION_VIEW);
			in.setData(People.CONTENT_URI);
			startActivity(in);
			break;
		case R.id.button7:
			Toast.makeText(this, getResources().getString(R.string.CTlf), Toast.LENGTH_LONG).show();
			in = new Intent(Intent.ACTION_CALL, Uri.parse(getString(R.string.calltlf)));
			startActivity(in);
			break;
        case R.id.button8:
            Toast.makeText(this, getResources().getString(R.string.SSMS), Toast.LENGTH_LONG).show();
            in = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.smstlf)));
            startActivity(in);
            break;
            case R.id.button9:
                Intent gmail = new Intent(Intent.ACTION_VIEW);
                gmail.setClassName("com.google.android.gm","com.google.android.gm.ComposeActivityGmail");
                gmail.putExtra(Intent.EXTRA_EMAIL, new String[] { getString(R.string.email) });
                gmail.setData(Uri.parse(getString(R.string.email)));
                gmail.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.subject));
                gmail.setType("plain/text");
                gmail.putExtra(Intent.EXTRA_TEXT, getString(R.string.body));
                startActivity(gmail);
		}
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
