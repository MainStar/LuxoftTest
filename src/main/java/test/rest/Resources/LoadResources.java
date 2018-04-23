package test.rest.Resources;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path(value = "/loadFile")
public class LoadResources {

    @Path(value = "/load")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Map<String, String[]>> getStatistic(){

    }

}
