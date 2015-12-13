package com.ourincheon.databaseproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    Button timetable;
    DataStorage dataStorage = new DataStorage();
    EditText name, grade;
    Button bt;
    String name1, name2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        final int grade1 = intent.getIntExtra("grade",0);
        arrayList = new ArrayList<String>();
        arrayList.add(dataStorage.getInstance().getMainList().get(0));
        arrayList.add(dataStorage.getInstance().getMainList().get(1));
        arrayList.add(dataStorage.getInstance().getMainList().get(2));
        arrayList.add(dataStorage.getInstance().getMainList().get(3));
        arrayList.add(dataStorage.getInstance().getMainList().get(4));
        arrayList.add(dataStorage.getInstance().getMainList().get(5));
        arrayList.add(dataStorage.getInstance().getMainList().get(6));
        try {
            for (int j = 0; j < 7; j++) {
                if (dataStorage.getInstance().getchgrade().get(j).equals(dataStorage.getInstance().getMainList().get(j))) {
                    arrayList.set(j, dataStorage.getInstance().getchgrade().get(j) + " (" + dataStorage.getInstance().getchgrade1().get(j) + ")");

                }
            }
        }catch (Exception e){
            Log.e("null이 발생","null이 더블");
        }


        TextView TVgrade = (TextView) findViewById(R.id.textView3);
        TVgrade.setText(" " + String.valueOf(grade1 + 1.9));

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        name = (EditText) findViewById(R.id.editText3);
        grade = (EditText) findViewById(R.id.editText4);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        bt = (Button) findViewById(R.id.button2);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 7; i++) {
                    if (name.getText().toString().equals(dataStorage.getInstance().getMainList().get(i))) {
                        name1 = name.getText().toString();
                        name2 = grade.getText().toString();
                        arrayList.set(i, dataStorage.getInstance().getMainList().get(i) + " (" + grade.getText().toString() + ")");
                        listView.setAdapter(adapter);
                        insert insert = new insert();
                        insert.execute();
                    }
                }
            }
        });
        timetable = (Button) findViewById(R.id.button3);
        timetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Semester.class));
            }
        });

}

    public class insert extends AsyncTask<String, Integer, ArrayList<String>> {

        @Override
        protected ArrayList<String> doInBackground(String... params) {
            ArrayList<String> grade = new ArrayList<String>();
            ArrayList<String> grade1 = new ArrayList<String>();
            Connection conn;
            ArrayList<String> list = new ArrayList<String>();
            try {
                int i = 0;
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
                conn = DriverManager.getConnection("jdbc:jtds:sqlserver://117.16.244.162/201101658", "201101658", "dnflwlq5");
                Statement stmt = conn.createStatement();

                stmt.executeUpdate("INSERT INTO goal_grade3 VALUES ('"+name1+"', "+name2+")");
                ResultSet reset = stmt.executeQuery("select * from goal_grade3");
                while(reset.next()){
                    grade.add(i, reset.getString(1) );
                    grade1.add(i,reset.getString(2));
                    i++;
                }
                if(grade.size() >0){
                    dataStorage.getInstance().setchgrade(grade);
                    dataStorage.getInstance().setchgrade1(grade1);
                }

                reset.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                Log.e("fail", "fail");
                //dataStorage.getM_instance().setstudent_code(Student_code);

            }
            return list;
        }

        @Override
        protected void onPostExecute(ArrayList<String> s) {
            super.onPostExecute(s);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
