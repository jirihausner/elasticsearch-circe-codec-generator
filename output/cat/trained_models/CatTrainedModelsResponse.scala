package com.converted.elasticsearch.cat.trained_models

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.cat.trained_models.{ TrainedModelsRecord }

@JsonCodec case class Response(
	body: Seq[TrainedModelsRecord]
)
