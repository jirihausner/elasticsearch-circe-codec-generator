package com.converted.elasticsearch._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

type short = Numeric
type byte = Numeric
type integer = Numeric
type uint = Numeric
type long = Numeric
type ulong = Numeric
type float = Numeric
type double = Numeric
type Percentage = String | float
