package com.converted.elasticsearch.cat._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.behaviors.{ CommonCatQueryParameters }
import com.converted.elasticsearch._types.Base.{ RequestBase }

@JsonCodec case class CatRequestBase extends RequestBase, CommonCatQueryParameters

