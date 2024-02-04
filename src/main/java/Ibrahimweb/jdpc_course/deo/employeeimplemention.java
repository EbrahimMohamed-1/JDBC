package Ibrahimweb.jdpc_course.deo;

import Ibrahimweb.jdpc_course.ustils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class employeeimplemention implements employeedeo {


    @Override
    public List<employee> findAll() {
        return null;
    }

    @Override
    public employee findAllByID(int id) {
        return null;
    }

    @Override
    public void save(employee e) {
        Connection con = DBconnection.getConnection();
        if (con==null){
            System.out.println("connection field");
            return;
        }
        if (e.getId()==0){ //create
            String query = "INSERT INTO employee (name, gender, birthday, salary) VALUES (?, ?, ?, ?)";
            try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
                System.out.println("employee '"+ e.getName()+ "' added successfully");

                preparedStatement.setString(1, e.getName());
                preparedStatement.setBoolean(2,e.isGender());
                // if we used util.Date instead sql.Date in class employee we should convert it to sql
                //preparedStatement.setDate(3, Utils.GetDate(e.getBirthday()));
                preparedStatement.setDate(3, new java.sql.Date(e.getBirthday().getTime()));
                preparedStatement.setDouble(4, e.getSalary());
                preparedStatement.executeUpdate();
                //preparedStatement.close();
            } catch (SQLException se){
                se.printStackTrace();
            }
            finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        else{ //update
            String query = "UPDATE employee SET name=?, gender=?, birthday=?, salary=? WHERE id=?";
            try(PreparedStatement preparedStatement = con.prepareStatement(query)) {
                System.out.println("employee '"+ e.getName()+ "' updated successfully");
                preparedStatement.setString(1, e.getName());
                preparedStatement.setBoolean(2,e.isGender());
                // if we used util.Date instead sql.Date in class employee we should convert it to sql
                //preparedStatement.setDate(3, Utils.GetDate(e.getBirthday()));
                preparedStatement.setDate(3, new java.sql.Date(e.getBirthday().getTime()));
                preparedStatement.setDouble(4, e.getSalary());
                preparedStatement.setInt(5,e.getId());
                preparedStatement.executeUpdate();
                //preparedStatement.close();
            } catch (SQLException se){
                se.printStackTrace();
            }
            finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }


        }

    }

    @Override
    public void deleteByID(int id) {

    }
}
