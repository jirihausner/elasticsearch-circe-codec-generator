# elasticsearch-codec-generator
Converts Elasticsearch specification (TypeScript definitions) to equivalent Scala code with circe codecs.

## Required tools 

The following tools are needed to build generator:
* [sbt], to compile and assemble generator

## Steps

To build generator type following command:

```shell
sbt build
```

First we need to supply /specification folder with Elasticsearch TypeScript specification. Afterwards we run following command:

```shell
sbt run
```

Generated Scala code with circe codecs should be located in /output folder. 

## FAQ

TODO