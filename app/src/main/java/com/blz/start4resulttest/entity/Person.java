package com.blz.start4resulttest.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * ================================================
 * 作    者：bulingzhuang
 * 邮    箱：bulingzhuang@foxmail.com
 * 创建日期：2018/3/27
 * 描    述：
 * ================================================
 */

public class Person implements Parcelable {
    private String name;
    private String age;
    private int id;

    public Person(int id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    protected Person(Parcel in) {
        name = in.readString();
        age = in.readString();
        id = in.readInt();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(age);
        dest.writeInt(id);
    }
}
