pipeline {
agent  any

tools {
        maven 'Maven 3.8.1'
        jdk 'jdk17'
    }

stages {

stage('Initialize'){
 steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
}

stage ("checkout") {
    steps {
    echo "checking out from git hub"
    checkout([$class: 'GitSCM', branches: [[name: '*/container']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/soloworldsolo/books.git']]])

    }

}
stage("compile") {

    steps {
      echo "mvn clean install"

      sh 'mvn install'

      }
}
}

}