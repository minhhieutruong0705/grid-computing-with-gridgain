import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.lang.IgniteRunnable;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;

import java.util.Collections;

public class MakeMeal {
    public static void main(String[] args) {
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

        String order = "Rice-MeatBall-MeatBall-CurrySauce";
        for (String option : order.split("-")) {
            switch (option) {
                case "MeatBall":
                    ignite.compute(ignite.cluster().forServers()).run(new PrepareMeatBall());
                    break;
                case "Rice":
                    ignite.compute(ignite.cluster().forServers()).run(new PrepareRice());
                    break;
                case "CurrySauce":
                    ignite.compute(ignite.cluster().forServers()).run(new PrepareCurrySauce());
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        System.out.println(">> Meal is ready!");

        // Disconnect from the cluster.
        ignite.close();
    }
    private static class PrepareMeatBall implements IgniteRunnable {
        @Override
        public void run() {
            System.out.println(">> Making a Meatball...");
            System.out.println(">> Meatball is ready!");
        }
    }

    private static class PrepareRice implements IgniteRunnable {
        @Override
        public void run() {
            System.out.println(">> Cooking Rice...");
            System.out.println(">> Rice is ready!");
        }
    }

    private static class PrepareCurrySauce implements IgniteRunnable {
        @Override
        public void run() {
            System.out.println(">> Making Curry Soup...");
            System.out.println(">> Curry Soup is ready!");
        }
    }
}
