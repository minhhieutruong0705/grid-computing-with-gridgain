import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteException;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.lang.IgniteClosure;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class CharactersCount {
    public static void main(String[] args) throws IgniteException {
        // Preparing IgniteConfiguration using Java APIs
        IgniteConfiguration cfg = new IgniteConfiguration();

        // The node will be started as a client node.
        cfg.setClientMode(true);

        // Classes of custom Java logic will be transferred over the wire from this app.
        cfg.setPeerClassLoadingEnabled(true);

        // Setting up an IP Finder to ensure the client can locate the servers.
        TcpDiscoveryMulticastIpFinder ipFinder = new TcpDiscoveryMulticastIpFinder();
        ipFinder.setAddresses(Collections.singletonList("127.0.0.1:47500..47509"));
        cfg.setDiscoverySpi(new TcpDiscoverySpi().setIpFinder(ipFinder));

        // Starting the node
        Ignite ignite = Ignition.start(cfg);

        // Executing custom Java compute task on every nodes.
        String inputString = "How many characters in this sentence?";
        Collection<Integer> res = ignite.compute(ignite.cluster()).apply(new RemoteTask(), Arrays.asList(inputString.split(" ")));

        System.out.println(">> Compute task is executed, check for output on the server nodes.");

        // Sum the results of executed tasks and print out the result
        int totalCount = res.stream().mapToInt(Integer::intValue).sum();

        System.out.println(">> Total characters of " + inputString +  ": " + totalCount);

        // Disconnect from the cluster.
        ignite.close();
    }

    /**
     * A compute tasks that counts the characters of a single word.
     */
    private static class RemoteTask implements IgniteClosure <String, Integer> {
        @Override
        public Integer apply(String word) {
            System.out.println(">> Counting characters of " + "\"" + word + "\"" + "...");
            Integer characterCount = word.length();
            System.out.println(">> Number of characters: " + characterCount);
            return characterCount;
        }
    }
}
