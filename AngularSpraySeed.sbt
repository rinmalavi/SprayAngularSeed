name := "Angular Spray Seed"

seq(Revolver.settings: _*)

net.virtualvoid.sbt.graph.Plugin.graphSettings

scalaVersion  := "2.10.3"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= Seq(
    "io.spray"            %   "spray-can"     % "1.2-RC2",
    "io.spray"            %   "spray-routing" % "1.2-RC2",
    "io.spray"            %%  "spray-json"    % "1.2.5",
    "io.spray"            %   "spray-testkit" % "1.2-RC2" % "test",
    "com.typesafe.akka"   %%  "akka-actor"    % "2.2.3",
    "com.typesafe.akka"   %%  "akka-testkit"  % "2.2.0"   % "test",
    "org.specs2"          %%  "specs2"        % "2.2.3"   % "test",
    "junit"               %   "junit"         % "4.11"    % "test"
  )

unmanagedSourceDirectories in Compile := (scalaSource in Compile).value :: Nil

unmanagedSourceDirectories in Test := (scalaSource in Test).value :: Nil

EclipseKeys.projectFlavor := EclipseProjectFlavor.Scala

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource
