pipeline {
    agent any

    tools {
        maven '3.9.2'
    }

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
                sh 'docker build -t spyrosmoux/garage-backend:latest .'
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'DOCKER_CREDENTIALS', passwordVariable: 'DOCKER_CREDENTIALS_PSW', usernameVariable: 'DOCKER_CREDENTIALS_USR')]) {
                        	sh "docker login -u ${env.DOCKER_CREDENTIALS_USR} -p ${env.DOCKER_CREDENTIALS_PSW}"
                          sh 'docker push spyrosmoux/garage-backend:latest'
                        }
            }
        }
    }

    post {
        always {
            sh 'ansible-playbook playbook.yaml -u devops'
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