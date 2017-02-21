package javad.com.rest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button btn;
    HttpURLConnection client;
    URL url;
    BufferedReader bf;
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv1);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(),"Started",Toast.LENGTH_SHORT).show();
                api a = new api();
                a.execute("http://192.168.43.3:1234/api/values");
            }
        });
    }

    protected void MSG(String msg)
    {
        tv.append(msg + "\n");
    }


    private class api extends AsyncTask<String,String,String>
    {

        @Override
        protected void onPreExecute() {
            Toast.makeText(getApplicationContext(),"Started",Toast.LENGTH_SHORT).show();

        }

        @Override
        protected String doInBackground(String... strings) {
            HttpManager client = new HttpManager();
            return client.GetData(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            MSG(s);
        }
    }
}
