package test.rest.Resources;

import test.Dao.Hibernate.Entities.LinesEntities;
import test.Dao.Hibernate.Service.LineService;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path(value = "/loadFile")
public class LoadResources {

    private LineService lineService = new LineService();
    private List<LinesEntities> linesList;

    @Path(value = "/statistic")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStatistic(){
        linesList = lineService.getAllLines();
        return Response.status(Response.Status.OK).entity(generateAnswer(linesList)).build();
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
