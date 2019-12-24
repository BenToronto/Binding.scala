parallelExecution in Global := false

lazy val SafeBuffer = crossProject.crossType(CrossType.Pure)

lazy val Binding = crossProject.crossType(CrossType.Pure).dependsOn(SafeBuffer)

lazy val FutureBinding = crossProject.crossType(CrossType.Pure).dependsOn(Binding)

lazy val dom = project.dependsOn(BindingJS).dependsOn(XmlExtractorJS)

lazy val Route = project.dependsOn(BindingJS)

lazy val JsPromiseBinding = project.dependsOn(BindingJS)

lazy val SafeBufferJS = SafeBuffer.js

lazy val SafeBufferJVM = SafeBuffer.jvm

lazy val BindingJS = Binding.js

lazy val BindingJVM = Binding.jvm

lazy val FutureBindingJS = FutureBinding.js

lazy val FutureBindingJVM = FutureBinding.jvm

lazy val XmlExtractor = crossProject.crossType(CrossType.Pure)

lazy val XmlExtractorJS = XmlExtractor.js

lazy val XmlExtractorJVM = XmlExtractor.jvm

lazy val fxml = crossProject.crossType(CrossType.Pure).dependsOn(Binding, XmlExtractor)

lazy val fxmlJS = fxml.js

lazy val fxmlJVM = fxml.jvm

organization in ThisBuild := "com.thoughtworks.binding"

publish / skip := true

enablePlugins(ScalaUnidocPlugin)

ScalaUnidoc / unidoc / unidocProjectFilter := {
  inAnyProject -- inProjects(SafeBufferJVM, XmlExtractorJVM, BindingJVM, FutureBindingJVM, fxmlJS)
}

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)

scalacOptions += "-Xexperimental"
