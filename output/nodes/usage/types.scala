package com.converted.elasticsearch.nodes.usage

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch._types.Time.{ EpochMillis }

@JsonCodec case class NodeUsage(
	rest_actions: Dictionary(String, integer), 
	since: EpochMillis, 
	timestamp: EpochMillis, 
	aggregations: Dictionary(String, UserDefinedValue)
)
