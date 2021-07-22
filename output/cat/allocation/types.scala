package com.converted.elasticsearch.cat.allocation

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ ByteSize }
import com.converted.elasticsearch._types.Networking.{ Host, Ip }
import com.converted.elasticsearch._types.Numeric.{ Percentage }

@JsonCodec case class AllocationRecord(
	shards: String, 
	`disk.indices`: ByteSize, 
	`disk.used`: ByteSize, 
	`disk.avail`: ByteSize, 
	`disk.total`: ByteSize, 
	`disk.percent`: Percentage, 
	host: Host, 
	ip: Ip, 
	node: String
)

