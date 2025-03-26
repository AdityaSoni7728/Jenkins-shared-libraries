def call(String Project, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'dockerhubPass', usernameVariable: 'dockerHubUser')]) {
      sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
  }
  sh "docker push ${dockerHubUser}/${Project}:${ImageTag}"
}
