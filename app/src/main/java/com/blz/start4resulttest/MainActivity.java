package com.blz.start4resulttest;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.blz.start4resulttest.adapter.PersonAdapter;
import com.blz.start4resulttest.entity.Person;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PersonAdapter.CallBack {

    private PersonAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initData();
    }

    private void init() {
        ListView lvContent = findViewById(R.id.lv_content);
        mAdapter = new PersonAdapter(this, this);
        lvContent.setAdapter(mAdapter);
    }

    private void initData() {
        List<Person> personList = Arrays.asList(new Person(1, "张三", "23"),
                new Person(2, "李四", "12"),
                new Person(3, "王五", "66"));
        mAdapter.addAll(personList);
    }

    @Override
    public void start2Edit(Person person) {
        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra("editData", person);
        startActivityForResult(intent,233);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 233&& resultCode == 777){
            Person resultData = data.getParcelableExtra("editResultData");
            if (resultData != null) {
                mAdapter.edit(resultData);
            }
        }
    }
}
