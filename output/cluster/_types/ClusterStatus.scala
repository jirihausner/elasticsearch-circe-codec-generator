package com.converted.elasticsearch.cluster._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


object ClusterStatus extends Enumeration {
	type ClusterStatus = Value

	val green = Value(0, "green")
	val yellow = Value(1, "yellow")
	val red = Value(2, "red")
}

implicit val clusterStatusDecoder: Decoder[ClusterStatus.Value] = Decoder.decodeEnumeration(ClusterStatus)
implicit val clusterStatusEncoder: Encoder[ClusterStatus.Value] = Decoder.encodeEnumeration(ClusterStatus)
