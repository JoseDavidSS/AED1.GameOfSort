package Server;

import Logic.Lists.SendList;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class mainTest {

    public static void main(String[] args) throws IOException{
        SendList hola = Server.generate(100);
        hola.printAge();
        hola = Server.sort(hola);
        hola.printAge();
        hola = Server.sort(hola);
        hola.printRSpeed();
    }
}
