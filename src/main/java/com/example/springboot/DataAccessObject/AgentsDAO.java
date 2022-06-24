package com.example.springboot.DataAccessObject;

import com.example.springboot.domain.Agents;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AgentsDAO {

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.user}")
    private String dbUserName;

    @Value("${db.password}")
    private String dbPassword;
    public List<Agents> getAgents() throws SQLException, ClassNotFoundException {
        Connection con = ConnectionHelper.getMSSQLConnection(dbUrl,dbUserName,dbPassword);
        Statement stmt = con.createStatement();
        System.out.println("Got the statement:" + stmt);
        ResultSet rs = stmt.executeQuery("SELECT * from AGENTS");
        System.out.println("Got the result set");
        List<Agents> agents = new ArrayList();
        while (rs.next()) {
            Agents agent = new Agents();
            agent.setCode(rs.getString(1));
            agent.setName(rs.getString(2));
            agent.setLocation(rs.getString(3));
            agent.setCommission(rs.getDouble(4));
            agents.add(agent);
        }
        return agents;
    }

    public Integer insertAgents(String code, String name, String location, Double commission) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO AGENTS (AGENT_CODE, AGENT_NAME, WORKING_AREA, COMMISSION) " +
                "Values (?, ?, ?, ?)";
        Connection con = ConnectionHelper.getMSSQLConnection(dbUrl,dbUserName,dbPassword);
        Integer result=0;
        try (PreparedStatement insert = con.prepareStatement(sql)) {
            System.out.println("Updating Agents");

            insert.setString(1, code);
            insert.setString(2, name);
            insert.setString(3, location);
            insert.setDouble(4, commission);
            result=insert.executeUpdate();
        }
        return result;
    }

    public Integer deleteAgents(String code) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Agents WHERE AGENT_CODE=?";
        Connection con = ConnectionHelper.getMSSQLConnection(dbUrl,dbUserName,dbPassword);
        Integer result=0;
        try (PreparedStatement delete = con.prepareStatement(sql)) {
            System.out.println("Deleting Agent");
            delete.setString(1, code);
            result=delete.executeUpdate();
        }
        return result;
    }
//        public static List<Agents> updateAgents (String name,String location, Double commission) throws SQLException, ClassNotFoundException {
//            String sql3 = "UPDATE Agents SET  location=?, commission=?, WHERE name=?";
//            Connection con4 = ConnectionHelper.getMSSQLConnection();
//            try (PreparedStatement update = con4.prepareStatement(sql3)) {
//                System.out.println("Deleting Agent");
//                update.executeUpdate(sql3);
//                update.setString(1, location);
//                update.setDouble(2,commission);
//                return ;
//            }
//        }
}

