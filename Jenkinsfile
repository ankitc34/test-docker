pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //sh
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                //sh
                bat "docker build -t ankic34/test-docker ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'Sunank@20', usernameVariable: 'ankic34')]) {
                    //sh
			        bat "docker login --username=${user} --password=${pass}"
			        bat "docker push ankitc34/test-docker:latest"
			    }                           
            }
        }
    }
}