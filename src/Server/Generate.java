package Server;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;


@Path("Generate")

public class Generate{
    @GET
    public String generate(){
        return "Aqui devuelvo el xml de la lista de dragones";
    }
}
