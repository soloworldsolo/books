pipeline {
agent  any

tools {
        maven 'maven'
        jdk 'java17'
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

stage('Build Docker Image') {

    steps {
    script {
    def image =docker.build("books")
          image.push()
    }

    }
}

}

