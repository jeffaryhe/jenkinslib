#!groovy

//构建类型
def Build(buildType,buildShell){    
      def buildTools = ["MAVEN":"mvn","ANT":"ant","GRADLE":"gradle","NPM":"npm"]
      
      println("当前选择的构建类型为${buildType}")
      buildHome = tool buildTools[buildType]
      sh "${buildHome/bin/${buildType} ${buildShell}"
}
