package wirelessmesh.domain;

import javax.net.ssl.HttpsURLConnection;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * A LIFX restful client, for a bulb standing in for an addressable wireless mesh device.
 */
public class DeviceClient {

    public void toggleNightlight(String deviceId) throws IOException {
        URL url = new URL("https://api.lifx.com/v1/lights/" + deviceId + "/toggle");
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setRequestProperty("Authorization","Bearer " + MyToken.token);
        conn.setRequestProperty("Content-Type","application/json");
        conn.setRequestMethod("POST");

        conn.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.flush();
        wr.close();

        conn.getResponseCode();
    }
}
