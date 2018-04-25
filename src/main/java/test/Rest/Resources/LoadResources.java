package test.Rest.Resources;

import test.Dao.Hibernate.Entities.LinesEntities;
import test.Dao.Hibernate.Service.LineService;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/loadFile")
public class LoadResources {

    private LineService lineService = new LineService();
    private List<LinesEntities> linesList;

    private Map<String, Map<String, String[]>> map;

    @POST
    @Path("/statistic")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Map<String, String[]>> getStatistic(){
        System.out.println("OLOLOLOLOLOLOLOLOOLOLOLO");
        linesList = lineService.getAllLines();
        map = generateAnswer(linesList);
        return map;
    }

    private Map<String, Map<String, String[]>> generateAnswer(List<LinesEntities> list){
        Map<String, Map<String, String[]>> map = new HashMap<>();
        for (LinesEntities el : list){
            Map<String, String[]> mapStatistic = new HashMap<>();
            String[] mass = {el.getShortestLetter(), el.getMidLetter(), el.getLongestLetter()};

            mapStatistic.put(el.getLine(), mass);
            map.put(el.getFile().getName(), mapStatistic);
        }
        return map;
    }

}
