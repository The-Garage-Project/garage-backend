pipeline {
    agent any

    stages {
        stage('Checkout Backend') {
            steps {
                git branch:  'main', url: 'https://github.com/The-Garage-Project/garage-backend.git'
            }
        }

        stage('Build Backend Maven') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Build Backend Docker') {
            steps {
                dockerImage = docker.build("spyrosmoux/garage-backend:latest")
            }
        }

        stage('Push Backend Docker') {
            steps {
                withDockerRegistry([ credentialsId: "DOCKERHUB_CREDENTIALS", url: "" ]) {
                        dockerImage.push()
                }
            }
        }
    }

    post {
        always {
            sh 'docker logout'
        }

        success {
            echo 'Build successful!'
        }

        failure {
            echo 'Build failed!'
        }
    }
}