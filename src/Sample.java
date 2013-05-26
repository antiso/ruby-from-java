import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class Sample {
    public static void main (String [] args) {
        Properties props = new Properties();
        try {
            props.load(Sample.class.getClassLoader().getResourceAsStream("ruby-from-java.properties"));

            String srvCommand = props.getProperty("ruby.command")+" drb_server.rb "
                    + props.getProperty("chef.node_name") + " "
                    + props.getProperty("chef.client_key") + " "
                    + props.getProperty("chef.server_url");
            Process p = Runtime.getRuntime().exec(srvCommand);

            BufferedReader in  = new BufferedReader(new InputStreamReader(p.getInputStream()));
            in.readLine();

            System.setProperty("jruby.home", props.getProperty("jruby.home"));
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("jruby");

            FileReader client_code = new FileReader("drb_client.rb");
            String [] result = (String []) engine.eval(client_code);
            System.out.println("\nNodes from Ruby script engine:");
            for (String node_name: result)
                System.out.println("Node: " + node_name);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ScriptException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }

}