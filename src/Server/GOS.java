package Server;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.core.Application;

@ApplicationPath("GOS")
public class GOS extends Application {

    @GET
    public String main() {
        return "Server Configurado";
    }
}
