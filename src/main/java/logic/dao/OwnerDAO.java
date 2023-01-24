package logic.dao;

import logic.model.Owner;
import logic.model.User;
import logic.other.SingletonConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OwnerDAOimpl implements OwnerDAO {

    private static final String OWNER = "owner";

    public OwnerDAOimpl() {
    }


    public void insertOwner(User owner) {
        Connection connection = SingletonConnector.getInstance().getConnection();
        try (Statement statement = connection.createStatement()) {

            Queries.insertIntoUser(statement, owner.getEmail(), owner.getPasswd(), OWNER);
            Queries.insertIntoOwner(statement, owner.getName(), owner.getSurname(), owner.getEmail());

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
   /* public Owner createOwner(ResultSet rs){



    }*/

}