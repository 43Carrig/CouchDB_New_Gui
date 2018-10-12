import com.google.gson.JsonObject;
import org.lightcouch.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class CouchCRUD { // REST

    public static Response postToCouch(Car car) // post/create
    {
        CouchDbClient dbClient = new CouchDbClient();
        Response response = dbClient.save(car);
        dbClient.shutdown();
        return response;
    }

    public static Car getCarFromId(String id) // get/read
    {
        CouchDbClient dbClient = new CouchDbClient();
        try
        {
            Car foundCar = dbClient.find(Car.class,id);
            dbClient.shutdown();
            return foundCar;
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Unable to find car with id " + id);
        }
        return null;
    }

    public static void putCarDetails(Car car) //put/update 
    {
        CouchDbClient dbClient = new CouchDbClient();

        dbClient.update(car);
        dbClient.shutdown();
    }

    public static void deleteCar(String id)
    {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null,"delete all records for " + id + ". Do you want to continue?","Warning Message",dialogButton);

        if(dialogResult == JOptionPane.YES_OPTION)
        {
            CouchDbClient dbClient = new CouchDbClient();
            Car car = getCarFromId(id);

            if(car != null)
            {
                dbClient.remove(car);
                JOptionPane.showMessageDialog(null,"The car with matching id " + id + " has been deleted");
            }
        }
    }

    public static List<JsonObject> listAllDocs()
    {
        CouchDbClient dbClient = new CouchDbClient();

          List<JsonObject> allDocs = dbClient.view("_all_docs").includeDocs(true).query(JsonObject.class);
          if (allDocs.size()==0 || allDocs.equals(null)){
              System.out.print("Empty list");
          }

          return allDocs;

    }

    public static List<JsonObject> simpleMapReduce(String dbName)//String dbName
    {
        CouchDbClient dbClient = new CouchDbClient(dbName);//dbName

        /* MapReduce Design Document:
        {
          "_id": "_design/views",
          "_rev": "4-f74a20be55243a45bb3b4e9f2a7f2433",
          "views": {
            "byCarMake": {
              "map": "function(doc) {\r\n    emit(doc.carMake, 1);\r\n}",
              "reduce": "_count"
            },
            "byCarModel": {
               "map": "function(doc)" {if('Focus' in doc) { emit (doc.carModel, doc._id); }}"
            }
          },
          "language": "javascript"
        }
        */

        List<JsonObject> allDocs = dbClient.view("views/byCarMake").reduce(true).group(true).query(JsonObject.class);
        //List<JsonObject> stuff = dbClient.view("views/byCarModel").reduce(true).key("Ford Fiesta XXX").query(JsonObject.class);

        return allDocs;
    }


}
