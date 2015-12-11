package com.ourincheon.databaseproject;

import java.util.ArrayList;

/**
 * Created by Youngdo on 2015-12-10.
 */
public class DataStorage {
    private static DataStorage m_instance;

    public static DataStorage getInstance() {
        if (m_instance == null) {
            m_instance = new DataStorage();
        }
        return m_instance;
    }

    private ArrayList<String> student_code = new ArrayList<String>();
    private ArrayList<String> MainList = new ArrayList<String>();
    private ArrayList<Integer> TotalGrade = new ArrayList<Integer>();


    public static DataStorage getM_instance(){
        return m_instance;
    }

    public static void setM_instance(DataStorage m_instance){
        DataStorage.m_instance = m_instance;
    }

    public ArrayList<String> getstudent_code(){
        return student_code;
    }

    public void setstudent_code(ArrayList<String> student_code){
        this.student_code = student_code;
    }

    public ArrayList<String> getMainList(){
        return MainList;
    }

    public void setMainList(ArrayList<String> MainList){
        this.MainList = MainList;
    }
    public ArrayList<Integer> getTotalGrade(){
        return TotalGrade;
    }

    public void setTotalGrade(ArrayList<Integer> TotalGrade){
        this.TotalGrade = TotalGrade;
    }
}
