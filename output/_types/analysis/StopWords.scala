package com.converted.elasticsearch._types.analysis

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

type StopWords = String | Array[String]
