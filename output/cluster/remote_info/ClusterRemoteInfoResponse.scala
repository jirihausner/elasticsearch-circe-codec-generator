package com.converted.elasticsearch.cluster.remote_info

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ DictionaryResponseBase }
import com.converted.elasticsearch._types.Numeric.{ integer, long }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Response extends DictionaryResponseBase(String, ClusterRemoteInfo)

@JsonCodec case class ClusterRemoteInfo(
	connected: Boolean, 
	initial_connect_timeout: Time, 
	max_connections_per_cluster: integer, 
	num_nodes_connected: long, 
	seeds: Array(String), 
	skip_unavailable: Boolean
)
