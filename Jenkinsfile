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
                script {
			        withCredentials([usernamePassword(credentialsId: 'eyalfl', passwordVariable: 'Robot7249'  usernameVariable: 'eyalfl')]
			        	// sh
			        	bat "docker login --username=${user} --password=${pass}"
			        	bat "docker push eyalfl/selenium-docker:latest"

			        	app.push("${BUILD_NUMBER}")
			            app.push("latest")
			        }
                }
            }
        }
    }
}