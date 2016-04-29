
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;

public class TwoWaySSLClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SSLSocketFactory sslsocketfactory=(SSLSocketFactory) SSLSocketFactory.getDefault();
		
		try {  
            URL url = new URL("https://192.168.0.102/");  
            HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();  
            conn.setHostnameVerifier(new HostnameVerifier()   
		      {      
		                 //@Override  
		                 public boolean verify(String arg0, SSLSession arg1) {  
		                      return true;  
		                 }   
		      });   
            conn.setSSLSocketFactory(sslsocketfactory);  
            InputStream inputstream = conn.getInputStream();  
            InputStreamReader inputstreamreader = new InputStreamReader(inputstream);  
            BufferedReader bufferedreader = new BufferedReader(inputstreamreader);  
            String string = null;  
            while ((string = bufferedreader.readLine()) != null) {  
              System.out.println("Received " + string);  
            }  
       } catch (MalformedURLException e) {  
            e.printStackTrace();  
       } catch (IOException e) {  
            e.printStackTrace();  
       }  
	}

}
