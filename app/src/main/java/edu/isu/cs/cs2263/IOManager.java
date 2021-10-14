//Ekow Barlow
//Homework Project 2

package edu.isu.cs.cs2263;

import edu.isu.cs.cs2263.dto.Student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class IOManager {

    public List<Student> readData(String file) {

        Gson gson = new Gson();

        Type userListType = new TypeToken<ArrayList<Student>>(){}.getType();

        try {

            System.out.println("Reading JSON from a file");
            System.out.println("----------------------------");

            BufferedReader br = new BufferedReader(
                    new FileReader("data.json"));

            //convert the json string back to object
            List<Student> studentList = gson.fromJson(br, userListType);

            return studentList;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public void writeData(String file, List<Student> data) {

        Gson gson = new Gson();
        String json = gson.toJson(data);

        try {
            //write converted json data to a file named "CountryGSON.json"
            FileWriter writer = new FileWriter("data.json");
            writer.write(json);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}