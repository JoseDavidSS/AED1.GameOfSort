package Server;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;

@ApplicationPath("GOS")
public class GOS {
    @GET
    public String main(){
        return "Server Configurado";
    }
}
