package com.autoservice.storage;

import com.netflix.astyanax.AstyanaxContext;
import com.netflix.astyanax.Keyspace;
import com.netflix.astyanax.connectionpool.NodeDiscoveryType;
import com.netflix.astyanax.connectionpool.impl.ConnectionPoolConfigurationImpl;
import com.netflix.astyanax.connectionpool.impl.ConnectionPoolType;
import com.netflix.astyanax.connectionpool.impl.CountingConnectionPoolMonitor;
import com.netflix.astyanax.impl.AstyanaxConfigurationImpl;
import com.netflix.astyanax.thrift.ThriftFamilyFactory;
import com.timetable.MTableServiceConfig;
import com.twitter.logging.Logger;

public class TableStorage {

    public static final Logger log = Logger.get(TableStorage.class);

    protected MTableServiceConfig enrollRegionServiceConfig = new MTableServiceConfig();

    protected AstyanaxContext<Keyspace> context = new AstyanaxContext.Builder()
            .forCluster(enrollRegionServiceConfig.cassandraCluster())
            .forKeyspace(enrollRegionServiceConfig.cassandraKeyspace())
            .withAstyanaxConfiguration(
                    new AstyanaxConfigurationImpl()
                            .setDiscoveryType(NodeDiscoveryType.NONE)
                            .setConnectionPoolType(ConnectionPoolType.ROUND_ROBIN)
                            .setDiscoveryDelayInSeconds(10000)
                            .setDiscoveryDelayInSeconds(10000)
                            .setTargetCassandraVersion("1.2")
                            .setCqlVersion("3.1.1")
                    //.setDiscoveryType(NodeDiscoveryType.RING_DESCRIBE)
                    //.setConnectionPoolType(ConnectionPoolType.TOKEN_AWARE)
            )
            .withConnectionPoolMonitor(new CountingConnectionPoolMonitor())
            .withConnectionPoolConfiguration(new ConnectionPoolConfigurationImpl("connectionpool1")
                            .setPort(9160)
                            .setMaxOperationsPerConnection(10000)
                            .setMaxPendingConnectionsPerHost(20 /*20*/)
                            .setConnectionLimiterMaxPendingCount(20)
                            .setTimeoutWindow(10000)
                            .setConnectionLimiterWindowSize(2000)
                            .setMaxTimeoutCount(3)
                            .setConnectTimeout(4000 /*100*/)
                            .setConnectTimeout(4000 /*2000*/)
                            .setMaxFailoverCount(-1)
                            .setLatencyAwareBadnessThreshold(20)
                            .setLatencyAwareUpdateInterval(1000) // 10000
                            .setLatencyAwareResetInterval(10000) // 60000
                            .setLatencyAwareWindowSize(100) // 100
                            .setLatencyAwareSentinelCompare(100f).setSocketTimeout(30000)
                            .setMaxTimeoutWhenExhausted(10000)
                            .setInitConnsPerHost(1 /*10*/)
                            .setSeeds(enrollRegionServiceConfig.cassandraSeeds())
            )
            .withConnectionPoolMonitor(new CountingConnectionPoolMonitor())
            .buildKeyspace(ThriftFamilyFactory.getInstance());

    protected Keyspace keyspace = context.getClient();


    protected TableStorage() {
        context.start();
    }


    public void close() {
        context.shutdown();
    }

}
