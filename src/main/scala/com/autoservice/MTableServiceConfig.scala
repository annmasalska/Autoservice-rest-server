package com.timetable

import com.twitter.conversions.time._


class MTableServiceConfig {

  // ------------ PB Service ------------
  var name = "autoservice"

  var version = "0.1.0" //getClass.getPackage.getImplementationVersion

  // ------------ Thrift ------------
  //var thriftPort: Int = 9015

  // ------------ DB ------------
  var cassandraCluster = "Test Cluster"
  var cassandraKeyspace = "autoservice"
  var cassandraSeeds = "127.0.0.1:9160"
  var cassandraProcessingTimeout = 150.seconds //2800.milliseconds

  //def apply(twitterServer: TwitterServer) = new ThresholdsThriftService(this, twitterServer)

}
