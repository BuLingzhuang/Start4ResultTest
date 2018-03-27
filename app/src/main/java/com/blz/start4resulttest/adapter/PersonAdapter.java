package com.blz.start4resulttest.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.blz.start4resulttest.R;
import com.blz.start4resulttest.entity.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

/**
 * ================================================
 * 作    者：bulingzhuang
 * 邮    箱：bulingzhuang@foxmail.com
 * 创建日期：2018/3/27
 * 描    述：
 * ================================================
 */

public class PersonAdapter extends BaseAdapter {
    private Context mContext;
    private CallBack mListener;
    private List<Person> mDataList;

    public interface CallBack {
        void start2Edit(Person person);
    }

    public PersonAdapter(Context context, CallBack listener) {
        mContext = context;
        mListener = listener;
        mDataList = new ArrayList<>();
    }

    public void addAll(Collection<? extends Person> collection) {
        mDataList.clear();
        mDataList.addAll(collection);
        notifyDataSetChanged();
    }

    public void edit(Person editData) {
        for (Person person : mDataList) {
            if (person.getId() == editData.getId()) {
                person.setName(editData.getName());
                person.setAge(editData.getAge());
                notifyDataSetChanged();
                break;
            }
        }
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_person, parent, false);
            convertView.setTag(new ViewHolder(convertView));
        }
        Person item = mDataList.get(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.tvName.setText(String.format(Locale.CHINESE,"姓名：%s",item.getName()));
        holder.tvAge.setText(String.format(Locale.CHINESE,"年龄：%s",item.getAge()));
        holder.btnEdit.setTag(item);
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    Person person = (Person) v.getTag();
                    mListener.start2Edit(person);
                }
            }
        });
        return convertView;
    }

    class ViewHolder {
        private TextView tvName;
        private TextView tvAge;
        private Button btnEdit;

        ViewHolder(View view) {
            tvName = view.findViewById(R.id.tv_name);
            tvAge = view.findViewById(R.id.tv_age);
            btnEdit = view.findViewById(R.id.btn_edit);
        }
    }
}
