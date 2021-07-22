package com.converted.elasticsearch.ml._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._xpack.usage.types.{ UrlConfig }

@JsonCodec case class CustomSettings(
	custom_urls: Array[UrlConfig], 
	created_by: String, 
	job_tags: Dictionary[String, String]
)
