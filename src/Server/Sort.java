package Server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("Sort")
public class Sort {
    @GET
    public String sort(){
        return "Aqui devuelvo la lista ordenada";
    }
}
