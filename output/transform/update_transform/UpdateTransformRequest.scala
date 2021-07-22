package com.converted.elasticsearch.transform.update_transform

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._transform.put_transform.PutTransformRequest.{ Request as PutTransformRequest }

@JsonCodec case class Request extends PutTransformRequest
