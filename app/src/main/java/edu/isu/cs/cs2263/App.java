package edu.isu.cs.cs2263;
//Ekow Barlow
//Homework Project 2

import edu.isu.cs.cs2263.dto.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    private List<edu.isu.cs.cs2263.dto.Student> studentList;
    public List<String> firstList = new ArrayList<>();
    public List<String> secondList = new ArrayList<>();

    public List<edu.isu.cs.cs2263.dto.Student> getStudentList() {
        if(null == studentList)
            studentList = new ArrayList<>();
        return studentList;
    }

    public List<String> getFirstList() {
        return firstList;
    }

    public List<String> getSecondList() {
        return secondList;
    }

    public void setFirstList(List<String> firstList) {
        this.firstList = firstList;
    }

    public void setSecondList(List<String> secondList) {
        this.secondList = secondList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
        List<String> strings = this.studentList.stream().map(student -> {
            return student.getFirstName() + " " + student.getLastname();
        }).collect(Collectors.toList());
        setFirstList(strings);
    }

    public static void main(String[] args) {
        //SpringApplication.run(App.class, args);
        launch(args);
    }

    private static void launch(String[] args) {
    }


    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Load");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                IOManager ioManager = new IOManager();
                List<Student> studentList = ioManager.readData("data.json");
                setStudentList(studentList);
                System.out.println("Hello World!");

            }
        });

        ObservableList<String> names = FXCollections.observableArrayList(this.firstList);
        ListView<String> listView = new ListView<String>(names);
        listView.setMaxSize(150, 160);
        String result  = listView.getSelectionModel().getSelectedItems().get(0);


        Student st = null;
        for(int i=0; i< getStudentList().size(); i++) {
            if(getStudentList().get(i).getFirstName() + " " +  getStudentList().get(i).getLastname() == result) {
                st = getStudentList().get(i);
            }
        }

        List<String>  rs = new ArrayList<>();
        if(null != st) {
            rs = st.getCourseList().stream().map(course -> {
                return course.getSubject() + " " + course.getNumber() + " " + course.getTitle();
            }).collect(Collectors.toList());
        }

        ObservableList<String> other = FXCollections.observableArrayList(rs);
        ListView<String> otherView = new ListView<String>(other);
        listView.setMaxSize(150, 160);



        VBox layout = new VBox(10);
        layout.setPadding(new Insets(5, 5, 5, 50));
        layout.getChildren().addAll( listView, otherView, btn);
        layout.setStyle("-fx-background-color: BEIGE");

        StackPane root = new StackPane();
        primaryStage.setTitle("Course View");
        primaryStage.setScene(new Scene(layout, 500, 500));

        primaryStage.show();
    }

}
