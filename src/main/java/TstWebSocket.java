import java.net.URI;
import java.net.URISyntaxException;

import org.json.JSONArray;
import org.json.JSONObject;

// Based on:
// https://stackoverflow.com/questions/26452903/javax-websocket-client-simple-example
//

public class TstWebSocket {
    public static void main(String[] args) {
        String message;
        JSONObject objS, objR;

/*
var spSetup = {
requestId: 0, // уникальный идентификатор запроса, unsigned int32
fStart: 1000000000, // начало диапазона сканирования Гц, unsigned int32
fEnd: 1000100000, // конец диапазона сканирования Гц, unsigned int32
rbw: 2, // разрешение по частоте (0…4), unsigned int8
video: 100, // видеофильтр 0.1…6400 Гц, float
atten: 0 // аттенюация (0…6), unsigned int8
mode: 1, // режим unsigned int8
};
*/
        objS = new JSONObject();
        objS.put("requestId", "0");
        objS.put("fStart", "1000000000");
        objS.put("fEnd", "1000100000");
        objS.put("rbw", "2");
        objS.put("video", "100");
        objS.put("atten", "0");
        objS.put("mode", "1");
        message = objS.toString();
        System.out.println(message);


        objR = new JSONObject(message);
        System.out.println("mode: " + objR.getInt("mode"));
        System.out.println("requestId: " + objR.getInt("requestId"));
        System.out.println("rbw: " + objR.getInt("rbw"));
        System.out.println("atten: " + objR.getInt("atten"));
        System.out.println("fStart: " + objR.getInt("fStart"));
        System.out.println("fEnd: " + objR.getInt("fEnd"));
        System.out.println("video: " + objR.getInt("video"));

/*
Var spResult = {
requestId: 3, // повторяет идентификатор в запросе, unsigned int32
fStart: 1000000000, // действительная нач. частота Гц, unsigned int32
fEnd: 1000100000, // действительная конечная частота Гц, unsigned int32
totalFreqPointsInChart: 555646131 // всего точек в графике, unsigned int32
frameFirstPointIndex: 12313413 // индекс первой точки данных этого фрагмента
data: [] // массив значений уровня сигнала
};
*/

        message = "{\"requestId\":3,\"fStart\":1000000000,\"fEnd\":1000100000,\"totalFreqPointsInChart\":4, \"frameFirstPointIndex\":5000,\"data\":[10.20, 10.1, 13.55, 18.56]}";
        objR = new JSONObject(message);
        System.out.println("requestId: " + objR.getInt("requestId"));
        System.out.println("fStart: " + objR.getInt("fStart"));
        System.out.println("fEnd: " + objR.getInt("fEnd"));
        System.out.println("totalFreqPointsInChart: " + objR.getInt("totalFreqPointsInChart"));
        System.out.println("frameFirstPointIndex: " + objR.getInt("frameFirstPointIndex"));
        System.out.println("data: " + objR.getJSONArray("data"));

        JSONArray array = objR.getJSONArray("data");
        for (int i = 0; i < array.length(); i++) {
            System.out.println(i + ": " + array.getBigDecimal(i));
        }

        /*try {
            // open websocket
            final WebSocketClientMine clientEndPoint = new WebSocketClientMine(new URI("wss://192.168.0.100:8080"));

            // add listener
            clientEndPoint.addMessageHandler(new WebSocketClientMine.MessageHandler() {
                public void handleMessage(String message) {
                    System.out.println(message);
                }
            });

            // send message to websocket
            clientEndPoint.sendMessage(message);

            // wait 5 seconds for messages from websocket
            Thread.sleep(5000);

        } catch (InterruptedException ex) {
            System.err.println("InterruptedException exception: " + ex.getMessage());
        } catch (URISyntaxException ex) {
            System.err.println("URISyntaxException exception: " + ex.getMessage());
        }*/
    }
}
