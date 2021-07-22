package com.converted.elasticsearch.cat.plugins

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Name, NodeId, Type, VersionString }

@JsonCodec case class PluginsRecord(
	id: NodeId, 
	name: Name, 
	component: String, 
	version: VersionString, 
	description: String, 
	`type`: Type
)
