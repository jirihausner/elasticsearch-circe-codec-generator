package com.converted.elasticsearch._spec_utils

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Name }
import com.converted.elasticsearch._types.Networking.{ Host, Ip, TransportAddress }
import com.converted.elasticsearch._types.Node.{ NodeRoles }
import com.converted.elasticsearch._spec_utils.{ Dictionary }

@JsonCodec case class BaseNode(
	attributes: Dictionary[String, String], 
	host: Host, 
	ip: Ip, 
	name: Name, 
	roles: NodeRoles, 
	transport_address: TransportAddress
)
