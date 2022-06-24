package com.example.springboot.AgentController;

import com.example.springboot.domain.Agents;
import com.example.springboot.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;
@RestController
public class AgentController {

    @Autowired
    AgentService agentService;


    @GetMapping("/")
    public String index() {
        return "Agent Directory";
    }

    @GetMapping("/getAllAgents")
    public List<Agents> getAllAgents() {
        List<Agents> agents = null;
        try {
            agents = agentService.getAgents();
        } catch (Exception e) {
            System.out.println("Exception:" + e);
            throw new RuntimeException(e);
        }
        return agents;
    }


    @GetMapping("/getAllAgentsHTML")
    public String getAllAgentsAsHtml() {
        List<Agents> agents = null;
        try {
            agents = agentService.getAgents();
        } catch (Exception e) {
            System.out.println("Exception:" + e);
            throw new RuntimeException(e);
        }
        System.out.println("Agents:" + agents);
        Iterator it = agents.iterator();
        StringBuffer sbResult = new StringBuffer();
        sbResult.append("<html>");
        sbResult.append("<body>");
        while (it.hasNext()) {
            Agents agent = (Agents) it.next();
            sbResult.append("<h3>");
            sbResult.append(agent.getName());
            sbResult.append("</h3>");
        }
        sbResult.append("</body>");
        sbResult.append("</html>");
        return sbResult.toString();
    }

    @PostMapping("/insertAgents")
    public List<Agents> insertAgents(HttpServletRequest httpServletRequest) {
        List<Agents> agents = null;

        String code=httpServletRequest.getParameter("code");
        String name=httpServletRequest.getParameter("name");
        String location=httpServletRequest.getParameter("location");
        String commission=httpServletRequest.getParameter("commission");;
        System.out.println("INPUT Code:"+code);
        System.out.println("INPUT name:"+name);
        System.out.println("INPUT location:"+location);
        System.out.println("INPUT commission:"+commission);

        try {
            agents = agentService.insertAgents(code,name,location,Double.parseDouble(commission));
        } catch (Exception e) {
            System.out.println("Exception:" + e);
            throw new RuntimeException(e);
        }
        return agents;
    }
    @PostMapping ("/deleteAgents")
    public List<Agents> deleteAgents(@RequestParam String code){
        List<Agents> agents =null;
        //String code=httpServletRequest.getParameter("code");
        //HttpSession session= request.getSession();
        //session.putValue("code",code);
        try {
            agents = agentService.deleteAgents(code);
        } catch (Exception e) {
            System.out.println("Exception:" + e);
            throw new RuntimeException(e);
        }
        return agents;
    }
//    @PostMapping ("/updateAgents")
//    public List<Agents> updateAgents() {
//        List<Agents> agents = null;
//
//        try {
//            agents = agentService.updateAgents();
//        } catch (Exception e) {
//            System.out.println("Exception:" + e);
//            throw new RuntimeException(e);
//        }
//        return agents;
//    }
}