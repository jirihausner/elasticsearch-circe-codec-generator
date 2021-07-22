package com.converted.elasticsearch.ml._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ Id, Name }
import com.converted.elasticsearch._types.Networking.{ TransportAddress }

@JsonCodec case class DiscoveryNode(
	attributes: Dictionary(String, String), 
	ephemeral_id: Id, 
	id: Id, 
	name: Name, 
	transport_address: TransportAddress
)
