package newpackage;

import com.mongodb.CommandResult;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;

/**
 * This class is MongoDB Resource Handler
 *
 * @author Yusuf ÖNDER
 * @version 1.0
 */
public class Main {

    private MongoClient client;
    private String host;

    /**
     *
     */
    public Main() {
        host = "edsoft-work:27020";
    }

    /**
     * Get all shards in this host.
     *
     * @return String All Shards
     * @throws UnknownHostException
     */
    public String getListShards() throws UnknownHostException {
        client = new MongoClient(host);
        String a = client.getDB("admin").command("listShards").toString();
        client.close();
        return a;
    }

    /**
     * Get all databases in this host
     *
     * @return CommandResult All Databases
     * @throws UnknownHostException
     */
    public CommandResult getListDatabases() throws UnknownHostException {
        client = new MongoClient(host);
        return client.getDB("admin").command("listDatabases");
    }

    /**
     * Get MongoDB system info
     *
     * @return CommandResult System Build Info
     * @throws UnknownHostException
     */
    public CommandResult getBuildInfo() throws UnknownHostException {
        client = new MongoClient(host);
        return client.getDB("admin").command("buildInfo");
    }

    /**
     * Get number of open connections the current system, including client
     * connections and server-to-server connections
     *
     * @return CommandResult All Connection Information
     * @throws UnknownHostException
     */
    public CommandResult getConnPoolStats() throws UnknownHostException {
        client = new MongoClient(host);
        return client.getDB("admin").command("connPoolStats");
    }

    /**
     * Get db information the current system. In all shards and replicas
     *
     * @return CommandResult Show all DB's statuses
     * @throws UnknownHostException
     */
    public CommandResult getDBStatus() throws UnknownHostException {
        client = new MongoClient(host);
        return client.getDB("admin").getStats();
    }

    /**
     * 
     * @return @throws UnknownHostException
     */
    public CommandResult getNetstat() throws UnknownHostException {
        client = new MongoClient(host);
        return client.getDB("admin").command("netstat");
    }

    /**
     * Get client URI Information
     * @return CommandResult 
     * @throws UnknownHostException
     */
    public CommandResult getswhatsmyuri() throws UnknownHostException {
        client = new MongoClient(host);
        return client.getDB("admin").command("whatsmyuri");
    }

    /**
     *
     * @return @throws UnknownHostException
     */
    public CommandResult getHostInfo() throws UnknownHostException {
        client = new MongoClient(host);
        return client.getDB("admin").command("hostInfo");
    }

    /**
     *
     * @return @throws UnknownHostException
     */
    public Object getAsserts() throws UnknownHostException {
        client = new MongoClient(host);
        return client.getDB("admin").command("serverStatus").get("asserts");
    }

    /**
     *
     * @return @throws UnknownHostException
     */
    public CommandResult getServerStatus() throws UnknownHostException {
        client = new MongoClient(host);
        return client.getDB("admin").command("serverStatus");
    }

    /**
     *
     * @return @throws UnknownHostException
     */
    public Object getMem() throws UnknownHostException {
        client = new MongoClient(host);
        return client.getDB("admin").command("serverStatus").get("mem");
    }
}
