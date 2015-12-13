package com.ourincheon.databaseproject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Youngdo on 2015-11-02.
 */
public class Splash extends Activity {
    int identify = 0;
    int TotalGrade = 0;
    int temp = 0;
    DataStorage dataStorage = new DataStorage();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Intent intent = getIntent();
        identify = intent.getIntExtra("identify",0);
        MssqlTask1 mssqlTask = new MssqlTask1();
        mssqlTask.execute();
        //Log.e("data111", dataStorage.getInstance().getstudent_code().get(1));
        //Log.e("identify", DataStorage.getInstance().getstudent_code().get(identify));

    }
    public void initialize(){
        Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                finish();
            }
        };

        handler.sendEmptyMessageDelayed(0, 2000);
        Intent intent = new Intent(Splash.this, MainActivity.class);
        intent.putExtra("identify1", identify);
        intent.putExtra("grade",temp);
        startActivity(intent);

    }
    public class MssqlTask1 extends AsyncTask<String, Integer, ArrayList<String>> {

        @Override
        protected ArrayList<String> doInBackground(String... params) {
            Connection conn;
            ArrayList<String> list = new ArrayList<String>();
            ArrayList<String> sem_name = new ArrayList<String>();
            ArrayList<Integer> grade = new ArrayList<Integer>();
            ArrayList<String> list11 = new ArrayList<String>();
            ArrayList<String> list12 = new ArrayList<String>();
            ArrayList<String> list21 = new ArrayList<String>();
            ArrayList<String> list22 = new ArrayList<String>();
            ArrayList<String> list31 = new ArrayList<String>();

            Log.e("branch3", "branch3");
            try {
                Log.e("subtest",DataStorage.getInstance().getstudent_code().get(identify));
                int i = 0;
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
                conn = DriverManager.getConnection("jdbc:jtds:sqlserver://117.16.244.162/201101658", "201101658", "dnflwlq5");
                Statement stmt = conn.createStatement();
                ResultSet reset = stmt.executeQuery("select * from NEW_semester where stu_code= '"+ DataStorage.getInstance().getstudent_code().get(identify) +"' and sem_sem = '3-2'");
                Log.e("test", "success");
                //ResultSet reset1 = stmt.executeQuery("select * from NEW_semester where stu_code= '"+ DataStorage.getInstance().getstudent_code().get(identify) +"'");

                while(reset.next()){
                    Log.e("subjectname", reset.getString(5));
                    sem_name.add(i, reset.getString(5));
                    i++;
                }
                if(sem_name.size() >0){
                    dataStorage.getInstance().setMainList(sem_name);
                    //dataStorage.getInstance().setTotalGrade(grade);
                    Log.e("data1", "ㅗㅗㅗㅗㅗㅗ");
                }
//                for(int j = 0; j<grade.size(); j++){
//                    temp=temp + dataStorage.getInstance().getTotalGrade().get(i);
//                }
//                temp = temp/grade.size();
                i = 0;
                reset = stmt.executeQuery("select * from NEW_semester where stu_code= '" + DataStorage.getInstance().getstudent_code().get(identify) + "'");
                while(reset.next()){
                    try {
                        grade.add(i, reset.getInt(3));
                    }catch (NullPointerException e){
                        Log.e("null", "null발생");
                    }
                    i++;
                }
                /*5/5 + 6/6 + 7/7*/
                if(grade.size() >0){
                    dataStorage.getInstance().setTotalGrade(grade);
                    Log.e("branch4", "잘 넣어졌다.");
                    //dataStorage.getInstance().setTotalGrade(grade);
                }
                for(int j = 0; j<grade.size(); j++){
                    temp=temp + dataStorage.getInstance().getTotalGrade().get(j);
                }
                Log.e("branch5", String.valueOf(temp));
                temp = (temp/(grade.size()-5));
                Log.e("branch5", String.valueOf(temp));
                Log.e("branch5", String.valueOf(grade.size()));
                reset = stmt.executeQuery("select * from NEW_semester where stu_code= '" + DataStorage.getInstance().getstudent_code().get(identify) +"' and sem_sem = '1-1'");
                i = 0;
                while(reset.next()){
                    try {
                        list11.add(i, reset.getString(5) + " " + reset.getString(3));
                    }catch (NullPointerException e){
                        Log.e("null", "null발생");
                    }
                    i++;
                }
                if(grade.size() >0){
                    dataStorage.getInstance().setList11(list11);

                    Log.e("branch6", dataStorage.getInstance().getList11().get(1));
                    //dataStorage.getInstance().setTotalGrade(grade);
                }
                reset = stmt.executeQuery("select * from NEW_semester where stu_code= '" + DataStorage.getInstance().getstudent_code().get(identify) +"' and sem_sem = '1-2'");
                i = 0;
                while(reset.next()){
                    try {
                        list12.add(i, reset.getString(5)+ " " + reset.getString(3));
                    }catch (NullPointerException e){
                        Log.e("null", "null발생");
                    }
                    i++;
                }
                if(grade.size() >0){
                    dataStorage.getInstance().setList12(list12);
                    Log.e("branch7", "잘 넣어졌다.");
                    //dataStorage.getInstance().setTotalGrade(grade);
                }
                reset = stmt.executeQuery("select * from NEW_semester where stu_code= '" + DataStorage.getInstance().getstudent_code().get(identify) +"' and sem_sem = '2-1'");
                i = 0;
                while(reset.next()){
                    try {
                        list21.add(i, reset.getString(5)+ " " + reset.getString(3));
                    }catch (NullPointerException e){
                        Log.e("null", "null발생");
                    }
                    i++;
                }
                if(grade.size() >0){
                    dataStorage.getInstance().setList21(list21);
                    Log.e("branch8", "잘 넣어졌다.");
                    //dataStorage.getInstance().setTotalGrade(grade);
                }
                reset = stmt.executeQuery("select * from NEW_semester where stu_code= '" + DataStorage.getInstance().getstudent_code().get(identify) +"' and sem_sem = '2-2'");
                i = 0;
                while(reset.next()){
                    try {
                        list22.add(i, reset.getString(5)+ " " + reset.getString(3));
                    }catch (NullPointerException e){
                        Log.e("null", "null발생");
                    }
                    i++;
                }
                if(grade.size() >0){
                    dataStorage.getInstance().setList22(list22);
                    Log.e("branch9", "잘 넣어졌다.");
                    //dataStorage.getInstance().setTotalGrade(grade);
                }
                reset = stmt.executeQuery("select * from NEW_semester where stu_code= '" + DataStorage.getInstance().getstudent_code().get(identify) +"' and sem_sem = '3-1'");
                i = 0;
                while(reset.next()){
                    try {
                        list31.add(i, reset.getString(5)+ " " + reset.getString(3));
                    }catch (NullPointerException e){
                        Log.e("null", "null발생");
                    }
                    i++;
                }
                if(grade.size() >0){
                    dataStorage.getInstance().setList31(list31);
                    Log.e("branch10", "잘 넣어졌다.");
                    //dataStorage.getInstance().setTotalGrade(grade);
                }
                reset = stmt.executeQuery("select * from sem_infor where 3-1'");
                i = 0;
                while(reset.next()){
                    try {
                        list31.add(i, reset.getString(5)+ " " + reset.getString(3));
                    }catch (NullPointerException e){
                        Log.e("null", "null발생");
                    }
                    i++;
                }
                if(grade.size() >0){
                    dataStorage.getInstance().setList31(list31);
                    Log.e("branch10", "잘 넣어졌다.");
                    //dataStorage.getInstance().setTotalGrade(grade);
                }

                reset.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                Log.e("test1", "fail");

            }
            return list;
        }

        @Override
        protected void onPostExecute(ArrayList<String> s) {
            super.onPostExecute(s);
            initialize();
        }
    }

}
