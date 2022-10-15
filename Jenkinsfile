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
                   pwd
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
    docker.withRegistry('https://registry.hub.docker.com', 'docker-jenkins') {

                def customImage = docker.build("soloworld/books:latest")

                /* Push the container to the custom Registry */
                customImage.push()
            }
        }
    }

}

}
}
