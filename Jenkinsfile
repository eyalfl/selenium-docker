pipeline {
    agent none
    stages {
        stage('Build Jar') {

            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        
        stage('Build Image') {
            steps {
                script {
                	bat "docker build -t='eyalfl/selenium-docker' ."
                }
            }
        }



        stage('Push Image') {
            steps {
			        withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass',  usernameVariable: 'user')]) {
			        	// sh
			        	bat "docker login --username=${user} --password=${pass}"
			        	bat "docker push eyalfl/selenium-docker:latest"
			        }
            }
        }
    }
}