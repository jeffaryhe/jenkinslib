package org.devops

//构建类型,定义一个方法Build,buildType从jenkins的传参中获取，buildshell从jenkins的传参中获取
def Build(buildType,buildoptions){
      //定义一个list为所需构建工具。
      def buildTools = ["mvn":"mvn","ant":"ant","gradle":"gradle","npm":"npm"]      
      
      println("当前选择的构建类型为 ${buildType}")
	  
	  //从git全局配置工具，获取构建工具的所在目录
      buildHome = tool buildTools[buildType]
	  
      if ("${buildType}" == "npm"){
          sh """ export NODE_HOME=${buildHome} 
                 export PATH=\$NODE_HOME/bin:\$PATH 
                 ${buildHome}/bin/${buildType}  ${buildoptions}"""            
      } else {
			sh "${buildHome}/bin/${buildType}  ${buildoptions}"
	  }	  
}
