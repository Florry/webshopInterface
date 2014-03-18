name := "webshopInterface"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  //javaJdbc,
  //javaEbean,
  javaJpa,
  cache
)  

libraryDependencies += "org.hibernate" % "hibernate-entitymanager" % "4.3.4"

play.Project.playJavaSettings
