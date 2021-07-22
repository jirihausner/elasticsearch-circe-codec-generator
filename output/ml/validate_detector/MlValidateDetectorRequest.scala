package com.converted.elasticsearch.ml.validate_detector

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ml._types.Detector.{ Detector }
import com.converted.elasticsearch._types.Base.{ RequestBase }

@JsonCodec case class Request(
	body: Detector
) extends RequestBase
