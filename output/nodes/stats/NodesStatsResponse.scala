package com.converted.elasticsearch.nodes.stats

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._nodes._types.NodesResponseBase.{ NodesResponseBase }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ Name }
import com.converted.elasticsearch.nodes.stats.{ Stats }

@JsonCodec case class Response(
	body: Body
) extends NodesResponseBase

object Response {
	@JsonCodec case class Body(
		cluster_name: Name, 
		nodes: Dictionary(String, Stats)
	)
}

