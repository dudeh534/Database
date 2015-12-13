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
    private ArrayList<String> List11 = new ArrayList<String>();
    private ArrayList<String> List12 = new ArrayList<String>();
    private ArrayList<String> List21 = new ArrayList<String>();
    private ArrayList<String> List22 = new ArrayList<String>();
    private ArrayList<String> List31 = new ArrayList<String>();
    private ArrayList<String> chgrade = new ArrayList<String>();
    private ArrayList<String> chgrade1 = new ArrayList<String>();
    private ArrayList<String> TEST = new ArrayList<String>();

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

    public ArrayList<String> getList11(){
        return List11;
    }
    public void setList11(ArrayList<String> List11){
        this.List11 = List11;
    }
    public ArrayList<String> getList12(){
        return List12;
    }
    public void setList12(ArrayList<String> List12){
        this.List12 = List12;
    }
    public ArrayList<String> getList21(){
        return List21;
    }
    public void setList21(ArrayList<String> List21){
        this.List21 = List21;
    }
    public ArrayList<String> getList22(){
        return List22;
    }
    public void setList22(ArrayList<String> List22){
        this.List22 = List22;
    }
    public ArrayList<String> getList31(){
        return List31;
    }
    public void setList31(ArrayList<String> List31){
        this.List31 = List31;
    }
    public ArrayList<String> getchgrade(){
        return chgrade;
    }
    public void setchgrade(ArrayList<String> chgrade){
        this.chgrade = chgrade;
    }
    public ArrayList<String> getchgrade1(){
        return chgrade1;
    }
    public void setchgrade1(ArrayList<String> chgrade1){
        this.chgrade1 = chgrade1;
    }

    public ArrayList<String> getTEST(){
        return TEST;
    }
    public void setTEST(ArrayList<String> TEST){
        this.TEST = TEST;
    }


}
