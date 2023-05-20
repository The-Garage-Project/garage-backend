pipeline {
    agent any

    environment {
        DOCKER_CREDENTIALS = credentials('DOCKER_CREDENTIALS')
    }

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

        stage('Build Docker Image') {
            steps {
                sh 'echo $DOCKER_CREDENTIALS_PWD | docker login -u$DOCKER_CREDENTIALS_USR --password-stdin'
                sh 'docker build -t spyrosmoux/garage-backend:latest .'
            }
        }

        stage('Push Docker Image') {
            steps {
                sh 'docker push spyrosmoux/garage-backend:latest'
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