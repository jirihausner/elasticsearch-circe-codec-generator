package com.converted.elasticsearch.nodes.hot_threads

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Id, Name }
import com.converted.elasticsearch._types.Networking.{ Host }

@JsonCodec case class HotThread(
	hosts: Array[Host], 
	node_id: Id, 
	node_name: Name, 
	threads: Array[String]
)
