#!groovy
@Library('jenkinslib') _

def message = new org.devops.tools()

String workspace = "/opt/jenkins/workspace"

hello()

//Pipeline
pipeline {
    agent { node {  label "build"   //指定运行节点的标签或者名称
                    customWorkspace "${workspace}"   //指定运行工作目录（可选）
            }
    }

    options {
        timestamps()  //日志会有时间
        skipDefaultCheckout()  //删除隐式checkout scm语句
        disableConcurrentBuilds() //禁止并行
        timeout(time: 1, unit: 'HOURS')  //流水线超时设置1h
    }

    parameters { string(name: 'tomcat', defaultValue: 'tomcat-jdk-1.8', description: '') }

    
    stages {
        //下载代码
        stage("GetCode"){ //阶段名称
            when { environment name: 'tomcat', value: 'tomcat-jdk-1.8' }
            steps{  //步骤
                timeout(time:5, unit:"MINUTES"){   //步骤超时时间
                    script{ //填写运行代码
                        println('获取代码')
                        message.PrintMes("获取代码",'red')
                        println("${tomcat}")
                        input id: 'Test', message: '我们是否需要继续', ok: '是的，正在开始', parameters: [choice(choices: ['v1', 'v2'], description: '', name: 'test')], submitter: 'jeff,admin'
                    }
                }
            }
        }

        stage("build-and-scan"){
            failFast true
            parallel {
        
                //构建
                stage("Build"){
                    steps{
                        timeout(time:20, unit:"MINUTES"){
                            script{
                                println('应用打包')
                                message.PrintMes("应用打包",'green')
                                println("${nginx}")
                                println("${tomcat}")
                                mvnHome = tool "mvn"
                                println("${mvnHome}")
                                sh "${mvnHome} --version"
                                
                            }
                        }
                    }
                }
        
                //代码扫描
                stage("CodeScan"){
                    steps{
                        timeout(time:30, unit:"MINUTES"){
                            script{
                                print("代码扫描")
                                message.PrintMes("代码扫描",'green')
                            }
                        }
                    }
                }
            }
        }
    }

    //构建后操作
    post {
        always {
            script{
                println("always")
            }
        }

        success {
            script{
                currentBuild.description = "\n 构建成功!" 
            }
        }

        failure {
            script{
                currentBuild.description = "\n 构建失败!" 
            }
        }

        aborted {
            script{
                currentBuild.description = "\n 构建取消!" 
            }
        }
    }
}

