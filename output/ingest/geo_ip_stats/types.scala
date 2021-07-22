package com.converted.elasticsearch.ingest.geo_ip_stats

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Name }
import com.converted.elasticsearch._types.Numeric.{ integer }

@JsonCodec case class GeoIpDownloadStatistics(
	successful_downloads: integer, 
	failed_downloads: integer, 
	total_download_time: integer, 
	database_count: integer, 
	skipped_updates: integer
)

@JsonCodec case class GeoIpNodeDatabases(
	databases: Seq[GeoIpNodeDatabaseName], 
	files_in_temp: Seq[String]
)

@JsonCodec case class GeoIpNodeDatabaseName(
	name: Name
)
