package org.devops

//ansible deploy
def AnsibleDeploy(hosts,func){
   sh "ansible ${hosts} ${func} "
}
