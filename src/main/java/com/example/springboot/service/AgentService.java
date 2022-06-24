package com.example.springboot.service;

import com.example.springboot.DataAccessObject.AgentsDAO;
import com.example.springboot.domain.Agents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AgentService {

    @Autowired
    AgentsDAO agentsDao;

    public List<Agents> getAgents() throws SQLException, ClassNotFoundException {
        return agentsDao.getAgents();
    }

        public List<Agents> insertAgents(String code, String name, String location, Double commission) throws SQLException, ClassNotFoundException {
            agentsDao.insertAgents(code,name,location,commission);
            return agentsDao.getAgents();
        }

        public List<Agents> deleteAgents(String code) throws SQLException, ClassNotFoundException {
            agentsDao.deleteAgents(code);
            return agentsDao.getAgents();
        }
//
//    public List<Agents> updateAgents(String name, String location,Double commission) throws SQLException, ClassNotFoundException{
//            return agentsDao.updateAgents(name,location,commission);
//    }
    }