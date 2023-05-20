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
                script {
                    // Authenticate with Docker Hub
                    docker.withRegistry('https://index.docker.io/v1/', 'DOCKER_CREDENTIALS') {
                        // Build the Docker image
                        def dockerImage = docker.build("spyrosmoux/garage-backend:latest")

                        // Tag the Docker image with latest
                        dockerImage.tag("spyrosmoux/garage-backend:latest")
                    }
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    // Authenticate with Docker Hub
                    docker.withRegistry('https://index.docker.io/v1/', 'DOCKER_CREDENTIALS') {
                        // Push the Docker image to Docker Hub
                        dockerImage.push()

                        // Push the latest tag to Docker Hub
                        dockerImage.push("spyrosmoux/garage-backend:latest")
                    }
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