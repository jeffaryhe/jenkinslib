package org.devops

//ansible deploy
def AnsibleDeploy(test,func){
   sh "ansible ${func} ${hosts}"
}
