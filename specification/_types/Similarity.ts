/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

export enum DFIIndependenceMeasure {
  standardized = 0,
  saturated = 1,
  chisquared = 2
}

export enum DFRAfterEffect {
  no = 0,
  b = 1,
  l = 2
}

export enum DFRBasicModel {
  be = 0,
  d = 1,
  g = 2,
  if = 3,
  in = 4,
  ine = 5,
  p = 6
}

export enum IBDistribution {
  ll = 0,
  spl = 1
}

export enum IBLambda {
  df = 0,
  ttf = 1
}

export enum Normalization {
  no = 0,
  h1 = 1,
  h2 = 2,
  h3 = 3,
  z = 4
}
