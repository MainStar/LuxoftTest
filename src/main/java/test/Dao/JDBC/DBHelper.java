package test.Dao.JDBC;

import java.sql.*;
import java.util.Map;

public class DBHelper {

    private int id = 3;
    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;
    public static PreparedStatement preparedStat;

    public static void connectToDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("JDBC:mysql://localhost:3306/test_lux", "root", "root");
        System.out.println("Data base is connected!");
    }

    public void writeFile(String fileName) throws SQLException {
        System.out.println(id);
        preparedStat = connection.prepareStatement("insert into files (name) VALUES (?)");
        preparedStat.setString(1, fileName);
        preparedStat.executeUpdate();
        id++;
    }

    public int getFileId(String name) throws SQLException {
        int id = 0;
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT id FROM files WHERE name");
        while (resultSet.next()){
            if (resultSet.getString(2).equals(name)) {
                id = resultSet.getInt("id");
            }
            System.out.println(id);
        }
        return id;
    }

    public void writeLines(Map<String, String[]> map, String name) throws SQLException {
        preparedStat = connection.prepareStatement("insert into lines (id, file_id, line, longest_letter, mid_letter, shortest_letter) VALUE (?, ?, ?, ?, ?, ?)");
        int id = getFileId(name);

        for (Map.Entry<String, String[]> el : map.entrySet()){
            preparedStat.setInt(1, 1);
            preparedStat.setInt(2, id);
            preparedStat.setString(3, el.getKey());
            String[] mass = el.getValue();
            int z = 4;
            for (int i = 0; i < mass.length; i++){
                preparedStat.setString(z, mass[i]);
                z++;
            }
        }
        preparedStat.executeUpdate();
    }

    public void close() throws SQLException {
        resultSet.close();
        statement.close();
        connection.close();
    }
}
