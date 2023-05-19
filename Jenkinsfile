pipeline {
    agent any

    options {
        // Skip running the pipeline for all branches except 'main'
        skipDefaultCheckout(true)
    }

    triggers {
        githubPush()
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout source code repository
                git branch:  'main', url: 'https://github.com/The-Garage-Project/garage-devops.git'
            }
        }

        stage('Build') {
            steps {
                // Compile and build application
                sh 'export MAVEN_HOME=/opt/maven'
                sh 'export PATH=$PATH:$MAVEN_HOME/bin'
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Package') {
            steps {
                // Package application
                sh 'mvn package'
            }
        }
    }

    post {
        always {
            // Archive build artifacts or perform cleanup tasks
            archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
        }

        success {
            // Perform actions when the build is successful
            echo 'Build successful!'
        }

        failure {
            // Perform actions when the build fails
            echo 'Build failed!'
        }
    }
}
