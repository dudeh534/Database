package com.ourincheon.databaseproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;

/**
 * Created by Youngdo on 2015-11-02.
 */
public class SemesterFragment extends android.support.v4.app.Fragment {
    private PagerSlidingTabStrip tabs;
    private ViewPager pager;
    private android.support.v4.view.PagerAdapter adapter;
    private static final String ARG_POSITION = "position";
    private int positions;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter1;
    DataStorage dataStorage = new DataStorage();

    private ArrayList<ArrayList<String>> data;
    private ArrayList<String> list11;
    private ArrayList<String> list12;
    private ArrayList<String> list21;
    private ArrayList<String> list22;
    private ArrayList<String> list31;
    public static SemesterFragment newInstanse(int position){
        SemesterFragment f = new SemesterFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }
    //       Layout을 inflater을하여 View작업을 하는 곳.

//asdfasdfasdf
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        positions = getArguments().getInt(ARG_POSITION);
        arrayList = new ArrayList<String>();
        list11 = new ArrayList<String>();
        list12 = new ArrayList<String>();
        list21 = new ArrayList<String>();
        list22 = new ArrayList<String>();
        list31 = new ArrayList<String>();
        data = new ArrayList<ArrayList<String>>();

        arrayList.add(dataStorage.getInstance().getMainList().get(0));
        arrayList.add(dataStorage.getInstance().getMainList().get(1));
        arrayList.add(dataStorage.getInstance().getMainList().get(2));
        arrayList.add(dataStorage.getInstance().getMainList().get(3));
        arrayList.add(dataStorage.getInstance().getMainList().get(4));
        arrayList.add(dataStorage.getInstance().getMainList().get(5));
        arrayList.add(dataStorage.getInstance().getMainList().get(6));
        adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arrayList);


        list11.add(dataStorage.getInstance().getList11().get(0));
        list11.add(dataStorage.getInstance().getList11().get(1));
        list11.add(dataStorage.getInstance().getList11().get(2));
        list11.add(dataStorage.getInstance().getList11().get(3));
        list11.add(dataStorage.getInstance().getList11().get(4));
        list11.add(dataStorage.getInstance().getList11().get(5));
            list12.add(dataStorage.getInstance().getList12().get(0));
        list12.add(dataStorage.getInstance().getList12().get(1));
        list12.add(dataStorage.getInstance().getList12().get(2));
        list12.add(dataStorage.getInstance().getList12().get(3));
        list12.add(dataStorage.getInstance().getList12().get(4));
        list12.add(dataStorage.getInstance().getList12().get(5));

            list21.add(dataStorage.getInstance().getList21().get(0));
        list21.add(dataStorage.getInstance().getList21().get(1));
        list21.add(dataStorage.getInstance().getList21().get(2));
        list21.add(dataStorage.getInstance().getList21().get(3));
        list21.add(dataStorage.getInstance().getList21().get(4));
        list21.add(dataStorage.getInstance().getList21().get(5));
            list22.add(dataStorage.getInstance().getList22().get(0));
        list22.add(dataStorage.getInstance().getList22().get(1));
        list22.add(dataStorage.getInstance().getList22().get(2));
        list22.add(dataStorage.getInstance().getList22().get(3));
        list22.add(dataStorage.getInstance().getList22().get(4));
        list22.add(dataStorage.getInstance().getList22().get(5));

            list31.add(dataStorage.getInstance().getList31().get(0));
        list31.add(dataStorage.getInstance().getList31().get(1));
        list31.add(dataStorage.getInstance().getList31().get(2));
        list31.add(dataStorage.getInstance().getList31().get(3));
        list31.add(dataStorage.getInstance().getList31().get(4));
        list31.add(dataStorage.getInstance().getList31().get(5));
        list31.add(dataStorage.getInstance().getList31().get(6));

        data.add(list11);
        data.add(list12);
        data.add(list21);
        data.add(list22);
        data.add(list31);

//포지션 0~4까지에 따라서 1-1~3-1까지 넣으면됨
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

    /*Fragement에서 리소스의 뷰들을 인플레이션하는 방법은 2가지가 있다.
     1.View rootView를 선언해서 이 안에 해당 프레그먼트의 리소스파일을 인플레이션해서
      그 안에 있는 뷰들을 rootView.findViewById이러한 형식으로 인플레이션 하던지
     2. getView().findViewById를 통해서 인플레이션 하던지*/
//   Fragment에서는 this대신에 getActivity를 통해 해당 Activity를 넘겨준다.
        adapter = new PagerAdapter(getActivity().getSupportFragmentManager());
        final View rootView;
        rootView = inflater.inflate(R.layout.list, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.semesterList);
        List1 list1 = new List1(getActivity(),arrayList);
        switch (positions){
            case 0:
                adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data.get(0));
                break;
            case 1:
                adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data.get(1));
                break;
            case 2:
                adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data.get(2));
                break;
            case 3:
                adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data.get(3));
                break;
            case 4:
                adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data.get(4));
                break;
            default:
                break;

        }
        listView.setAdapter(adapter1);
        return rootView;


    }

    public class List1 extends ArrayAdapter<String>{
        private final Activity context;

        private ArrayList<String> items;

        public List1(Activity context,ArrayList<String> arrlist)
        {
            super(context, R.layout.itemlist,arrlist);
            this.items = arrlist;
            this.context = context;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.itemlist,null, true);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
            TextView title = (TextView) rowView.findViewById(R.id.title);
            TextView manufac = (TextView) rowView.findViewById(R.id.manufac);
            TextView price = (TextView) rowView.findViewById(R.id.price);
            title.setTextSize(30);
            title.setText("ㅗㅗ"+position);
            manufac.setTextSize(10);
            manufac.setText("ㅗㅗ"+position);


            return rowView;
        }
    }


}
