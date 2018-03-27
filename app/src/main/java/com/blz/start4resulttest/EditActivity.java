package com.blz.start4resulttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.blz.start4resulttest.entity.Person;

public class EditActivity extends AppCompatActivity {

    private EditText mEtAge;
    private EditText mEtName;
    private Person mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        init();
    }

    private void init() {
        mEtName = findViewById(R.id.et_name);
        mEtAge = findViewById(R.id.et_age);
        Intent intent = getIntent();
        mData = intent.getParcelableExtra("editData");
        mEtName.setText(mData.getName());
        mEtAge.setText(mData.getAge());
        Button btnSave = findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mData.setName(mEtName.getText().toString());
                mData.setAge(mEtAge.getText().toString());
                Intent resultIntent = new Intent();
                resultIntent.putExtra("editResultData", mData);
                setResult(777, resultIntent);
                finish();
            }
        });
    }
}
