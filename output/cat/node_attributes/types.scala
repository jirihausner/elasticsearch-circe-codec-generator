package com.converted.elasticsearch.cat.node_attributes

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


@JsonCodec case class NodeAttributesRecord(
	node: String, 
	id: String, 
	pid: String, 
	host: String, 
	ip: String, 
	port: String, 
	attr: String, 
	value: String
)

