pipeline {
agent  any

stages {

stage ("checkout") {
    steps {
    echo "checking out from git hub"
    checkout([$class: 'GitSCM', branches: [[name: '*/container']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/soloworldsolo/books.git']]])

    }

}
stage("compile") {

    steps {
      echo "mvn clean install"

      }
}
}

}