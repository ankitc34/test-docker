pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
        agent {
                any {
                    image 'maven:3-alpine'
                    args '-v /C:/Users/DELL/.m2:/root/.m2'
                }
            }
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
			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
                    //sh
			        bat "docker login --username=${user} --password=${pass}"
			        bat "docker push ankitc34/test-docker:${BUILD_NUMBER}"
			        bat "docker push ankitc34/test-docker:latest"
			    }                           
            }
        }
    }
}