package org.devops

//格式化输出-->信息和颜色传参
def PrintMes(value,color){
    //定义字典
    colors = ['red'   : "\033[40;31m >>>>>>>>>>>${value}<<<<<<<<<<< \033[0m",
              'blue'  : "\033[34m ${value} \033[0m",
              'green' : "[1;32m>>>>>>>>>>${value}>>>>>>>>>>[m",
              'green1' : "\033[40;32m >>>>>>>>>>>${value}<<<<<<<<<<< \033[0m" ]
    //调用
    ansiColor('xterm') {
        println(colors[color])
    }
}
