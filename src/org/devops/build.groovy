package org.devops

//构建类型,定义一个方法Buiild,buildType从jenkins的传参中获取，buildshell从jenkins的传参中获取
def Build(buildType,buildShell){
      //定义一个buildTools,字典为所需构建工具。
      def buildTools = ["mvn":"mvn","ANT":"ant","GRADLE":"gradle","NPM":"npm"]
      
      println("当前选择的构建类型为 ${buildType}")
      //从git全局配置工具，获取构建工具的所在目录
      buildHome = tool buildTools[buildType]
      sh "${buildHome}/bin/${buildType} ${buildShell}"
}
