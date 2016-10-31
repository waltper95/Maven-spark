package pe.ulima.edu.appm;

import java.util.HashMap;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import static spark.Spark.get;
import static spark.Spark.post;

public class Main {
    
    public static void main(String[] args){
//        get("/cursos",new Route() {
//            @Override
//            public Object handle(Request rqst, Response rspns) throws Exception {
//                return "Hola";
//            }
//        } );
        
        get("/parar", (req, resp) -> {
            Spark.stop();
            return "";
        });        
        get("/cursos", (rqst,rspns) ->{
            return "<h1>HOLA</h1>";
        } );
        
        post("cursos", (req,resp) -> {
            String cuerpo = req.body();
            return "Ok";
        });
        
        get("/web", (req,resp) -> {
            HashMap<String,Object> params = new HashMap<>();
            params.put("nombre", "pepito");
            
            return new ModelAndView(params, "index.ftl");
        }, new FreeMarkerEngine());
        
    };
    
    
}
