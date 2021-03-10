import Beans.Student;

import java.sql.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Model {

    private static final String url = "jdbc:mysql://localhost:3306/cities";
    private static final String name = "root";
    private static final String password = "root";


    public List<Student> getStudents(){
        List<Student> list = new CopyOnWriteArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, this.name, password);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from students");
            while (resultSet.next()) {
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);
                int id = resultSet.getInt(1);
                list.add(new Student(name, age, id));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public void setStudent(String name, String age){
        try (Connection connection = DriverManager.getConnection(url, this.name, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into students (name, age) values (? , ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, Integer.parseInt(age));
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteStudent(int id){
        try (Connection connection = DriverManager.getConnection(url, this.name, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from students where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateStudent(int id , String name){
        try (Connection connection = DriverManager.getConnection(url, this.name, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement("update students set name = ? where id = ? ");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Student getStudent(int id){
        try (Connection connection = DriverManager.getConnection(url, this.name, password);
             Statement statement = connection.createStatement()) {
                 PreparedStatement preparedStatement = connection.prepareStatement("select * from students where id = ?");
                 preparedStatement.setInt(1, id);
                 ResultSet resultSet = preparedStatement.executeQuery();
                 while (resultSet.next()){
                     String stdName = resultSet.getString(2);
                     int stdAge = resultSet.getInt(3);
                     Student student = new Student(stdName, stdAge, id);
                     return student;
                 }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
