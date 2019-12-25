package com.example.faradarsfragment;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Student implements Parcelable {
    public String id;
    public String name;
    public int score;

    public Student(String id, String name, int score){
        this.id=id;
        this.name=name;
        this.score=score;
    }

    public static List<Student> sampleStudent(){
        ArrayList<Student> list=new ArrayList<>();
        list.add(new Student("1234","john snow",90));
        list.add(new Student("2563","tannaz shr",84));
        list.add(new Student("6952","tara shir",34));
        list.add(new Student("8414","felani mohamadi",86));
        list.add(new Student("9637","nila habibi",25));
        list.add(new Student("1254","maryam felani",85));
        list.add(new Student("3265","samira balmaki",46));
        list.add(new Student("9731","mahya naseri",36));
        list.add(new Student("8264","tiana shirzadi",96));
        list.add(new Student("7643", "Jose Lorenzo", 84));
        list.add(new Student("8733", "Andre Gomez", 47));
        list.add(new Student("3421", "John Schols", 94));
        list.add(new Student("1245", "Jose Oscar", 84));
        list.add(new Student("6540", "Andre Alvarez", 47));
        list.add(new Student("8502", "Pepe Vasquez", 94));
        list.add(new Student("7315", "Hamid Salah", 84));
        list.add(new Student("6573", "Ahmad Mobarak", 47));
        list.add(new Student("1762", "John Luck", 94));
        list.add(new Student("1093", "Alexander ", 84));
        list.add(new Student("8794", "Andrea", 47));
        return list;
    }
    @Override
    public String toString() {
        return this.name;
    }

    //parceleble methods
    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeInt(score);
    }
    public Student(Parcel parcel){
        this.id=parcel.readString();
        this.name=parcel.readString();
        this.score=parcel.readInt();
    }


    public static Creator<Student> CREATOR = new Creator() {
        @Override
        public Object createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Object[] newArray(int size) {
            return new Student[size];
        }
    };
}
