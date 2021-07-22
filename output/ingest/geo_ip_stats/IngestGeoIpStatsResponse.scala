package com.converted.elasticsearch.ingest.geo_ip_stats

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ Id }
import com.converted.elasticsearch.ingest.geo_ip_stats.{ GeoIpDownloadStatistics, GeoIpNodeDatabases }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		stats: GeoIpDownloadStatistics, 
		nodes: Dictionary[Id, GeoIpNodeDatabases]
	)
}

