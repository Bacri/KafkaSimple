name := "KafkaProject1"

version := "0.1"

scalaVersion := "2.12.8"
scalacOptions ++= Seq("-language:implicitConversions", "-deprecation")
libraryDependencies ++= Seq(
  "com.novocode" % "junit-interface" % "0.11" % Test,
  ("org.apache.spark" % "spark-sql-kafka-0-10_2.12" % "3.1.2")
)
